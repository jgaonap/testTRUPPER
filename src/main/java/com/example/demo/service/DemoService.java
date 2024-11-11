package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.component.aspecto.AnotacionEjecucion;
import com.example.demo.dao.IOrdenDAO;
import com.example.demo.dao.IProductoDAO;
import com.example.demo.dao.ISucursalDAO;
import com.example.demo.dao.IUserDAO;
import com.example.demo.model.entity.Ordenes;
import com.example.demo.model.entity.Productos;
import com.example.demo.model.entity.Sucursales;
import com.example.demo.model.entity.User;

@Service
public class DemoService {

	@Autowired
	private IOrdenDAO ordenDAO;
	@Autowired
	private IUserDAO userDAO;
	@Autowired
	private ISucursalDAO sucursalDAO;
	@Autowired
	private IProductoDAO productoDAO;

	@AnotacionEjecucion
	public Iterable<Ordenes> saveOrUpdateOrden(Ordenes orden) {
		ordenDAO.save(orden);
		return findALL();
	}
	@AnotacionEjecucion
	public Iterable<Productos> saveOrUpdateProducto(Productos producto) {
		productoDAO.save(producto);
		return findALLPro();
	}
	@AnotacionEjecucion
	public Iterable<Sucursales> saveOrUpdateSucursal(Sucursales sucursal) {
		sucursalDAO.save(sucursal);
		return findALLSuc();
	}
	
	@AnotacionEjecucion
	public Optional<Ordenes> findBYID(Ordenes orden) {
		return ordenDAO.findById(orden.getOrden_id());
	}
	@AnotacionEjecucion
	public Iterable<Ordenes> findALL() {
		return ordenDAO.findAll();
	}
	@AnotacionEjecucion
	public Iterable<User> findALLUs() {
		Iterable<User> iterableU = userDAO.findAll();
		return iterableU;
	}
	@AnotacionEjecucion
	public Iterable<Productos> findALLPro() {
		return productoDAO.findAll();
	}
	@AnotacionEjecucion
	public Iterable<Sucursales> findALLSuc() {
		return sucursalDAO.findAll();
	}
}
