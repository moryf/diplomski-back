package com.konstil.Ponude.service;

import com.konstil.Ponude.exception.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OpstiService <T, ID> {
    protected JpaRepository<T, ID> repository;
    public T save(T t) {
        try {
            return repository.save(t);
        } catch (Exception e) {
            throw new ServerException("Greska prilikom cuvanja entiteta:" + e.getMessage());
        }
    }

    public T findById(ID id) {
        try {
            return repository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new ServerException("Greska prilikom dohvatanja entiteta:" + e.getMessage());
        }
    }

    public void deleteById(ID id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new ServerException("Greska prilikom brisanja entiteta:" + e.getMessage());
        }
    }

    public void delete(T t) {
        try {
            repository.delete(t);
        } catch (Exception e) {
            throw new ServerException("Greska prilikom brisanja entiteta:" + e.getMessage());
        }
    }

    public T update(T t) {
        try {
            return repository.save(t);
        } catch (Exception e) {
            throw new ServerException("Greska prilikom azuriranja entiteta:" + e.getMessage());
        }
    }

    public List<T> findAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new ServerException("Greska prilikom dohvatanja svih entiteta:" + e.getMessage());
        }
    }

}
