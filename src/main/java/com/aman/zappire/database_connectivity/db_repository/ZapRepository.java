package com.aman.zappire.database_connectivity.db_repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aman.zappire.database_connectivity.entities.Zap;

public interface ZapRepository extends JpaRepository<Zap, UUID>{

}
