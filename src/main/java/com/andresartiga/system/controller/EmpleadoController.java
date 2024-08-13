package com.andresartiga.system.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andresartiga.system.bean.Empleados;
import com.andresartiga.system.service.IEmpleadosService;

@RestController //http://localhost:8081/rh-empleado
@RequestMapping ("rh-empleado")

public class EmpleadoController {

    private static final Logger logger = LoggerFactory.getLogger(EmpleadoController.class);

    @Autowired /*Comunicacion entre el service y el repositorio */
    private IEmpleadosService IEmpleadosService;
        //http://localhost:8081/rh-empleado/empleados
    @GetMapping("/empleados")

    public List<Empleados> obtenerEmpleado(){
        var empleado2 = IEmpleadosService.listarEmpleados();
        empleado2.forEach(empleado -> logger.info(empleado.toString()));
        return empleado2;
    }

    @PostMapping("/empleadosA")

    public Empleados agregarEmpleado (@RequestBody Empleados empleados){
        logger.info("Empleado agregado " + empleados);
        return IEmpleadosService.guardarEmpleado(empleados);

    }
}
