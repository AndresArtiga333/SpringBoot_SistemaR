package com.andresartiga.system.service;

import java.util.List;

import com.andresartiga.system.bean.*;
public interface IProyectosService {
    public List<Proyectos> listarProyectos();

    public Proyectos buscarProyecto (Integer idProyecto);

    public Proyectos guardarProyecto (Proyectos proyectos);

    public void eliminarProyecto(Proyectos proyectos);
}
