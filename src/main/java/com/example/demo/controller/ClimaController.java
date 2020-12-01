package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.IncidenciaRequest;
import com.example.demo.modelo.IncidenciaResponse;
import com.example.demo.service.ApiService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/ratingBookApi")
@AllArgsConstructor
public class ClimaController {
	
	@Autowired
	private ApiService apiService;

	@CrossOrigin(origins = "*")
	@PostMapping("/incidencia")
    public ResponseEntity<IncidenciaResponse> setCliente(@Valid @RequestBody IncidenciaRequest request) {
        return ResponseEntity.ok(apiService.post(request));
    }
	
}
