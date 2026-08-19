package com.example.prueba1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCTO")
public class Producto {

    @Id
    @Column(name = "COD_PROD", length = 10)
    private String codProd;

    @Column(name = "DESC_PROD", length = 45)
    private String descProd;

    @Column(name = "PRECIO_PROD")
    private Double precioProd;

    @Column(name = "STOCK_MAX")
    private Integer stockMax;

    @Column(name = "STOCK_MIN")
    private Integer stockMin;

    @Column(name = "CANTIDAD_EXISTE")
    private Integer cantidadExiste;

    // Relación: Muchos productos pertenecen a una Categoría
    @ManyToOne
    @JoinColumn(name = "CATEGORIA_COD_CATEGORIA") // Llave foránea en MySQL
    private Categoria categoria;

    // Constructor vacío obligatorio para JPA
    public Producto() {}

    // Getters y Setters
    public String getCodProd() { return codProd; }
    public void setCodProd(String codProd) { this.codProd = codProd; }

    public String getDescProd() { return descProd; }
    public void setDescProd(String descProd) { this.descProd = descProd; }

    public Double getPrecioProd() { return precioProd; }
    public void setPrecioProd(Double precioProd) { this.precioProd = precioProd; }

    public Integer getStockMax() { return stockMax; }
    public void setStockMax(Integer stockMax) { this.stockMax = stockMax; }

    public Integer getStockMin() { return stockMin; }
    public void setStockMin(Integer stockMin) { this.stockMin = stockMin; }

    public Integer getCantidadExiste() { return cantidadExiste; }
    public void setCantidadExiste(Integer cantidadExiste) { this.cantidadExiste = cantidadExiste; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}