package org.example.repository;

import org.example.model.BackpackItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BackpackItemRepo extends JpaRepository<BackpackItem,Long> {
    @Query(value = "SELECT * FROM backpack_item WHERE backpack_id=:backpackId",nativeQuery = true)

    List<BackpackItem> findByBackpackId(@Param("backpackId") Long backpackId);
}
