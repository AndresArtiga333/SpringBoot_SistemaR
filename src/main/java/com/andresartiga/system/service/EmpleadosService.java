package com.andresartiga.system.service;

import com.andresartiga.system.bean.*;
import com.andresartiga.system.repository.EmpleadosRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadosService implements IEmpleadosService{
@Autowired

private EmpleadosRepository empleadosRepository;
    @Override
    public List<Empleados> listarEmpleados() {
      
        return empleadosRepository.findAll();
    }

    @Override
    public Empleados buscarEmpleado(Integer idEmpleado) {
        Empleados empleados = empleadosRepository.findById(idEmpleado).orElse(null);
        return empleados;
    }

    @Override
    public Empleados guardarEmpleado(Empleados empleados) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardarEmpleado'");
    }

    @Override
    public void eliminarEmpleado(Integer idEmpleados) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarEmpleado'");
    }


   
}
