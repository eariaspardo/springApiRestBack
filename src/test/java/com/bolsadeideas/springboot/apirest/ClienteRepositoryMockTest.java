package com.bolsadeideas.springboot.apirest;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.bolsadeideas.springboot.apirest.models.entity.Cliente;
import com.bolsadeideas.springboot.apirest.models.services.IClienteService;

@DataJpaTest
class ClienteRepositoryMockTest {

	
	@Autowired
	private IClienteService clienteService;
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Test
	void consultApiRestTest() {
		
		List<Cliente> found = clienteService.findAll();
		if (Assertions.assertThat(found.size()).isEqualTo(2) == null) {
        	log.info("==== TIENE MAS DE DOS DATOS =======================");
        }else{
        	log.info("==== TIENE DOS DATOS ===================================");
        };

		
	}

}
