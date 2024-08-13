package com.andresartiga.system.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andresartiga.system.bean.Empleados;
import com.andresartiga.system.exception.EmpleadoException;
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

        @GetMapping("/empleado/{idEmpleado}")

    public ResponseEntity <Empleados> buscarEmpleado(@PathVariable Integer idEmpleado){
        Empleados empleados = IEmpleadosService.buscarEmpleado(idEmpleado);
        if(empleados ==null){
            throw new EmpleadoException("No se encontro el empleado");
        }
        return ResponseEntity.ok(empleados);
    }

    @PutMapping("/empleado/{idEmpleado}")
    public ResponseEntity <Empleados> editarEmpleado(@PathVariable Integer idEmpleado, @RequestBody Empleados empleadoRecibido){
        Empleados empleados = IEmpleadosService.buscarEmpleado(idEmpleado);
        if(empleados == null){
            throw new EmpleadoException("El id no existe");
        }
        empleados.setDpi(empleadoRecibido.getDpi());
        empleados.setNombreCompleto(empleadoRecibido.nombreCompleto);
        empleados.setPuesto(empleadoRecibido.getPuesto());
        empleados.setSalario(empleadoRecibido.getSalario());
        IEmpleadosService.guardarEmpleado(empleados);
        return ResponseEntity.ok(empleados);
    }
}
