package com.onedirect.automation.embeddedAnalytics.repository;

import com.onedirect.automation.embeddedAnalytics.model.brandUserLicenseMapModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface brandUserLicenceMapRepo extends JpaRepository<brandUserLicenseMapModel, Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO `brand_user_license_mapping` (`id`, `brand_id`, `brand_user_id`, `license_key`, `status`, `created_at`, `created_by`, `updated_at`, `updated_by`) VALUES (null, :brand_id, :brand_user_id, 'trusteduserprod', 1, now(), 93271, now(), 93271);", nativeQuery = true)
    Integer insertbrandUserLicenceMap(@Param("brand_id") Integer brand_id, @Param("brand_user_id") Integer brand_user_id);
}
