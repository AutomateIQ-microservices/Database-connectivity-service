package com.aman.zappire.database_connectivity.db_repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aman.zappire.database_connectivity.entities.ZapRunOutbox;

public interface ZapRunOutboxRepository extends JpaRepository<ZapRunOutbox,UUID>{
	 Page<ZapRunOutbox> findAll(Pageable pageable);
}
