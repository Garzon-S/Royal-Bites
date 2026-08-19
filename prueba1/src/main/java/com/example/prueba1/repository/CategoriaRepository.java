package com.example.prueba1.repository;

import com.example.prueba1.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Le pasamos la Entidad y el tipo de dato de su Llave Primaria (String)
public interface CategoriaRepository extends JpaRepository<Categoria, String> {
    // Al heredar de JpaRepository, Spring ya sabe hacer SELECT *, INSERT, etc.
}