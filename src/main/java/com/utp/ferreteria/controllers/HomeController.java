package com.utp.ferreteria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
    

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
