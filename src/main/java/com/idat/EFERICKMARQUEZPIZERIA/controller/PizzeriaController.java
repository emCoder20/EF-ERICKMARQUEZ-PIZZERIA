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
@RequestMapping("/pizzeria")
public class PizzeriaController {

    @Autowired
    private PizzeriaServiceImpl pizzeriaServ;

    @GetMapping("/listar")
    public @ResponseBody
    ResponseEntity<List<Pizzeria>> listarPizz(){
        return new ResponseEntity<List<Pizzeria>>(pizzeriaServ.listar(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{idPizzeria}")
    public ResponseEntity<Pizzeria> buscarPizz(@PathVariable Integer idPizzeria){
        Pizzeria pi = pizzeriaServ.ObtenerPorId(idPizzeria);
        if(pi!=null) {
            return new ResponseEntity<Pizzeria>(pi,HttpStatus.OK);
        }
        return new ResponseEntity<Pizzeria>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Void> guardarPizz(@RequestBody Pizzeria pizzeria){
        pizzeriaServ.guardar(pizzeria);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PostMapping("actualizar")
    public ResponseEntity<Void> actualizarPizz(@RequestBody Pizzeria pizzeria){

        Pizzeria  pi = pizzeriaServ.ObtenerPorId(pizzeria.getIdPizzeria());

        if(pi!=null) {
            pizzeriaServ.actualizar(pizzeria);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/eliminar/{idPizzeria}")
    public ResponseEntity<Void> eliminarPizz(@PathVariable Integer idPizzeria){
        Pizzeria pi = pizzeriaServ.ObtenerPorId(idPizzeria);
        if(pi!=null) {
            pizzeriaServ.eliminar(idPizzeria);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

    }

}

