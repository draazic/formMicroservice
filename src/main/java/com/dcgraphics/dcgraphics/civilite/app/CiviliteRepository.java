package com.dcgraphics.dcgraphics.civilite.app;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CiviliteRepository extends JpaRepository<Civilite, Long> {

	//Optional<Client> findByName(String name);

	//Optional<Client> findByForName(String forname);


	
	
}