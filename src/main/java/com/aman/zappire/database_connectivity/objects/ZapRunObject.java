package com.aman.zappire.database_connectivity.objects;

import java.util.UUID;

public class ZapRunObject {
	private UUID id;
	private String zapId;
	private String metadata;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getZapId() {
		return zapId;
	}
	public void setZapId(String zapId) {
		this.zapId = zapId;
	}
	public String getMetadata() {
		return metadata;
	}
	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}
	
	
}
