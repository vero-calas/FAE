package com.mongodb.mongodb.rest;

import com.mongodb.mongodb.model.Estadistica;
import com.mongodb.mongodb.model.Region;
import com.mongodb.mongodb.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:8081"})
@RestController
@RequestMapping("/regiones")
public class RegionService {

    @Autowired
    RegionRepository regionRepository;

    //Get all Regiones
    @GetMapping(value="all")
    public ResponseEntity getAllRegiones(){ return new ResponseEntity<>(regionRepository.findAll(),HttpStatus.OK); }

    //Insertar una nueva región
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity create(@RequestBody Region resource){
        if(regionRepository.findById(resource.getID()).isPresent())
            return new ResponseEntity<>("ID Región ya existe.", HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(regionRepository.save(resource), HttpStatus.CREATED);
    }

    //Actualizar estadisticas
    @RequestMapping(value="/update/{id}/{mes}-{anio}",method = RequestMethod.PUT)
    @ResponseStatus
    @ResponseBody
    public ResponseEntity update(@PathVariable("id") String id, @PathVariable("mes") int mes, @PathVariable("anio") int anio, @RequestBody Estadistica estadistica){
        if(regionRepository.findById(id).isPresent()){
            Region region = regionRepository.findById(id).get();
            List<Estadistica> listaEstadisticas = region.getEstadisticas();
            for(int i = 0; i < listaEstadisticas.size(); i++){
                Estadistica est = listaEstadisticas.get(i);
                if(Integer.parseInt(est.getFecha().get(0))==mes && Integer.parseInt(est.getFecha().get(1))==anio){
                    est.setResultados(estadistica.getResultados());
                    regionRepository.save(region);
                    return new ResponseEntity<>(region,HttpStatus.OK);
                }
            }
            return new ResponseEntity<>("Fecha no existe.",HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>("ID Region no existe.",HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value="/add/{id}",method = RequestMethod.PUT)
    @ResponseStatus
    @ResponseBody
    public ResponseEntity agregarEstadistica(@PathVariable("id") String id, @RequestBody Estadistica estadistica){
        if(regionRepository.findById(id).isPresent()){
            Region region = regionRepository.findById(id).get();
            List<Estadistica> listaEstadistica = region.getEstadisticas();
            listaEstadistica.add(estadistica);
            region.setEstadisticas(listaEstadistica);
            regionRepository.save(region);
            return new ResponseEntity<>(region,HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("ID Region no existe.",HttpStatus.BAD_REQUEST);
        }
    }


}
