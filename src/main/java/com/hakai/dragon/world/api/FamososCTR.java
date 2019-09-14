package com.hakai.dragon.world.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(path = Constantes.URL_QUIZ_POS)
public class FamososCTR {
	
	
	 	@Autowired
	    private FamososSRV famososCTR;
	
	
	 	@ApiOperation(value = "Listar todos os famosos cadastrados", tags = Constantes.URL_QUIZ_POS)
	    @PostMapping(path = "/obter_lista_todos_famosos",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<FamososMDL> obtemListaFamosos(HttpServletRequest request) {

	 		//FamososMDL famosos = famososCTR.obtemObjetoFamosos();
	 		FamososMDL listaFamosos = famososCTR.obtemObjetoFamosos();
	 		return new ResponseEntity<>(listaFamosos, HttpStatus.OK);
	    }
	 	
	 	
	 	@ApiOperation(value = "Listar apenas os homens", tags = Constantes.URL_QUIZ_POS)
	    @PostMapping(path = "/obter_lista_famosos_homens",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<FamososMDL> obtemListaFamososHomens(HttpServletRequest request) {

	 		//FamososMDL famosos = famososCTR.obtemObjetoFamosos();
	 		FamososMDL listaFamosos = famososCTR.obtemObjetoFamososSeparados("m");
	 		return new ResponseEntity<>(listaFamosos, HttpStatus.OK);
	    }
	 	
	 	
	 	@ApiOperation(value = "Listar apenas as mulheres", tags = Constantes.URL_QUIZ_POS)
	    @PostMapping(path = "/obter_lista_famosos_mulheres",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<FamososMDL> obtemListaFamososMulheres(HttpServletRequest request) {

	 		//FamososMDL famosos = famososCTR.obtemObjetoFamosos();
	 		FamososMDL listaFamosos = famososCTR.obtemObjetoFamososSeparados("f");
	 		return new ResponseEntity<>(listaFamosos, HttpStatus.OK);
	    }
	 	
	 	
}
