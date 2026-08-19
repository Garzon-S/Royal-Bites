package com.example.prueba1.controller;

import com.example.prueba1.entity.Persona;
import com.example.prueba1.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
@CrossOrigin(origins = "http://localhost:5173")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    // GET: Obtener todas las personas registradas en la BD
    @GetMapping
    public List<Persona> listarPersonas() {
        return personaRepository.findAll();
    }

    // POST: Guardar una nueva persona
    @PostMapping
    public Persona guardarPersona(@RequestBody Persona persona) {
        return personaRepository.save(persona);
    }
}