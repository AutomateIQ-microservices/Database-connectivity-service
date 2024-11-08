package com.aman.zappire.database_connectivity.controllers;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aman.zappire.database_connectivity.db_repository.ZapRepository;
import com.aman.zappire.database_connectivity.db_repository.ZapRunOutboxRepository;
import com.aman.zappire.database_connectivity.db_repository.ZapRunRepository;
import com.aman.zappire.database_connectivity.entities.Zap;
import com.aman.zappire.database_connectivity.entities.ZapRun;
import com.aman.zappire.database_connectivity.entities.ZapRunOutbox;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class Hook {
	
	@Autowired
	private ZapRepository zapRepo;
	@Autowired
	private ZapRunRepository zapRunRepo;
	@Autowired
	private ZapRunOutboxRepository zapRunOutboxRepo;
	
	
	
	
	@PostMapping(path="/hooks/catch/{userId}/{zapId}")
	@Transactional
	public ResponseEntity<?> handleWebHook(
			@PathVariable String userId,
			@PathVariable String zapId,
			@RequestBody Map<String,Object>body){
		
		Zap zap=zapRepo.findById(UUID.fromString(zapId)).orElseThrow(()->new RuntimeException("Zap Not found"));
		
		ZapRun zapRun=new ZapRun();
		zapRun.setZap(zap);
		zapRun.setMetadata(new ObjectMapper().valueToTree(body));
		zapRun=zapRunRepo.save(zapRun);
		
		ZapRunOutbox zapRunOutbox=new ZapRunOutbox();
		zapRunOutbox.setZapRun(zapRun);
		zapRunOutboxRepo.save(zapRunOutbox);
		
		return ResponseEntity.ok()
				.header("Content-Type", "application/json")
	            .body(Map.of("message", "Webhook Received"));
	}
	
}
