package com.dcgraphics.dcgraphics.civilite.app;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dcgraphics.dcgraphics.client.app.Client;

@Service
public interface CiviliteService extends Serializable{


	List<Civilite> findAll();
	
	Optional<Civilite> findById(Long id);

	//Optional<Civilite> findByName(String name);



}
