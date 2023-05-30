package com.example.demo.test;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<TestEntity, Integer>{

	@Query(" SELECT max(test_cd) + 1 FROM test_entity ")
	public Integer getMaxSeq();
}
