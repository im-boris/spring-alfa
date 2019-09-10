package com.hakai.dragon.world.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hakai.dragon.world.utilitarios.Constantes;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api
@Service
@RestController
@RequestMapping(path = Constantes.URL_DRAGON_WORLD)
public class ViloesAPI {

	
// 	@Autowired
//  private LoginCtrl loginController;
	
	
	
 	@ApiOperation(value = "Segundo endpoint", tags = Constantes.GRUPO_VILOES)
	@GetMapping(path = "/obter_inimigos",produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> obtemInimigos (HttpServletRequest request) {
        
 		return new ResponseEntity<String>("JSON vilões !!!", HttpStatus.OK);
    }

 	
 	
}
