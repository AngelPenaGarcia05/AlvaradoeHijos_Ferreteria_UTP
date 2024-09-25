package com.utp.ferreteria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.utp.ferreteria.models.Proveedor;
import com.utp.ferreteria.respositories.ProveedorRepository;
import org.springframework.beans.BeanUtils;

@Service
public class ProveedorService {
    
    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> obtenerProveedores(){
        return proveedorRepository.findAll();
    }

    public Proveedor obtenerProveedorPorId(Long id){
        return proveedorRepository.findById(id).orElse(null);
    }

    public Proveedor guardarProveedor(Proveedor proveedor){
        return proveedorRepository.save(proveedor);
    }

    public void actualizarProveedor(Long id, Proveedor proveedor){
        proveedorRepository.findById(id).ifPresent(proveedorExistente -> {
            BeanUtils.copyProperties(proveedor, proveedorExistente, "id");
            proveedorRepository.save(proveedorExistente);
        });
    }

    public void eliminarProveedor(Long id){
        proveedorRepository.findById(id).ifPresent(proveedor -> {
            proveedorRepository.delete(proveedor);
        });
    }
}
