package org.example.repository;

import org.example.model.Monster;
import org.example.model.Orygin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MonsterRepo extends JpaRepository<Monster,Integer> {
    List<Monster> findByOrygin(Orygin orygin);
    @Query(value = "SELECT * FROM MONSTER WHERE name=:name and orygin=:orygin",nativeQuery = true)
    Monster findByNameOrygin(@Param("name")String name,@Param("orygin")String orygin);
}
