package com.mfpe;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertNotNull;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class AuditSeverityApplicationTests {	
	
	@Autowired
	AuditSeverityApplication auditSeverityApplication;
	
	@Test
	public void contextLoads(){
		assertNotNull(auditSeverityApplication);
	}

}
