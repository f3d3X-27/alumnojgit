package com.example.alumnojgit.controllers;

import com.example.alumnojgit.entities.Base;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.util.Map;

public interface BaseController<E extends Base, ID extends Serializable> {

    public ResponseEntity<?> getAll();

    public ResponseEntity<?> getAll(Pageable pageable);

    // METODO PERTENECIENTE A UN VIDEO ELIMINADO. REEMPLAZADO POR EL DE ARRIBA
//    public ResponseEntity<Map<String, Object>> getAll(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "8") int size,
//            @RequestParam(defaultValue = "id") String sortBy,
//            @RequestParam(defaultValue = "desc") String direction
//    );

    public ResponseEntity<?> getOne(@PathVariable ID id);

    public ResponseEntity<?> save(@RequestBody E entity);

    public ResponseEntity<?> update(@RequestBody E entity, @PathVariable ID id);

    public ResponseEntity<?> delete(@PathVariable ID id);

}
