package com.example.prueba1.controller;

import com.example.prueba1.DTO.LoginRequest;
import com.example.prueba1.entity.Persona;
import com.example.prueba1.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @Autowired
    private PersonaRepository personaRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        // 1. Buscar en la base de datos por correo y contraseña
        Optional<Persona> personaOpt = personaRepository.findByCorreoAndPassword(
            request.getUsername(), // React envía el correo en esta variable
            request.getPassword()
        );

        // Si las credenciales no existen en MySQL
        if (personaOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Correo o contraseña incorrectos");
        }

        Persona persona = personaOpt.get();

        // 2. Verificar si la persona encontrada es ADMINISTRADOR
        int esAdmin = personaRepository.esAdministrador(
            persona.getTipoDocumento(), 
            persona.getIdPersona()
        );

        if (esAdmin == 0) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Acceso denegado: El usuario no tiene rol de Administrador");
        }

        // 3. Respuesta exitosa si es Admin
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Bienvenido " + persona.getpNombre());
        response.put("nombre", persona.getpNombre() + " " + persona.getpApellido());
        response.put("role", "ADMIN");

        return ResponseEntity.ok(response);
    }
}