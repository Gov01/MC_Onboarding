package com.onedirect.automation.onedirect.repository;

import com.onedirect.automation.onedirect.model.onedirectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface onedirectRepo extends JpaRepository<onedirectModel,Void>{
    @Query(value = "CALL enable_chat_1(?1,?2,'93271')", nativeQuery = true)
    Void onedirectEnableChat(@Param("brand_id")Integer brand_id,@Param("brand_user_id") String brand_user_id);
}
