package com.example.demo.repository;

import com.example.demo.model.DemoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDemoRepository extends CrudRepository<DemoModel, Integer> {
}
