package com.dcgraphics.dcgraphics.client.app;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface ClientService extends Serializable{

	Optional<Client> findById(Long id);

	List<Client> findAll();

	Optional<Client> findByName(String name);

	//Optional<Client> findByForName(String forname);
	
	Client add(Client Client) throws Exception;

	Client update(Client Client) throws Exception;

	void delete(Long id) throws Exception;

	

	

}