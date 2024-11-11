package com.example.demo.model.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Producto")
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int producto_id;
	@ManyToOne
	@JoinColumn(name = "orden_id")
	private Ordenes ordenes;
	@Nonnull
	private String codigo;
	@Nonnull
	private String decripcion;
	@Nonnull
	private double precio;

	public int getProducto_id() {
		return producto_id;
	}

	public void setProducto_id(int producto_id) {
		this.producto_id = producto_id;
	}

	public Ordenes getOrdenes() {
		return ordenes;
	}

	public void setOrdenes(Ordenes ordenes) {
		this.ordenes = ordenes;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDecripcion() {
		return decripcion;
	}

	public void setDecripcion(String decripcion) {
		this.decripcion = decripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Productos [producto_id=" + producto_id + ", ordenes=" + ordenes + ", codigo=" + codigo + ", decripcion="
				+ decripcion + ", precio=" + precio + "]";
	}

}
