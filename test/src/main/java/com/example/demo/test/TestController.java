package com.example.demo.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@GetMapping(path="/insert")
	public @ResponseBody String insertTestData (@RequestParam String name) {
		
		TestEntity tempData = new TestEntity();
		tempData.setTestCd(testService.getMaxSeq());
		tempData.setTestNm(name);
		
		SimpleDateFormat sDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		tempData.setCretDt(sDate.format(new Date()));
		testService.testDataInsert(tempData);
		
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<TestEntity> getAllTestData() {
		return testService.dataSelect();
	}
}
