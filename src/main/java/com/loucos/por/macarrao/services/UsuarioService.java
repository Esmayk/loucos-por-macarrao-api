package com.loucos.por.macarrao.services;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loucos.por.macarrao.domain.Usuario;
import com.loucos.por.macarrao.repositories.PerfilRepository;
import com.loucos.por.macarrao.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PerfilRepository perfilRepository;
	
	
	public Usuario salvarUsuario(Usuario usuario) throws NoSuchAlgorithmException {
		usuario.setPerfil(perfilRepository.findById(2L).get());
		usuario.setAtivo(true);
		usuario.setSenha(SenhaMD5(usuario.getSenha()));
		usuarioRepository.save(usuario);
		return usuario;
	}
	
	private static String SenhaMD5(String senha) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        return String.format("%32x", hash);
	}
}
