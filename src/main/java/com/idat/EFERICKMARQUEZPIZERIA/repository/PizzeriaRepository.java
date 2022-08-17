package com.idat.EFERICKMARQUEZPIZERIA.repository;

import com.idat.EFERICKMARQUEZPIZERIA.model.Pizzeria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzeriaRepository extends JpaRepository<Pizzeria, Integer> {


}
