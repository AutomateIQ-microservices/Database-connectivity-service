package com.aman.zappire.database_connectivity.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name="zaps")
public class Zap {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid")
	private UUID id;
	
	//private String triggerId;
	
	@OneToOne
	private Trigger trig;

	@OneToMany(mappedBy = "zapId")
	private List<Action> actions;
	
	public Zap() {
		super();
	}

	@OneToMany(mappedBy="zap")
	private List<ZapRun> zapRuns;
	
	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}



	public List<ZapRun> getZapRuns() {
		return zapRuns;
	}



	public void setZapRuns(List<ZapRun> zapRuns) {
		this.zapRuns = zapRuns;
	}



	public Zap(Trigger trig) {
		super();
		this.trig = trig;
	}



	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}


	public Trigger getTrig() {
		return trig;
	}

	public void setTrig(Trigger trig) {
		this.trig = trig;
	}
	
	
}