package com.example.prueba1.repository;

import com.example.prueba1.entity.Persona;
import com.example.prueba1.entity.PersonaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, PersonaId> {

    Optional<Persona> findByCorreoAndPassword(String correo, String password);

    // Consulta SQL que verifica si la persona tiene el ROL 1 (Administrador) y estado activo
    @Query(value = "SELECT COUNT(*) FROM ROL_HAS_PERSONA rp " +
                   "WHERE rp.PERSONA_TIPO_DOCUMENTO_COD_TDOC = :tipoDoc " +
                   "AND rp.PERSONA_ID_PERSONA = :idPersona " +
                   "AND rp.ROL_COD_ROL = 1 " +
                   "AND rp.ESTADO_RP = TRUE", nativeQuery = true)
    int esAdministrador(@Param("tipoDoc") String tipoDoc, @Param("idPersona") Integer idPersona);
}