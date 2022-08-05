package com.onedirect.automation.controller;

import com.onedirect.automation.MC.repository.MCRepo;
import com.onedirect.automation.embeddedAnalytics.repository.brandUserLicenceMapRepo;
import com.onedirect.automation.SC.repository.roleviewproductmapRepo;
import com.onedirect.automation.SC.repository.zohocardbrandproductmapRepo;
import com.onedirect.automation.chatview.repository.chatviewRepo;
import com.onedirect.automation.onedirect.repository.onedirectRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;


@RestController
@CrossOrigin(origins = "*")
@Transactional
public class Controller {

	private static final Logger logger = LoggerFactory.getLogger(Controller.class);
	private RestTemplate restTemplate;

	@Value("${spring.application.name}")
	private String applicationName;

	public Controller(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	@Autowired
	MCRepo mcrepo;

	@Autowired
	roleviewproductmapRepo screpo;
	@Autowired
	onedirectRepo onedirectrepo;
	@Autowired
	chatviewRepo chatviewrepo;
	@Autowired
	zohocardbrandproductmapRepo zohorepo;

	@Autowired
	brandUserLicenceMapRepo licencerepo;

	// Brand_id and Brand_user_id should be sent in request, and store them in variables
	@GetMapping("/onboard")
	//localhost:8081/onboard?brand_id=456&brand_user_id=878
	public String multiValueQueryParam(@RequestParam(value="brand_id") Integer brandId, @RequestParam(value="brand_user_id") Integer brandUserId){
		//check if entry is present in database
		if(mcrepo.findCountByBrandId(brandId)!=0) {
			return "Brand Id " + brandId.toString() + " Already exist";
		}

		try {


		//Call strored procedure onedirect.enable_chat_1
		onedirectrepo.onedirectEnableChat(brandId, Integer.toString(brandUserId));

		//Insert into botSubscription
		Integer b=mcrepo.insertIntoBotSubscription(brandId);
		System.out.println(b.toString()+"Rows effected by insertIntoBotSubscription");

		//Insert into role view product mapping
		Integer a=screpo.insertRoleviewproductmappingValues(brandId);
		System.out.println(a.toString()+"Rows effected by inserting in RoleviewproductmappingValues");


		//call chat_view.`populate_default_view`(brand_id);
		Integer chatviewVar = chatviewrepo.chatViewpopulateDefaultView(brandId);
		System.out.println(chatviewVar.toString()+" returned from chatview populate proc");



		//Insert into brand user license mapping
		Integer brandUserLicenceVar= licencerepo.insertbrandUserLicenceMap(brandId,brandUserId);
		System.out.println(brandUserLicenceVar.toString()+" returned from brand_user_license insert ");



		//INSERT INTO `zoho_cards_brand_product_mapping`
		Integer zohoMapVar= zohorepo.zohobrandproductmappingValues(brandId);
		System.out.println(zohoMapVar.toString()+" returned from zoho_card brand product map insert ");

		//return brandId.toString() + " doesnt exist";
			JSONObject resp = new JSONObject();
			resp.put("status", "success");
			return String.valueOf(new ResponseEntity<String>(resp.toString(), HttpStatus.OK));
		} catch (Exception e) {
			JSONObject resp = new JSONObject();
			resp.put("status", "failure");
			resp.put("error", e.getLocalizedMessage());
			return String.valueOf(new ResponseEntity<String>(resp.toString(), HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}

}

