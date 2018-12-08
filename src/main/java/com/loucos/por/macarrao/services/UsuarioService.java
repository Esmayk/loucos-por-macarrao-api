package com.loucos.por.macarrao.services;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loucos.por.macarrao.domain.Perfil;
import com.loucos.por.macarrao.domain.Usuario;
import com.loucos.por.macarrao.repositories.EnderecoRepository;
import com.loucos.por.macarrao.repositories.PerfilRepository;
import com.loucos.por.macarrao.repositories.PessoaRepository;
import com.loucos.por.macarrao.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private PerfilRepository perfilRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	public Usuario salvarUsuario(Usuario usuario) {
		pessoaRepository.save(usuario.getPessoa());
		enderecoRepository.saveAll(usuario.getPessoa().getEnderecos());
		Optional<Perfil> perfil = perfilRepository.findById(2L);
		usuario.setPerfis(Arrays.asList(perfil.get()));
		usuario.setAtivo(true);
		usuarioRepository.save(usuario);
		return usuario;
	}
}
