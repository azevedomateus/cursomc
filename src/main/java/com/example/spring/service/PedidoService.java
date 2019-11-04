package com.example.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.domain.Categoria;
import com.example.spring.domain.Pedido;
import com.example.spring.repository.CategoriaRepository;
import com.example.spring.repository.PedidoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
<<<<<<< HEAD
	public Pedido find(Integer id) throws ObjectNotFoundException {
=======
	public Pedido buscar(Integer id) throws ObjectNotFoundException {
>>>>>>> e5fc68fcdc5c48b567b705008fdd1138107d0508
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));

}
}
