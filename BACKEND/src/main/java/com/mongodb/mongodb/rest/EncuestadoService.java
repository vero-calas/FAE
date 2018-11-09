package com.mongodb.mongodb.rest;

import com.mongodb.mongodb.model.Encuestado;
import com.mongodb.mongodb.repository.EncuestadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8081"})
@RestController
@RequestMapping("/encuestados")
public class EncuestadoService {

    @Autowired
    EncuestadoRepository encuestadoRepository;

    //Get All Encuestados
    @GetMapping(value="/all")
    public ResponseEntity getAllEncuestados(){ return new ResponseEntity<>(encuestadoRepository.findAll(),HttpStatus.OK); }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity create(@RequestBody Encuestado resource){ return new ResponseEntity<>(encuestadoRepository.save(resource),HttpStatus.CREATED);}
}
