package com.example.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.spring.domain.Categoria;
import com.example.spring.dto.CategoriaDTO;
import com.example.spring.repository.CategoriaRepository;
import com.example.spring.service.exceptions.DataIntegrityException;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) throws ObjectNotFoundException {

		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));

	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) throws ObjectNotFoundException {
		Categoria newobj = find(obj.getId());
		updateData(newobj, obj);
		return repo.save(newobj);
	}

	public void delete(Integer id) throws ObjectNotFoundException {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");
		}

	}

	public List<Categoria> findAll() {
		return repo.findAll();
	}

	public Categoria fromDTO(CategoriaDTO objDto) {
		return new Categoria(objDto.getId(), objDto.getNome());

	}

	public Page<Categoria> findPage(Integer page, Integer linesPage, String ordeBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPage, Direction.valueOf(direction), ordeBy);
		return repo.findAll(pageRequest);

	}
	
	private void updateData (Categoria newObj, Categoria obj) {
		newObj.setNome(obj.getNome());
	}

}
