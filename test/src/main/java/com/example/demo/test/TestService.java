package com.example.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	@Autowired
	TestRepository testRepository;
	
	public void testDataInsert(TestEntity testEntity) {
		testRepository.save(testEntity);
	}
	
	public Iterable<TestEntity> dataSelect() {
		return testRepository.findAll();
	}
	
	public Integer getMaxSeq() {
		return testRepository.getMaxSeq();
	}
}
