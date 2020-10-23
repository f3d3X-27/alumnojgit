package com.example.alumnojgit.services;

import com.example.alumnojgit.entities.Base;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends Base, ID extends Serializable> {

    //public Map<String, Object> findAll(int page, int size, String sortBy, String direction) throws Exception; // METODO DE UN VIDEO QUE FUE ELIMINADO

    public List<E> findAll() throws Exception;

    public Page<E> findAll(Pageable pageable) throws Exception;

    public E findById(ID id) throws Exception;

    public E save(E entity) throws Exception;

    public E update(E entity, ID id) throws Exception;

    public boolean delete(ID id) throws Exception;

}
