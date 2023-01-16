package com.assessment.tennisstatsapi;

import static org.junit.jupiter.api.Assertions.assertNotNull;



import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;


import com.assessment.tennisstatsapi.service.PlayerService;

@SpringBootTest
class TennisStatsApiApplicationTests {


	
	@Test
	   void contextLoads(ApplicationContext applicationContext) {
		assertNotNull(applicationContext);
		assertNotNull(applicationContext.getBean(PlayerService.class));
		
	}
	

}
