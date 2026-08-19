package com.example.prueba1.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "PERSONA")
@IdClass(PersonaId.class) // Maneja la clave primaria compuesta
public class Persona {

    @Id
    @Column(name = "TIPO_DOCUMENTO_COD_TDOC")
    @JsonProperty("tipoDocumento")
    private String tipoDocumento;

    @Id
    @Column(name = "ID_PERSONA")
    @JsonProperty("idPersona")
    private Integer idPersona;

    @Column(name = "P_NOMBRE")
    @JsonProperty("pNombre")
    private String pNombre;

    @Column(name = "P_APELLIDO")
    @JsonProperty("pApellido")
    private String pApellido;

    @Column(name = "CORREO")
    @JsonProperty("correo")
    private String correo;

    @Column(name = "PASSWORD")
    @JsonProperty("password")
    private String password;

    // Constructores vacíos y con campos (necesarios para JPA/Jackson)
    public Persona() {}

    // Getters y Setters
    public String getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(String tipoDocumento) { this.tipoDocumento = tipoDocumento; }

    public Integer getIdPersona() { return idPersona; }
    public void setIdPersona(Integer idPersona) { this.idPersona = idPersona; }

    @JsonProperty("pNombre")
    public String getpNombre() { return pNombre; }
    public void setpNombre(String pNombre) { this.pNombre = pNombre; }

    @JsonProperty("pApellido")
    public String getpApellido() { return pApellido; }
    public void setpApellido(String pApellido) { this.pApellido = pApellido; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}