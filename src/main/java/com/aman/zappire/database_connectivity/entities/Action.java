package com.aman.zappire.database_connectivity.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Action {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //to auto generate uuid
	@Column(columnDefinition = "uuid")
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name="zap_id")
	private Zap zapId;
	
	@ManyToOne
	private AvailableActions actionId;

	public Action() {
		super();
	}

	public Action(Zap zapId, AvailableActions actionId) {
		super();
		this.zapId = zapId;
		this.actionId = actionId;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Zap getZapId() {
		return zapId;
	}

	public void setZapId(Zap zapId) {
		this.zapId = zapId;
	}

	public AvailableActions getActionId() {
		return actionId;
	}

	public void setActionId(AvailableActions actionId) {
		this.actionId = actionId;
	}
	
	
	
}
