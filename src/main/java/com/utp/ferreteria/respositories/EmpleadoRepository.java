package com.utp.ferreteria.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.utp.ferreteria.models.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    
}
