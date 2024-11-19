package com.aman.zappire.database_connectivity.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aman.zappire.database_connectivity.db_repository.ZapRunRepository;
import com.aman.zappire.database_connectivity.entities.ZapRun;
import com.aman.zappire.database_connectivity.objects.ZapRunObject;

@RestController
public class Retrieval {
	
	@Autowired
	private ZapRunRepository zapRunRepo;
	
	//this controller sends the zapRun to the kafka consumer who demands it based on the message it gets on kafka
	@GetMapping(path="/retrieve/zapRun/{zapRunId}")
	public ResponseEntity<ZapRunObject> sendZapRun(@PathVariable String zapRunId){
		ZapRunObject obj=new ZapRunObject();
		
		ZapRun zapRun=zapRunRepo.findById(UUID.fromString(zapRunId)).orElse(null);
		
		if(zapRun!=null) {
			obj.setId(zapRun.getId());
			obj.setMetadata(zapRun.getMetadata().toString());
			obj.setZapId(zapRun.getZap().getId().toString());
		}
		return ResponseEntity.ok()
				.header("Content-Type", "application/json")
				.body(obj);
	}
}
