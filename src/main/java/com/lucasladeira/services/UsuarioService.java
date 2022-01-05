package com.lucasladeira.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasladeira.entities.Usuario;
import com.lucasladeira.repositories.UsuarioRepository;
import com.lucasladeira.services.exceptions.EntityNotFound;

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
		
		usuario.orElseThrow(() -> new EntityNotFound("Usuário não encontrado!"));
		
		return usuario.get();
	}
	
	public void save(Usuario usuario) {
		
		//for para salvar telefones quando for salvar usuario 
		for (int x=0; x < usuario.getTelefones().size(); x++) {
			usuario.getTelefones().get(x).setUsuario(usuario);
		}
		
		usuarioRepository.save(usuario);
	}
	
	public void update(Long id, Usuario usuario) {
		
		Optional<Usuario> us = usuarioRepository.findById(id);
		
		us.orElseThrow(() -> new EntityNotFound("Usuário não encontrado!"));
		
		for (int x=0; x < usuario.getTelefones().size(); x++) {
			usuario.getTelefones().get(x).setUsuario(usuario);
		}
		
		usuario.setId(id);
		usuarioRepository.save(usuario);
		
	}
	
	public void delete(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		usuario.orElseThrow(() -> new EntityNotFound("Usuário não encontrado!"));
		
		usuarioRepository.deleteById(id);
	}
}
