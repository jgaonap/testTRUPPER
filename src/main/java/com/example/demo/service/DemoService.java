package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IOrdenDAO;
import com.example.demo.model.entity.Ordenes;

@Service
public class DemoService {

	@Autowired
	private IOrdenDAO ordenDAO;

	public Iterable<Ordenes> saveOrUpdateOrden(Ordenes orden) {
		ordenDAO.save(orden);
		return findALL(orden);
	}

	public Optional<Ordenes> findBYID(Ordenes orden) {
		return ordenDAO.findById(orden.getOrden_id());
	}

	public Iterable<Ordenes> findALL(Ordenes orden) {
		return ordenDAO.findAll();
	}

}
