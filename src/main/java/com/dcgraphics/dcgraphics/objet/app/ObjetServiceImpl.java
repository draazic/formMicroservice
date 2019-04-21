package com.dcgraphics.dcgraphics.objet.app;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcgraphics.dcgraphics.client.app.Client;

//import app.ClientAddress.ClientAddress;
//import app.ClientAddress.ClientAddressRepository;

@Service
public class ObjetServiceImpl implements ObjetService {
	
	/**
	 * Serial version id
	 */
	private static final long serialVersionUID = 6052232200779930843L;

	@Autowired
	ObjetRepository objetRepository;

	//@Autowired
	//ClientAddressRepository ClientAddressRepository;


	private static final Logger log = LoggerFactory.getLogger(ObjetServiceImpl.class);
	
	@Override
	public List<Objet> findAll(){
		return objetRepository.findAll();
	}
	
	@Override
	public Optional<Objet> findById(Long id){

		if (id == null || id <0) {
			String message = "The Id is mandatory and should be positive.";
			log.error(message);
			throw new IllegalArgumentException(message);
		}

		return objetRepository.findById(id);
	}

}
