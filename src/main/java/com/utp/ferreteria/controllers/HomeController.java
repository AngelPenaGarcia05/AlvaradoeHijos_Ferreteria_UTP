package com.utp.ferreteria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.utp.ferreteria.models.Producto;
import com.utp.ferreteria.services.ProductoService;

import org.springframework.ui.Model;

@Controller
public class HomeController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    public String home(Model model){
        List<Producto> productos = productoService.obtenerRangoProductos(0, 4);
        model.addAttribute("productos", productos);
        return "home";
    }
    @GetMapping("/productos")
    public String productos(@RequestParam(value = "filtro", required = false) String filtro,
                            @RequestParam(value = "categoria", required = false) String categoria,
                            Model model){
        List<Producto> productos = null;
        if (filtro == null || categoria == null) {
            productos = productoService.obtenerProductosPorNombreContiene(filtro);
        }else{
            productos = productoService.obtenerProductosPorCategoria(productoService.obtenerProductos(), categoria);
        }
        model.addAttribute("categoria", categoria);
        model.addAttribute("filtro", filtro);
        model.addAttribute("productos", productos);
        return "productos";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
