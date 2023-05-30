package org.example.repository;

import org.example.model.Hero;
import org.example.model.HeroClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepo extends JpaRepository<Hero,Integer> {
    @Query(value = "SELECT COUNT(1) FROM hero WHERE name=:name and hero_class=:heroClass",nativeQuery = true)
    Integer exist(@Param("name")String name,@Param("heroClass") String heroClass);
    @Query(value = "update hero set gold=:gold where id=:id",nativeQuery = true)
    void setGold(@Param("gold")int gold ,@Param("id")int id);
    @Query(value = "SELECT * FROM hero WHERE name=:name and hero_class=:heroClass",nativeQuery = true)
    Hero findByNameAndHeroClass(@Param("name") String name,@Param("heroClass") String professy);
}
