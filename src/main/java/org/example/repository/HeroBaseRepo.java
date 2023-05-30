package org.example.repository;

import org.example.model.HeroBase;
import org.example.model.HeroClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroBaseRepo extends JpaRepository<HeroBase,Long> {

    HeroBase findByHeroClass(HeroClass heroClass);
}
