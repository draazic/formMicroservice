package com.dcgraphics.dcgraphics.client.app;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dcgraphics.dcgraphics.client.app.Client;
import com.dcgraphics.dcgraphics.client.app.ClientController;
import com.dcgraphics.dcgraphics.client.app.ClientService;

import io.swagger.annotations.ApiOperation;

import static net.logstash.logback.marker.Markers.append;

@RestController
@RequestMapping(path = "/Clients", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ClientController {
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	@Autowired
	private ClientService ClientService;

    @ApiOperation(value = "List all Clients")
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Client>> findAll() {
		List<Client> Clients = ClientService.findAll();
		HttpHeaders responseHeaders = new HttpHeaders();

		return new ResponseEntity<>(Clients, responseHeaders, HttpStatus.OK);
	}

    @ApiOperation(value = "Get one Client by id")
	@GetMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<Optional<Client>> findById(@PathVariable("id") Long id) {
		Optional<Client> Client = ClientService.findById(id);
		HttpHeaders responseHeaders = new HttpHeaders();

		return new ResponseEntity<>(Client, responseHeaders, HttpStatus.OK);
	}

    @ApiOperation(value = "Get one Client by name")
	@GetMapping(value = "/name/{name}")
	@ResponseBody
	public ResponseEntity<Optional<Client>> findByName(@PathVariable("name") String name) {
		Optional<Client> Client = ClientService.findByName(name);
		HttpHeaders responseHeaders = new HttpHeaders();

		return new ResponseEntity<>(Client, responseHeaders, HttpStatus.OK);
	}
    
 

    @ApiOperation(value = "Create a Client")
	@PostMapping
	@ResponseBody
	public ResponseEntity<Client> add(@RequestBody Client Client) throws Exception {
        logger.info("Creating new Client", append("Client", Client));

		Client ClientNew = ClientService.add(Client);
		HttpHeaders responseHeaders = new HttpHeaders();

		return new ResponseEntity<>(ClientNew, responseHeaders, HttpStatus.OK);
	}

	@ApiOperation(value = "Update a Client")
	@PutMapping
	@ResponseBody
	public ResponseEntity<Client> update(@RequestBody Client Client) throws Exception {
        logger.info("Updating new Client", append("Client", Client));

		Client ClientUpdated = ClientService.update(Client);
		HttpHeaders responseHeaders = new HttpHeaders();

		return new ResponseEntity<>(ClientUpdated, responseHeaders, HttpStatus.OK);
	}


	@ApiOperation(value = "Delete a Client")
	@DeleteMapping(value = "/{id}")
	@ResponseBody
	public void delete(@PathVariable("id") Long id) throws Exception {
        logger.info("Deleting the Client with id {}", id);

		ClientService.delete(id);
	}
	
}