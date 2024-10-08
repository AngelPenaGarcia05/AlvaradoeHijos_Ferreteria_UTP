package com.utp.ferreteria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.utp.ferreteria.models.Producto;
import com.utp.ferreteria.respositories.ProductoRepository;
import org.springframework.beans.BeanUtils;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerProductos(){
        return productoRepository.findAll();
    }

    public List<Producto> obtenerRangoProductos(int inicio, int cantidad){
        return productoRepository.findAll().stream().skip(inicio).limit(cantidad).toList();
    }
    public List<Producto> obtenerProductosPorNombreContiene(String filtro){
        return productoRepository.findByNombreContaining(filtro);
    }

    public List<Producto> obtenerProductosPorCategoria(List<Producto> productos, String categoria){
        return productos.stream().filter(producto -> producto.getCategoria().equals(categoria)).toList();
    }
    public List<Producto> obtenerProductosRelacionados(Long id){
        return productoRepository.findByCategoria(productoRepository.findById(id).get().getCategoria());
    }

    public Producto obtenerProductoPorId(Long id){
        return productoRepository.findById(id).orElse(null);
    }
    public Producto guardarProducto(Producto producto){
        return productoRepository.save(producto);
    }

    public void actualizarProducto(Long id, Producto producto){
        productoRepository.findById(id).ifPresent(productoExistente -> {
            BeanUtils.copyProperties(producto, productoExistente, "id");
            productoRepository.save(productoExistente);
        });
    }

    public void eliminarProducto(Long id){
        productoRepository.findById(id).ifPresent(producto -> {
            productoRepository.delete(producto);
        });
    }
}
