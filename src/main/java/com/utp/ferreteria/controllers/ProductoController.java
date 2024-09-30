package com.utp.ferreteria.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import com.utp.ferreteria.models.Producto;
import com.utp.ferreteria.services.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping()
    public String productos(@RequestParam(value = "filtro", required = false) String filtro,
                            @RequestParam(value = "categoria", required = false) String categoria,
                            Model model){
        List<Producto> productos = null;
        if (filtro == null || categoria == null) {
            productos = productoService.obtenerProductos();
        }else if(categoria.equals("")){
            productos = productoService.obtenerProductosPorNombreContiene(filtro);
        } else{
            productos = productoService.obtenerProductosPorCategoria(productoService.obtenerProductosPorNombreContiene(filtro), categoria);
        }
        model.addAttribute("categoria", categoria);
        model.addAttribute("filtro", filtro);
        model.addAttribute("productos", productos);
        return "productos";
    }

    @GetMapping("/{id}")
    public String producto(@PathVariable("id") Long id, Model model){
        Producto producto = productoService.obtenerProductoPorId(id);
        List<Producto> productosrelacionados = productoService.obtenerProductosRelacionados(id);
        if (producto == null) {
            return "redirect:/";
        }
        if (productosrelacionados == null) {
            return "redirect:/";
        }
        model.addAttribute("productosrelacionados", productosrelacionados);
        model.addAttribute("producto", producto);
        return "detalleproducto";
    }
}
