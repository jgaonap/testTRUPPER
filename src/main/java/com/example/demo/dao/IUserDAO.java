package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.entity.User;

public interface IUserDAO extends CrudRepository<User, Integer> {

}
