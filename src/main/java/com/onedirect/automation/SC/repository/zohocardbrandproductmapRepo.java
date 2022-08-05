package com.onedirect.automation.SC.repository;

import com.onedirect.automation.SC.model.roleviewproductmapModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface zohocardbrandproductmapRepo extends JpaRepository<roleviewproductmapModel, Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO `zoho_cards_brand_product_mapping` (`id`, `brand_id`, `card_id`, `product_id`, `status`, `created_at`, `created_by`, `updated_at`, `updated_by`) VALUES" +
            "(null, ?1, 1, 4, 1, now(), 93271, now(), 93271)," +
            "(null, ?1, 2, 4, 1, now(), 93271, now(), 93271)," +
            "(null, ?1, 3, 4, 1, now(), 93271, now(), 93271)," +
            "(null, ?1, 4, 4, 1, now(), 93271, now(), 93271);", nativeQuery = true)
    Integer zohobrandproductmappingValues(@Param("brand_id") Integer brand_id);

}

