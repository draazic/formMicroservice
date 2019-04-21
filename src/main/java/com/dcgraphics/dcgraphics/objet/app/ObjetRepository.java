package com.dcgraphics.dcgraphics.objet.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcgraphics.dcgraphics.civilite.app.Civilite;

@Repository
public interface ObjetRepository extends JpaRepository<Objet, Long> {

	//Optional<Client> findByName(String name);

	//Optional<Client> findByForName(String forname);
}


	
	