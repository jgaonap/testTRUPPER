package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.entity.Productos;

public interface IProductoDAO extends CrudRepository<Productos, Integer> {

}
