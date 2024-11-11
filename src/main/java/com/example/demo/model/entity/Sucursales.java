package com.example.demo.model.entity;

import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Sucursal")
public class Sucursales {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sucursal_id")
	private int sucursal_id;
	@Nonnull
	private String nombre;

	@OneToMany(mappedBy = "sucursales")
	private List<Ordenes> ordenes;

	public int getSucursal_id() {
		return sucursal_id;
	}

	public void setSucursal_id(int sucursal_id) {
		this.sucursal_id = sucursal_id;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Ordenes> getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(List<Ordenes> ordenes) {
		this.ordenes = ordenes;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Sucursales [sucursal_id=" + sucursal_id + ", nombre=" + nombre + ", ordenes=" + ordenes + "]";
	}

}
