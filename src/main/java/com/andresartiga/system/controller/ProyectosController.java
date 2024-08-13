package com.andresartiga.system.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andresartiga.system.bean.Proyectos;
import com.andresartiga.system.service.IProyectosService;

@RestController  //http://localhost:8081/rh-proyecto
@RequestMapping ("rh-proyecto")
public class ProyectosController {
    private static final Logger logger = LoggerFactory.getLogger(ProyectosController.class);
    @Autowired
    private IProyectosService IProyectosService;
    //http://localhost:8081/rh-proyecto/proyectos
    @GetMapping("/proyectos")

    public List <Proyectos> obtenerProyecto(){
        var proyectos2 = IProyectosService.listarProyectos();
        proyectos2.forEach(proyectos -> logger.info(proyectos.toString()));
        return proyectos2;
    }
}
