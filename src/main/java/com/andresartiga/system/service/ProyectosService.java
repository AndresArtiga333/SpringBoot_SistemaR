package com.andresartiga.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andresartiga.system.bean.*;
import com.andresartiga.system.repository.ProyectosRepository;

@Service
public class ProyectosService implements IProyectosService {
@Autowired

private ProyectosRepository proyectosRepository;
    @Override
    public List<Proyectos> listarProyectos() {
        return proyectosRepository.findAll();
    }

    @Override
    public Proyectos buscarProyecto(Integer idProyecto) {
        Proyectos proyectos = proyectosRepository.findById(idProyecto).orElse(null);
        return proyectos; 
    }

    @Override
    public Proyectos guardarProyecto(Proyectos proyectos) {
        return proyectosRepository.save(proyectos);
    }

    @Override
    public void eliminarProyecto(Proyectos proyectos) {
         proyectosRepository.delete(proyectos);

    }


}
