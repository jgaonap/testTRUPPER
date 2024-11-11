package com.example.demo.model.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.Cascade;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orden")
public class Ordenes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orden_id")
	private int orden_id;
	@ManyToOne
	@Cascade(org.hibernate.annotations.CascadeType.PERSIST)
	@JoinColumn(name = "sucursal_id")
	private Sucursales sucursales;
	@Nonnull
	private LocalDate fecha;
	@Nonnull
	private double total;
	@OneToMany(mappedBy = "ordenes", cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<Productos> productos;

	public int getOrden_id() {
		return orden_id;
	}

	public void setOrden_id(int orden_id) {
		this.orden_id = orden_id;
	}

	public Sucursales getSucursales() {
		return sucursales;
	}

	public void setSucursales(Sucursales sucursales) {
		this.sucursales = sucursales;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<Productos> getProductos() {
		return productos;
	}

	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Ordenes [orden_id=" + orden_id + ", sucursales=" + sucursales + ", fecha=" + fecha + ", total=" + total
				+ ", productos=" + productos + "]";
	}

}
