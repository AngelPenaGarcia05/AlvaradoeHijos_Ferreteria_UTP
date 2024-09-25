package com.utp.ferreteria.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.utp.ferreteria.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
}
