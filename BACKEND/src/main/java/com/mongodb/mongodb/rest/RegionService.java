package com.mongodb.mongodb.rest;

import com.mongodb.mongodb.model.Estadistica;
import com.mongodb.mongodb.model.Region;
import com.mongodb.mongodb.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8081"})
@RestController
@RequestMapping("/regiones")
public class RegionService {

    @Autowired
    RegionRepository regionRepository;

    //Get all Regiones
    @GetMapping(value="all")
    public List<Region> getAllRegiones(){ return regionRepository.findAll(); }

    //Insertar una nueva región
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Region create(@RequestBody Region resource){
        if(regionRepository.findById(resource.getID()).isPresent())
            return null;
        else
            return regionRepository.save(resource);
    }

    //Actualizar estadisticas
    @RequestMapping(value="/update/{id}/{mes}-{anio}",method = RequestMethod.PUT)
    @ResponseStatus
    @ResponseBody
    public Region update(@PathVariable("id") String id, @PathVariable("mes") int mes, @PathVariable("anio") int anio, @RequestBody Estadistica estadistica){
        Region region = regionRepository.findById(id).get();
        List<Estadistica> listaEstadisticas = region.getEstadisticas();
        for(int i = 0; i < listaEstadisticas.size(); i++){
            Estadistica est = listaEstadisticas.get(i);
            if(est.getMes()==mes && est.getAnio()==anio){
                est.setResultados(estadistica.getResultados());
                regionRepository.save(region);
            }
        }

        return region;

    }

    @RequestMapping(value="/add/{id}",method = RequestMethod.PUT)
    @ResponseStatus
    @ResponseBody
    public Region agregarEstadistica(@PathVariable("id") String id, @RequestBody Estadistica estadistica){
        Region region = regionRepository.findById(id).get();
        List<Estadistica> listaEstadistica = region.getEstadisticas();
        listaEstadistica.add(estadistica);
        region.setEstadisticas(listaEstadistica);
        regionRepository.save(region);
        return region;
    }


}
