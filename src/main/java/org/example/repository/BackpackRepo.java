package org.example.repository;

import org.example.model.Backpack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BackpackRepo extends JpaRepository<Backpack,Long> {
    @Query(value = "SELECT COUNT(1) FROM backpack WHERE id=:backpackId",nativeQuery = true)
    int countItems(@Param("backpackId") Long backpackId);
}
