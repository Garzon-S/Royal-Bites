package com.example.prueba1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CATEGORIA") // Debe coincidir exactamente con el nombre en tu SQL
public class Categoria {

    @Id // Define la llave primaria
    @Column(name = "COD_CATEGORIA", length = 5)
    private String codCategoria;

    @Column(name = "DESC_CATE", length = 45)
    private String descCate;

    // --- CONSTRUCTORES ---
    public Categoria() {}

    public Categoria(String codCategoria, String descCate) {
        this.codCategoria = codCategoria;
        this.descCate = descCate;
    }

    // --- GETTERS Y SETTERS (Obligatorios para que Spring lea los datos) ---
    public String getCodCategoria() { return codCategoria; }
    public void setCodCategoria(String codCategoria) { this.codCategoria = codCategoria; }

    public String getDescCate() { return descCate; }
    public void setDescCate(String descCate) { this.descCate = descCate; }
}