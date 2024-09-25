package com.utp.ferreteria.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.utp.ferreteria.models.Empleado;
import com.utp.ferreteria.respositories.EmpleadoRepository;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> obtenerEmpleados(){
        return empleadoRepository.findAll();
    }

    public Empleado obtenerEmpleadoPorId(Long id){
        return empleadoRepository.findById(id).orElse(null);
    }

    public Empleado guardarEmpleado(Empleado empleado){
        return empleadoRepository.save(empleado);
    }

    public void actualizarEmpleado(Long id, Empleado empleado){
        empleadoRepository.findById(id).ifPresent(empleadoExistente -> {
            BeanUtils.copyProperties(empleado, empleadoExistente, "id");
            empleadoRepository.save(empleadoExistente);
        });
    }

    public void eliminarEmpleado(Long id){
        empleadoRepository.findById(id).ifPresent(empleado -> {
            empleadoRepository.delete(empleado);
        });
    }
}
