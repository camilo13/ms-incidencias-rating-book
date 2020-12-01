package com.example.demo.service;

import com.example.demo.modelo.IncidenciaRequest;
import com.example.demo.modelo.IncidenciaResponse;

public interface ApiService {
    
	IncidenciaResponse post(IncidenciaRequest request);

}
