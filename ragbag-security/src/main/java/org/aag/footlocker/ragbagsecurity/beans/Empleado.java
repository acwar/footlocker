package org.aag.footlocker.ragbagsecurity.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empleado{
    private int idEmpleado;
    private String nombre;
    private double salario;
}