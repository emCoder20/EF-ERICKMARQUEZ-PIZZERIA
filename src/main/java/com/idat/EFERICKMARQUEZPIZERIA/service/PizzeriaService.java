package com.idat.EFERICKMARQUEZPIZERIA.service;

import com.idat.EFERICKMARQUEZPIZERIA.model.Pizzeria;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PizzeriaService {

    Pizzeria ObtenerPorId(Integer idPizzeria);
    void guardar(Pizzeria pizzeria);
    void actualizar(Pizzeria pizzeria);
    void eliminar(Integer idPizzeria);
    List<Pizzeria> listar();

}
