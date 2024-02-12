package com.konstil.Ponude.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OpstiService <T, ID> {
    protected JpaRepository<T, ID> repository;
    public T save(T t) {
        return repository.save(t);
    }

    public T findById(ID id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    public void delete(T t) {
        repository.delete(t);
    }

    public T update(T t) {
        return repository.save(t);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

}
