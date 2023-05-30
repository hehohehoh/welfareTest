package com.example.demo.test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.Table;

import lombok.Data;

// @Table(name = "\"TEST_TABLE\"")
@Data
@Entity(name = "test_entity")
public class TestEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer testCd;
	
	private String testNm;
	private String cretDt; 
}
