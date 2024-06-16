package com.org.backendjava.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.backendjava.infra.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
}