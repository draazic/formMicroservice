package com.dcgraphics.dcgraphics.objet.app;

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

import com.dcgraphics.dcgraphics.civilite.app.Civilite;
import com.dcgraphics.dcgraphics.civilite.app.CiviliteController;
import com.dcgraphics.dcgraphics.civilite.app.CiviliteService;
import com.dcgraphics.dcgraphics.client.app.Client;

import io.swagger.annotations.ApiOperation;

import static net.logstash.logback.marker.Markers.append;

@RestController
@RequestMapping(path = "/Objet", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ObjetController {
	//private static final Logger logger = LoggerFactory.getLogger(CiviliteController.class);
	
	@Autowired
	private ObjetService objetService;

    @ApiOperation(value = "List all Objet")
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Objet>> findAll() {
		List<Objet> Objet = objetService.findAll();
		HttpHeaders responseHeaders = new HttpHeaders();

		return new ResponseEntity<>(Objet, responseHeaders, HttpStatus.OK);
	}
    
    @ApiOperation(value = "Get one Objet by id")
	@GetMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<Optional<Objet >> findById(@PathVariable("id") Long id) {
		Optional<Objet> Objet = objetService.findById(id);
		HttpHeaders responseHeaders = new HttpHeaders();

		return new ResponseEntity<>(Objet, responseHeaders, HttpStatus.OK);
	}

}
