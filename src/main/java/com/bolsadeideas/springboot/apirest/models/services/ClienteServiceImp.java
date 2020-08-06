package com.bolsadeideas.springboot.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.apirest.models.dao.IClienteDao;
import com.bolsadeideas.springboot.apirest.models.entity.Cliente;

@Service
public class ClienteServiceImp implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		clienteDao.save(cliente);
		return null;
	}

	@Override
	@Transactional
	public void deleted(Long id) {
		clienteDao.deleteById(id);
		
	}

	@Override
	@Transactional
	public Cliente update(Long id) {
		return null;
	}

}
