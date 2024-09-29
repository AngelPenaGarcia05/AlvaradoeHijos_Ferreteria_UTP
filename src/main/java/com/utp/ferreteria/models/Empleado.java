package com.utp.ferreteria.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.Setter;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String nombres;

    @Column(length = 100)
    private String apellidos;

    @Column(length = 8)
    private String dni;

    @Column
    private String contrasena;

    @Column(length = 100)
    private String email;

    @Column(length = 9)
    private String telefono;

    @Column(length = 200)
    private String direccion;

    @Column(precision = 10, scale = 2)
    private BigDecimal salario;

    @Column(length = 50)
    public String puesto;

    @Temporal(TemporalType.DATE)
    public Date fechaContratacion;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Venta> ventas;

}
