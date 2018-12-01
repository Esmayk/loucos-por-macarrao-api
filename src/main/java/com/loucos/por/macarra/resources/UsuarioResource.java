package com.loucos.por.macarra.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.loucos.por.macarra.domain.Usuario;
import com.loucos.por.macarra.services.UsuarioService;


@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value="/salvar", method = RequestMethod.POST)
	public ResponseEntity<?> find(@RequestBody Usuario usuario) {
		return ResponseEntity.ok(usuarioService.salvarUsuario(usuario));
	}
}
