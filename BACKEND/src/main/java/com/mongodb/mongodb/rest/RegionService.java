package com.mongodb.mongodb.rest;

import com.mongodb.mongodb.model.Region;
import com.mongodb.mongodb.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/regiones")
public class RegionService extends AbstractoService{

    @Autowired
    RegionRepository regionRepository;

    //Get all Regiones
    @GetMapping(value="all")
    public ResponseEntity getAllRegiones(){
        return new ResponseEntity<>(regionRepository.findAll(),HttpStatus.OK);
    }

    //Insertar una nueva región
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity create(@RequestBody Region resource){
        if(regionRepository.findById(resource.getID()).isPresent())
            return new ResponseEntity<>("ID Región ya existe.", HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(regionRepository.save(resource), HttpStatus.CREATED);
    }

    //Get one región
    @GetMapping(value="/{id}")
    public ResponseEntity getOneRegion(@PathVariable("id") String id){
        if(regionRepository.findById(id).isPresent())
            return new ResponseEntity<>(regionRepository.findById(id), HttpStatus.OK);
        else
            return new ResponseEntity<>("No existe ID", HttpStatus.BAD_REQUEST);
    }
}
