package com.dcgraphics.dcgraphics.client.app;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import app.ClientAddress.ClientAddress;
//import app.ClientAddress.ClientAddressRepository;

@Service
public class ClientServiceImpl implements ClientService {

	/**
	 * Serial version id
	 */
	private static final long serialVersionUID = 6052232200779930843L;

	@Autowired
	ClientRepository clientRepository;

	//@Autowired
	//ClientAddressRepository ClientAddressRepository;


	private static final Logger log = LoggerFactory.getLogger(ClientServiceImpl.class);
	
	@Override
	public List<Client> findAll(){
		return clientRepository.findAll();
	}


	@Override
	public Optional<Client> findById(Long id){

		if (id == null || id <0) {
			String message = "The Id is mandatory and should be positive.";
			log.error(message);
			throw new IllegalArgumentException(message);
		}

		return clientRepository.findById(id);
	}


	@Override
	public Optional<Client> findByName(String name){
		if (Strings.isEmpty(name)) {
			String message = "The Name is mandatory.";
			log.error(message);
			throw new IllegalArgumentException(message);
		}
		return clientRepository.findByName(name);
	}
	


	

	private void inputsControl(Client client) {

		// Client
		if (Strings.isEmpty(client.getName())) {
			String message = "The Name is mandatory.";
			log.error(message);
			throw new IllegalArgumentException(message);
		}
		
		if (Strings.isEmpty(client.getForname())) {
			String message = "The forname is mandatory.";
			log.error(message);
			throw new IllegalArgumentException(message);
		}
		
		if (Strings.isEmpty(client.getMail())) {
			String message = "The Mail is mandatory.";
			log.error(message);
			throw new IllegalArgumentException(message);
		}

		// By default Client is enabled
//		if (Client.getDisabled() ==  null) {
//			Client.setDisabled(false);
//		}

		if (Strings.isEmpty(client.getPhone())) {
			String message = "The Phone number is mandatory.";
			log.error(message);
			throw new IllegalArgumentException(message);
		}
		if (Strings.isEmpty(client.getText())) {
			String message = "The text is mandatory.";
			log.error(message);
			throw new IllegalArgumentException(message);
		}



	}
	@Override
	public Client add(Client client) {
		Client ClientNew = null;
		ClientNew =new Client();
		ClientNew.setName(client.getName());
		ClientNew.setForname(client.getForname());
		ClientNew.setMail(client.getMail());
		ClientNew.setPhone(client.getPhone());
		ClientNew.setText(client.getText());
		clientRepository.save(ClientNew);

		
		return ClientNew;
		
	}



	@Override
	public Client update(Client client) throws Exception{
		if (client.getId() == null || client.getId() < 0) {
			String message = "Id is mandatory.";
			log.error(message);
			throw new IllegalArgumentException(message);
		}

		inputsControl(client);

		Client ClientUpdated = null;
		try {
			ClientUpdated = clientRepository.findById(client.getId()).orElse(null);
			if (ClientUpdated == null) {
				throw new ClientNotFoundException("Client with id "+client.getId() + " not found.");
			}

			ClientUpdated.setName(client.getName());
			ClientUpdated.setForname(client.getForname());
			ClientUpdated.setMail(client.getMail());
			ClientUpdated.setPhone(client.getPhone());
			ClientUpdated.setText(client.getText());
			clientRepository.save(ClientUpdated);

		} catch (Exception e) {
			String message = "Error while updating the Client with id " + client.getId() + " " + e.getMessage();
			log.error(message);
			throw new Exception(message);
		}

		return ClientUpdated;

	}

	@Override
	public void delete(Long id) throws Exception{

		if (id == null || id < 0) {
			throw new IllegalArgumentException("Id is mandatory.");
		}

		try {
			clientRepository.deleteById(id);
		} catch (Exception e) {
			String message = "Error while deleting the Client with id " + id + " - " + e.getMessage();
			log.error(message);
			throw new Exception(message);
		}

	}

}
