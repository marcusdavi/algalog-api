package com.algaworks.algalog.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;

@RestController
public class ClienteController {

	
	@GetMapping("/clientes")
	public List<Cliente> lista() {
		Cliente cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Marcus");
		cliente1.setEmail("marcus@gmail.com");
		cliente1.setTelefone("71988884563");
		
		Cliente cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Susi");
		cliente2.setEmail("susi@gmail.com");
		cliente2.setTelefone("84988884563");
		
		return Arrays.asList(cliente1, cliente2);
	}
}
