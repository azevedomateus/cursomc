package com.example.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.controller.utils.URL;
import com.example.spring.domain.Produto;
import com.example.spring.dto.ProdutoDTO;
import com.example.spring.service.ProdutoService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResouces {

	@Autowired
	private ProdutoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Produto>> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Optional<Produto> obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<ProdutoDTO>> findPage(
			@RequestParam(defaultValue = "") String nome,
			@RequestParam(defaultValue = "") String categorias, Pageable pageable) {
		String nomeDecod = URL.decodeParam(nome);
		List<Integer> ids = URL.decodeIntList(categorias);

		Page<Produto> list = service.search(nomeDecod, ids, pageable);
		Page<ProdutoDTO> listDto = list.map(obj -> new ProdutoDTO(obj));
		return ResponseEntity.ok().body(listDto);

	}
}
