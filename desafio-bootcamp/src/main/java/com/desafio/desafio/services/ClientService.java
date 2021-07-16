package com.desafio.desafio.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafio.desafio.dto.ClientDTO;
import com.desafio.desafio.entities.Client;
import com.desafio.desafio.repositories.ClientRepository;

import javassist.NotFoundException;

@Service
public class ClientService {
	
	@Autowired private ClientRepository clientRepository;
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) throws NotFoundException {
		Optional<Client> obj = clientRepository.findById(id);
		Client obj2 = obj.orElseThrow(() -> new NotFoundException("Entity Not Found"));
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
	public ClientDTO update(ClientDTO obj, Long id) throws NotFoundException {
		try {
			Client entity = clientRepository.getOne(id);
			entity.setName(obj.getName());
			entity.setBirthDate(obj.getBirthDate());
			entity.setChildren(obj.getChildren());
			entity.setCpf(obj.getCpf());
			entity.setIncome(obj.getIncome());
			entity = clientRepository.save(entity);
			return new ClientDTO(entity);
		}catch (EntityNotFoundException e){
			throw new NotFoundException("Id not found" + id);
		}
		
		
	}

	public void delete(Long id) throws Exception {
		try {
			clientRepository.deleteById(id);
		} catch (Exception e) {
			throw new Exception("Id not found " + id);
		}
	}
	

}
