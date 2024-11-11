package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entity.Ordenes;
import com.example.demo.model.entity.Productos;
import com.example.demo.model.entity.Sucursales;
import com.example.demo.model.entity.User;
import com.example.demo.service.DemoService;

@RestController
public class DemoController {

	@Autowired
	private DemoService demoServicice;

	@PostMapping("save")
	public Iterable<Ordenes> saveOrdenes(@RequestBody Ordenes orden) {
		Iterable<Ordenes> ordenI = demoServicice.saveOrUpdateOrden(orden);
		return ordenI;
	}

	@GetMapping("findByID")
	public Optional<Ordenes> getOrdenesPorID(@RequestBody Ordenes orden) {
		return demoServicice.findBYID(orden);
	}

	@PutMapping("updateOrden")
	public Iterable<Ordenes> saveOrde(@RequestBody Ordenes orden) {
		return demoServicice.saveOrUpdateOrden(orden);
	}

	@PutMapping("updateProductos")
	public Iterable<Productos> saveOrde(@RequestBody Productos producto) {
		return demoServicice.saveOrUpdateProducto(producto);
	}

	@PutMapping("updateSucursales")
	public Iterable<Sucursales> saveOrde(@RequestBody Sucursales sucursal) {
		return demoServicice.saveOrUpdateSucursal(sucursal);
	}

	@GetMapping("ordenes")
	public Iterable<Ordenes> getOrdenes() {
		return demoServicice.findALL();
	}

	@GetMapping("logins")
	public Iterable<User> getUsers() {
		Iterable<User> userI = demoServicice.findALLUs();
		return userI;
	}

	@GetMapping("sucursales")
	public Iterable<Sucursales> getSucursales() {
		return demoServicice.findALLSuc();
	}

	@GetMapping("productos")
	public Iterable<Productos> getProductos() {
		return demoServicice.findALLPro();
	}

}
