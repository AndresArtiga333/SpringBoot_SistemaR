package com.andresartiga.system.service;

import java.util.List;


import com.andresartiga.system.bean.Empleados;


public interface IEmpleadosService {
    /*Funciones */
    public List<Empleados> listarEmpleados();

    public Empleados buscarEmpleado (Integer idEmpleado);

    public Empleados guardarEmpleado(Empleados empleados);

    /*Metodo */
    public void eliminarEmpleado(Integer idEmpleados);
}
