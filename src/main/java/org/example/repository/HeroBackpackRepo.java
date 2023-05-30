package org.example.repository;

import org.example.model.Hero;
import org.example.model.HeroBackpack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeroBackpackRepo extends JpaRepository<HeroBackpack,Integer> {
    Optional<HeroBackpack> findByHeroId(int heroId);


    @Query(value = "select current_space from backpack where id=:id",nativeQuery = true)
    int showSpace(@Param("id")Long id);
}
