package com.utp.ferreteria.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.utp.ferreteria.models.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    
}
