package com.idat.EFERICKMARQUEZPIZERIA.controller;

import com.idat.EFERICKMARQUEZPIZERIA.model.Pizzeria;
import com.idat.EFERICKMARQUEZPIZERIA.service.PizzeriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/pizzeria")

public class PizzeriaController {


    @Autowired
    private PizzeriaServiceImpl pizzeriaServ;

    @GetMapping(path = "/listar")

    public @ResponseBody ResponseEntity<List<Pizzeria>> listarProfesores(){
        return new ResponseEntity<List<Pizzeria>>(pizzeriaServ.listar(),HttpStatus.OK);
    }

    @RequestMapping(path="/buscar/{id}",method = RequestMethod.GET)
    public ResponseEntity<Pizzeria> buscarProfesor(@PathVariable Integer id){
        Pizzeria pizzeria = pizzeriaServ.ObtenerPorId(id);
        if(pizzeria!=null) {
            return new ResponseEntity<Pizzeria>(pizzeria,HttpStatus.OK);
        }
        return new ResponseEntity<Pizzeria>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path="/guardar", method = RequestMethod.POST)
    public ResponseEntity<Void> guardar(@RequestBody Pizzeria pizzeria){
        pizzeriaServ.guardar(pizzeria);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizarProfesor(@RequestBody Pizzeria pizzeria){

        Pizzeria pro = pizzeriaServ.ObtenerPorId(pizzeria.getIdPizzeria());

        if(pro!=null) {
            pizzeriaServ.actualizar(pizzeria);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/eliminar/{idPizzeria}",method=RequestMethod.DELETE)
    public ResponseEntity<Void> eliminar(@PathVariable Integer idPizzeria){
        Pizzeria pizzeria = pizzeriaServ.ObtenerPorId(idPizzeria);
        if(pizzeria!=null) {
            pizzeriaServ.eliminar(idPizzeria);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

    }




}
