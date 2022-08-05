package com.onedirect.automation.SC.repository;

import com.onedirect.automation.SC.model.roleviewproductmapModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface roleviewproductmapRepo extends JpaRepository<roleviewproductmapModel, Integer> {
	@Modifying
	@Transactional
	@Query(value="INSERT INTO `role_view_product_mapping` (`id`, `brand_id`, `brand_user_id`, `product_id`, `view_id`, `status`, `created_at`, `created_by`, `updated_at`, `updated_by`)  VALUES"+
	"(null, :brand_id, NULL, 4, 34, 1, now(), 93271, now(), 93271),"+
	"(null, :brand_id, NULL, 4, 35, 1, now(), 93271, now(), 93271),"+
	"(null, :brand_id, NULL, 4, 36, 1, now(), 93271, now(), 93271),"+
	"(null, :brand_id, NULL, 4, 37, 1, now(), 93271, now(), 93271),"+
	"(null, :brand_id, NULL, 4, 38, 1, now(), 93271, now(), 93271),"+
	"(null, :brand_id, NULL, 4, 39, 1, now(), 93271, now(), 93271);", nativeQuery = true)
	Integer insertRoleviewproductmappingValues(@Param("brand_id") Integer brand_id);

}

