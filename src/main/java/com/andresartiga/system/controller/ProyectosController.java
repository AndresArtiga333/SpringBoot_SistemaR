package com.andresartiga.system.controller;

import java.util.List;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andresartiga.system.bean.Empleados;
import com.andresartiga.system.bean.Proyectos;
import com.andresartiga.system.exception.EmpleadoException;
import com.andresartiga.system.exception.ProyectoException;
import com.andresartiga.system.service.IEmpleadosService;
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

       @PostMapping("/proyectosA")

    public Proyectos agregarEmpleado (@RequestBody Proyectos proyectos){
        logger.info("Proyecto agregado " + proyectos);
        return IProyectosService.guardarProyecto(proyectos);

    }
    
    @GetMapping("/proyectos/{idProyecto}")

    public ResponseEntity <Proyectos> buscarProyecto(@PathVariable Integer idProyecto){
        Proyectos proyectos = IProyectosService.buscarProyecto(idProyecto);
        if(proyectos ==null){
            throw new ProyectoException("No se encontro el proyecto");
        }
        return ResponseEntity.ok(proyectos);
    }
    
    @PutMapping("/proyectos/{idProyecto}")
    public ResponseEntity <Proyectos> editarProyecto(@PathVariable Integer idProyecto, @RequestBody Proyectos proyectoRecibido){
        Proyectos proyectos = IProyectosService.buscarProyecto(idProyecto);
        if(proyectos == null){
            throw new ProyectoException("No se encontro el proyecto");
        }
        proyectos.setCosto(proyectoRecibido.getCosto());
        proyectos.setDescripcion(proyectoRecibido.getDescripcion());
        proyectos.setFechaDeFinalizacion(proyectoRecibido.getFechaDeFinalizacion());
        proyectos.setFechaDeInicio(proyectoRecibido.getFechaDeInicio());
        proyectos.setNombreProyecto(proyectoRecibido.getNombreProyecto());
        IProyectosService.guardarProyecto(proyectos);
        return ResponseEntity.ok(proyectos);
    }

        @DeleteMapping("/proyectos/{idProyecto}")
    public ResponseEntity<Map<String, Boolean>> eliminarProyecto(@PathVariable Integer idProyecto){
        Proyectos proyectos = IProyectosService.buscarProyecto(idProyecto);
        if (proyectos == null){
            throw new ProyectoException("No se encontro el proyecto a eliminar");
        }
        IProyectosService.eliminarProyecto(proyectos);

        Map<String , Boolean> respuesta = new HashMap<>(); 
        respuesta.put("Eliminado", true);
        return ResponseEntity.ok(respuesta);
        
    }
}
