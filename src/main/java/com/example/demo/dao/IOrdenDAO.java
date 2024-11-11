package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Ordenes;

@Repository
public interface IOrdenDAO extends CrudRepository<Ordenes, Integer> {

}
