package com.dcgraphics.dcgraphics.objet.app;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dcgraphics.dcgraphics.client.app.Client;

@Service
public interface ObjetService extends Serializable{


	List<Objet> findAll();
	
	Optional<Objet> findById(Long id);




}

