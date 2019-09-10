package com.hakai.dragon.world.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hakai.dragon.world.utilitarios.Constantes;


@Api
@Service
@RestController
@RequestMapping(path = Constantes.URL_DRAGON_WORLD)
public class GuerreirosAPI {
	
	
//	 	@Autowired
//	    private LoginCtrl loginController;
	
	
	 	@ApiOperation(value = "Primeiro endpoint", tags = Constantes.GRUPO_GUERREIROS_Z)
	    @PostMapping(path = "/obter_guerreiros_z",produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<String> obteGuerreiros(HttpServletRequest request) {

	 		return new ResponseEntity<String>("JSON guerreiros Z !", HttpStatus.OK);
	    }
	 	
}
