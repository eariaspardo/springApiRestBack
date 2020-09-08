package com.bolsadeideas.springboot.apirest.controllers;

import java.util.List;

import com.bolsadeideas.springboot.apirest.models.AuthenticationRequest;
import com.bolsadeideas.springboot.apirest.models.AuthenticationResponse;
import com.bolsadeideas.springboot.apirest.models.services.MyUserDetailsService;
import com.bolsadeideas.springboot.apirest.util.JwtUtil;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import com.bolsadeideas.springboot.apirest.models.entity.Cliente;
import com.bolsadeideas.springboot.apirest.models.services.IClienteService;

@CrossOrigin(origins = {"http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class ClienteRestController {
	
	@Autowired
	private IClienteService clienteService;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@GetMapping("/clientes")
	public List<Cliente> index(){
		return clienteService.findAll();
	}
	
	@GetMapping("/clientes/{id}")
	public Cliente show(@PathVariable(name = "id") Long id) {
		return clienteService.findById(id);
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED) // ==== retorna un estatus 201 de Created por defecto retona 200
	public Cliente create(@RequestBody Cliente cliente) { //==== @RequestBody, es para indicar que llega en formato JSON
		return clienteService.save(cliente);
	}
	
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id) {

		Cliente clienteActual = clienteService.findById(id); 		
		clienteActual.setNombre(cliente.getNombre());
		clienteActual.setApellido(cliente.getApellido());
		clienteActual.setEmail(cliente.getEmail());
		clienteActual.setNumeroTarjeta(cliente.getNumeroTarjeta());
		
		// ===== si el Id llega con un valor el metodo actualiza, si el Id llega sin valor el metodo guarda
		return clienteService.save(clienteActual); 
	}
	
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deteled(@PathVariable Long id) {
		clienteService.deleted(id);
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try{
			new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		} catch (BadCredentialsException e){
			throw new Exception("Incorrect User name or password", e);
		}
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		final String  jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
}
