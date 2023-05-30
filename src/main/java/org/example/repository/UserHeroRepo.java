package org.example.repository;

import org.example.model.UserHero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHeroRepo extends JpaRepository<UserHero,Integer> {
}
