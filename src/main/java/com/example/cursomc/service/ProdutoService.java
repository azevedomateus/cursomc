package com.example.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cursomc.domain.Categoria;
import com.example.cursomc.domain.Produto;
import com.example.cursomc.repository.ProdutoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public Produto buscar(Integer id) throws ObjectNotFoundException {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}

}
