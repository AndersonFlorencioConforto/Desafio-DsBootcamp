package com.desafio.desafio.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafio.desafio.dto.ClientDTO;
import com.desafio.desafio.entities.Client;
import com.desafio.desafio.repositories.ClientRepository;
import com.desafio.desafio.services.exceptions.DataBaseException;
import com.desafio.desafio.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = clientRepository.findById(id);
		Client obj2 = obj.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
		return new ClientDTO(obj2);
	}

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> list = clientRepository.findAll(pageRequest);
		return list.map(x -> new ClientDTO(x));
	}

	@Transactional
	public ClientDTO insert(ClientDTO obj) {
		Client entity = new Client();
		entity.setName(obj.getName());
		entity.setBirthDate(obj.getBirthDate());
		entity.setChildren(obj.getChildren());
		entity.setCpf(obj.getCpf());
		entity.setIncome(obj.getIncome());
		entity = clientRepository.save(entity);
		return new ClientDTO(entity);
	}

	@Transactional
	public ClientDTO update(ClientDTO obj, Long id) {
		try {
			Client entity = clientRepository.getOne(id);
			entity.setName(obj.getName());
			entity.setBirthDate(obj.getBirthDate());
			entity.setChildren(obj.getChildren());
			entity.setCpf(obj.getCpf());
			entity.setIncome(obj.getIncome());
			entity = clientRepository.save(entity);
			return new ClientDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found" + id);
		}

	}

	public void delete(Long id) {
		try {
			clientRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity violation");
		}
	}

}
