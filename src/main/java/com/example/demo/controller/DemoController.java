package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entity.Ordenes;
import com.example.demo.service.DemoService;

@RestController
public class DemoController {

	@Autowired
	private DemoService demoServicice;

	@PostMapping("save")
	public Iterable<Ordenes> saveOrdenes(@RequestBody Ordenes orden) {
		return demoServicice.saveOrUpdateOrden(orden);
	}
	
	@GetMapping("findByID")
	public Optional<Ordenes> getOrdenesPorID(@RequestBody Ordenes orden) {
		return demoServicice.findBYID(orden);
	}
	
	@GetMapping("findAll")
	public Iterable<Ordenes> getOrdenes(@RequestBody Ordenes orden) {
		return demoServicice.findALL(orden);
	}
	
	
	@PutMapping("update")
	public Iterable<Ordenes> saveOrde(@RequestBody Ordenes orden) {
		return demoServicice.saveOrUpdateOrden(orden);
	}

}
