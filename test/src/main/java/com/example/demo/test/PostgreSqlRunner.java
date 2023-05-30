package com.example.demo.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PostgreSqlRunner implements ApplicationRunner{

	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		try (Connection connection = dataSource.getConnection()) {
			System.out.println("dataSource.getClass() : " + dataSource.getClass());
			System.out.println("connection.getMetaData().getURL() : " + connection.getMetaData().getURL());
			System.out.println("connection.getMetaData().getUserName() : " + connection.getMetaData().getUserName());
			System.out.println("connection.getMetaData().getDriverName() : " + connection.getMetaData().getDriverName());
			
			Statement statement = connection.createStatement();
			// ResultSet rs = statement.executeQuery( "select * from public.\"TEST_TABLE\" ;" );
			ResultSet rs = statement.executeQuery( "select * from public.test_entity" );

		    while ( rs.next() ) {
		       String testCd = rs.getString("TEST_CD");
		       String testNm = rs.getString("TEST_NM");
		       String cretDt  = rs.getString("CRET_DT");
		       System.out.printf( "testCd = %s , testNm = %s, cretDt = %s ", testCd, testNm, cretDt );
		       System.out.println();
		    }

		    rs.close();
		    statement.close();
		    connection.close();
		}
		
	}
}
