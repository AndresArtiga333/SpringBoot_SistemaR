package com.andresartiga.system.bean;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idProyecto;
    public String nombreProyecto;
    public String descripcion;
    public Date fechaDeInicio;
    public Date fechaDeFinalizacion;
    public double costo;
}
