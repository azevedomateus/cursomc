package com.example.spring.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.spring.domain.Categoria;
import com.example.spring.domain.Produto;
import com.example.spring.repository.CategoriaRepository;
import com.example.spring.repository.ProdutoRepository;
import com.example.spring.service.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	CategoriaRepository categoriaRepository;

	public Optional<Produto> find(Integer id) throws ObjectNotFoundException {
		Optional<Produto> obj = produtoRepository.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! id: " + id + ", Tipo: " + Produto.class.getName());
		}
		return obj;	
	}

	public Page<Produto> search(String nome, List<Integer> ids, Pageable pageable) {
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return produtoRepository.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageable);

	}

}
