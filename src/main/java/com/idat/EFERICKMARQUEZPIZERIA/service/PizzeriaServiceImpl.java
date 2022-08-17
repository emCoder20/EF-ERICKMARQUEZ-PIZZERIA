package com.idat.EFERICKMARQUEZPIZERIA.service;

import com.idat.EFERICKMARQUEZPIZERIA.model.Pizzeria;
import com.idat.EFERICKMARQUEZPIZERIA.repository.PizzeriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PizzeriaServiceImpl implements PizzeriaService{

    @Autowired
    private PizzeriaRepository repository;

    @Override
    public Pizzeria ObtenerPorId(Integer idPizzeria) {
        return repository.findById(idPizzeria).orElse(null);
    }

    @Override
    public void guardar(Pizzeria pizzeria) {
        repository.save(pizzeria);
    }

    @Override
    public void actualizar(Pizzeria pizzeria) {
        repository.saveAndFlush(pizzeria);
    }



    @Override
    public void eliminar(Integer idPizzeria) {
        repository.deleteById(idPizzeria);
    }

    @Override
    public List<Pizzeria> listar() {
        return null;
    }


}
