package com.lucasladeira.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lucasladeira.entities.Telefone;
import com.lucasladeira.entities.Usuario;
import com.lucasladeira.repositories.TelefoneRepository;
import com.lucasladeira.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TelefoneRepository telefoneRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "fulano@gmail.com", "1234", "Fulano da Silva");
		
		Telefone t1 = new Telefone(null, "11987238211", u1);
		Telefone t2 = new Telefone(null, "1133203923", u1);
		
		u1.getTelefones().addAll(Arrays.asList(t1,t2));
		
		usuarioRepository.saveAll(Arrays.asList(u1));
		telefoneRepository.saveAll(Arrays.asList(t1, t2));
		
	}

}
