package com.org.backendjava.infra.interfaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.backendjava.infra.entity.PlayerDB;

@Repository
public interface IPlayerRepository extends JpaRepository<PlayerDB, String> {
}