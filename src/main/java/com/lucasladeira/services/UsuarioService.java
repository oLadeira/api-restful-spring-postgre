package com.lucasladeira.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasladeira.entities.Usuario;
import com.lucasladeira.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public List<Usuario> getAll(){
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios;
	}
	
	public Usuario getById(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.get();
	}
	
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public void update(Long id, Usuario usuario) {
		usuario.setId(id);
		usuarioRepository.save(usuario);
	}
}
