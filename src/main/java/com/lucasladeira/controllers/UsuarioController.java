package com.lucasladeira.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasladeira.entities.Usuario;
import com.lucasladeira.services.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<Usuario>> getAll(){
		List<Usuario> usuarios = usuarioService.getAll();
		return ResponseEntity.ok().body(usuarios);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable Long id){
		Usuario usuario = usuarioService.getById(id);
		return ResponseEntity.ok().body(usuario);
	}
	
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody Usuario usuario){
		usuarioService.save(usuario);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Usuario usuario){
		usuarioService.update(id, usuario);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		usuarioService.delete(id);
		return ResponseEntity.ok().build();
	}
}
