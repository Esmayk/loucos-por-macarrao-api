package com.loucos.por.macarrao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.loucos.por.macarrao.domain.Usuario;
import com.loucos.por.macarrao.services.UsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Api Loucos por Macarrão")
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@ApiOperation(value = "Salva um novo usuário do sistema.")
	@RequestMapping(value="/salvar", method = RequestMethod.POST)
	public ResponseEntity<?> find(@RequestBody Usuario usuario) {
		return ResponseEntity.ok(usuarioService.salvarUsuario(usuario));
	}
}
