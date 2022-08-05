package com.onedirect.automation.chatview.repository;

import com.onedirect.automation.chatview.model.chatviewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface chatviewRepo extends JpaRepository<chatviewModel,Void> {
    @Modifying
    @Transactional
    @Query(value = "CALL chat_view.`populate_default_view`(?1)", nativeQuery = true)
    Integer chatViewpopulateDefaultView(@Param("brand_id")Integer brand_id);
}
