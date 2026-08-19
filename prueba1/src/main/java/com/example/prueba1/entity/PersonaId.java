package com.example.prueba1.entity;

import java.io.Serializable;
import java.util.Objects;

public class PersonaId implements Serializable {
    private String tipoDocumento;
    private Integer idPersona;

    public PersonaId() {}

    public PersonaId(String tipoDocumento, Integer idPersona) {
        this.tipoDocumento = tipoDocumento;
        this.idPersona = idPersona;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonaId personaId = (PersonaId) o;
        return Objects.equals(tipoDocumento, personaId.tipoDocumento) &&
               Objects.equals(idPersona, personaId.idPersona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoDocumento, idPersona);
    }
}