package com.aman.zappire.database_connectivity.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Trigger {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid")
	private UUID id;
	
	@OneToOne
	@JoinColumn(name = "zap_id",nullable = false, unique = true)
	private Zap zap;
	
	@ManyToOne
	@JoinColumn(name = "available_trigger_id")
	private AvailableTriggers availableTrigger;

	public Trigger(Zap zap, AvailableTriggers trigger) {
		super();
		this.zap = zap;
		this.availableTrigger = trigger;
	}

	public Trigger() {
		super();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Zap getZap() {
		return zap;
	}

	public void setZap(Zap zap) {
		this.zap = zap;
	}

	public AvailableTriggers getAvailableTrigger() {
		return availableTrigger;
	}

	public void setTriggerId(AvailableTriggers trigger) {
		this.availableTrigger = trigger;
	}
	
	
}
