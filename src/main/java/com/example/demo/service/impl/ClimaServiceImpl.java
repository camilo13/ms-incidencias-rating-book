package com.example.demo.service.impl;

import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Service;

import com.example.demo.modelo.IncidenciaRequest;
import com.example.demo.modelo.IncidenciaResponse;
import com.example.demo.service.ApiService;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

@Service
public class ClimaServiceImpl implements ApiService {
	
	private final static String QUEUE_NAME = "incidencias";
	
    @Override
    public IncidenciaResponse post(IncidenciaRequest request) {
    	    	
    	IncidenciaResponse incidenciaResponse = new IncidenciaResponse();
    	
    	ConnectionFactory factory = new ConnectionFactory();
    	factory.setHost(System.getenv("RABBIT_HOST"));
    	factory.setVirtualHost(System.getenv("RABBIT_USER"));
    	factory.setUsername(System.getenv("RABBIT_USER"));
    	factory.setPassword(System.getenv("RABBIT_PASS"));
		try (Connection connection = factory.newConnection();
		     Channel channel = connection.createChannel()) {
			channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            String mensaje = request.getTitulo().toUpperCase() + ": " + request.getDetalle() ;
            channel.basicPublish("", QUEUE_NAME, null, mensaje.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + mensaje + "'");
            incidenciaResponse.setCode("200");
            incidenciaResponse.setStatus("Incidencia en atención");
		} catch (Exception e) {
			e.printStackTrace();
			incidenciaResponse.setCode("ERROR");
            incidenciaResponse.setStatus("No se pudo registrar");
		}
    	
    	return incidenciaResponse;
    }

}
