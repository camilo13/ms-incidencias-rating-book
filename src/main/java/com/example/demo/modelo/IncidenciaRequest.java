package com.example.demo.modelo;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncidenciaRequest {
	
    public static final String MSG_NOT_EMPTY = "No puede quedar sin valor";

    @NotEmpty(message = MSG_NOT_EMPTY)
    private String titulo;

    @NotEmpty(message = MSG_NOT_EMPTY)
    private String detalle;

}
