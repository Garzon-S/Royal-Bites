package com.example.prueba1.controller;

import com.example.prueba1.entity.Categoria;
import com.example.prueba1.service.CategoriaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")

@RequestMapping("/api/categorias") // Ruta base: http://localhost:8080/api/categorias
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // Responderá a peticiones GET
    @GetMapping
    public List<Categoria> listar() {
        return categoriaService.obtenerTodas();
    }

    // Responderá a peticiones POST (Para insertar desde Postman)
    @PostMapping
    public Categoria crear(@RequestBody Categoria categoria) {
        return categoriaService.guardar(categoria);
    }
}