package com.abhishek.DemoHibernateCaching;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

//@Entity(name = "alien_table")  //can change table name using @Table(name = <table_name>)
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Alien {	//POJO

	@Id
	private int aid;
	private String name;
	private String color;
	
	@OneToMany(mappedBy = "alien")
	private List<Laptop> lap = new ArrayList<Laptop>();
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public List<Laptop> getLap() {
		return lap;
	}
	public void setLap(List<Laptop> lap) {
		this.lap = lap;
	}
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", name=" + name + ", color=" + color + ", lap=" + lap + "]";
	}
	
	
}
