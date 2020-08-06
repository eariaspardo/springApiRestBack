package com.bolsadeideas.springboot.apirest.models.services;

import java.util.List;

import com.bolsadeideas.springboot.apirest.models.entity.Cliente;

public interface IClienteService {

	public List<Cliente> findAll();
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void deleted(Long id);
	
	public Cliente update(Long id);
	
}
