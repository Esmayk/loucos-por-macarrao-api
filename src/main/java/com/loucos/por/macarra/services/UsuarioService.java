package com.loucos.por.macarra.services;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loucos.por.macarra.domain.Perfil;
import com.loucos.por.macarra.domain.Usuario;
import com.loucos.por.macarra.repositories.EnderecoRepository;
import com.loucos.por.macarra.repositories.PerfilRepository;
import com.loucos.por.macarra.repositories.PessoaRepository;
import com.loucos.por.macarra.repositories.UsuarioRepository;

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
