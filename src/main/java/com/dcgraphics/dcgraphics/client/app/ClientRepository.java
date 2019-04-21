package com.dcgraphics.dcgraphics.client.app;

//import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	Optional<Client> findByName(String name);

	//Optional<Client> findByForName(String forname);


	
	
}