package org.aag.footlocker.ragbagsecurity.controllers;

import org.aag.footlocker.ragbagsecurity.beans.Empleado;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmpleadosController {
    private List<Empleado> empleados;

    @PostConstruct
    public void init() {
        empleados = new ArrayList<>();
        empleados.add(new Empleado(2003, "Javier Lopez", 1780));
        empleados.add(new Empleado(1000, "Maria Sanchez", 1900));
        empleados.add(new Empleado(4000, "David Martin", 1600));
    }

    @GetMapping(value="empleados", produces = MediaType.APPLICATION_JSON_VALUE)
    public  List<Empleado> recuperarEmpleados(){
        return empleados;
    }
    @GetMapping(value="empleados/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Empleado buscarContactos(@PathVariable("id") int id){
        for (Empleado empleado:empleados)
            if (empleado.getIdEmpleado()==id)
                return  empleado;

        return null;
    }
}
