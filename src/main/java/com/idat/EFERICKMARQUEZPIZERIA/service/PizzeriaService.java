package com.idat.EFERICKMARQUEZPIZERIA.service;


import com.idat.EFERICKMARQUEZPIZERIA.model.Pizzeria;

import java.util.List;

public interface PizzeriaService {

    Pizzeria ObtenerPorId(Integer idPizzeria);
    void guardar(Pizzeria pizzeria);
    void actualizar(Pizzeria pizzeria);
    void eliminar(Integer idPizzeria);
    List<Pizzeria> listar();
}
