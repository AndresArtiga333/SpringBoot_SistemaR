package com.andresartiga.system.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity /*genera las tablas con los atributos */
@Data/* genera los getters and setters */
@NoArgsConstructor/*crea el constructor vacio */
@AllArgsConstructor/*crea el constructo lleno */
@ToString

public class Empleados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idEmpleado;
    public String nombreCompleto;
    public int dpi;
    public String puesto;
    public double salario;
}
