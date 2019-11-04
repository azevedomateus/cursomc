package com.example.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.domain.Categoria;
import com.example.spring.domain.Pedido;
import com.example.spring.service.CategoriaService;
import com.example.spring.service.PedidoService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value ="/pedidos")
public class PedidoResouces {
	
	@Autowired
	private PedidoService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
<<<<<<< HEAD
	public ResponseEntity<Pedido> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Pedido obj = service.find(id);
=======
	public ResponseEntity<?> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Pedido obj = service.buscar(id);
>>>>>>> e5fc68fcdc5c48b567b705008fdd1138107d0508
		return ResponseEntity.ok().body(obj);
		

	}
}
