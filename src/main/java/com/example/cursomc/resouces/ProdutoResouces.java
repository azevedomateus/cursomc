package com.example.cursomc.resouces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.cursomc.domain.Categoria;
import com.example.cursomc.domain.Produto;
import com.example.cursomc.service.CategoriaService;
import com.example.cursomc.service.ProdutoService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value ="/produtos")
public class ProdutoResouces {
	
	@Autowired
	private ProdutoService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Produto obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
