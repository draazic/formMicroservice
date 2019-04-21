package com.dcgraphics.dcgraphics.civilite.app;

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
public class CiviliteServiceImpl implements CiviliteService {
	
	/**
	 * Serial version id
	 */
	private static final long serialVersionUID = 6052232200779930843L;

	@Autowired
	CiviliteRepository civiliteRepository;

	//@Autowired
	//ClientAddressRepository ClientAddressRepository;


	private static final Logger log = LoggerFactory.getLogger(CiviliteServiceImpl.class);
	
	@Override
	public List<Civilite> findAll(){
		return civiliteRepository.findAll();
	}
	
	@Override
	public Optional<Civilite> findById(Long id){

		if (id == null || id <0) {
			String message = "The Id is mandatory and should be positive.";
			log.error(message);
			throw new IllegalArgumentException(message);
		}

		return civiliteRepository.findById(id);
	}

}