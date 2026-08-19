package com.example.prueba1.service;

import com.example.prueba1.entity.Categoria;
import com.example.prueba1.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired // Inyecta el repositorio automáticamente (sin hacer "new")
    private CategoriaRepository categoriaRepository;

    // Método para listar todas las categorías (como las de comida rápida que insertaste)
    public List<Categoria> obtenerTodas() {
        return categoriaRepository.findAll();
    }

    // Método para guardar una nueva categoría
    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}