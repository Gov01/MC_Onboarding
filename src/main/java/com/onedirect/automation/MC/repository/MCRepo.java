package com.onedirect.automation.MC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.onedirect.automation.MC.model.MCModel;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface MCRepo extends JpaRepository<MCModel, Integer> {

	@Query(value="SELECT COUNT(brand_id) FROM bot_subscription WHERE brand_id=?1", nativeQuery=true)
	Integer findCountByBrandId(Integer brand_id);
	@Transactional
	@Modifying
	@Query(value="INSERT INTO `chat_settings`.`bot_subscription` (`id`, `brand_id`, `has_bot_subscription`, `status`, `created_at`, `updated_at`) VALUES (null, :brand_id, 1, 1, now(), now())", nativeQuery=true)
	Integer insertIntoBotSubscription(@Param("brand_id") Integer brand_id);

}
