package com.example.cursomc.service;

public class CategoriaService {
	
	public Categoria find(Integer id) {  Optional<Categoria> obj = repo.findById(id);  return obj.orElse(null); 

}
