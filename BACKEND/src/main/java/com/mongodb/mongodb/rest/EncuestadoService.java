package com.mongodb.mongodb.rest;

import com.mongodb.mongodb.model.Encuestado;
import com.mongodb.mongodb.model.Filtro;
import com.mongodb.mongodb.repository.EncuestadoRepository;
import com.mongodb.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:8081"})
@RestController
@RequestMapping("/encuestados")
public class EncuestadoService extends AbstractoService{

    @Autowired
    EncuestadoRepository encuestadoRepository;

    //Get All Encuestados
    @GetMapping(value="/all")
    public ResponseEntity getAllEncuestados(){
        if(!isAuthorized(1)){
            return new ResponseEntity<>("No está autorizado.",HttpStatus.UNAUTHORIZED);
        }else{
            return new ResponseEntity<>(encuestadoRepository.findAll(),HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity create(@RequestBody Encuestado resource){ return new ResponseEntity<>(encuestadoRepository.save(resource),HttpStatus.CREATED);}

    @RequestMapping(method = RequestMethod.POST, value = "/graphics")
    @ResponseBody
    public List<Integer> showGraphics(@RequestBody Filtro filtro){
        //Fechas para arreglar
        System.out.println();
        System.out.println(filtro.getFechaInicial());
        System.out.println(filtro.getFechaFinal());
        System.out.println();

        //Procedimiento
        if(filtro.getVariableSD() == null){
            List<Encuestado> lista = encuestadoRepository.findAllByIdregionAndTipoEncuestaAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),filtro.getFechaInicial(),filtro.getFechaFinal());
            List<Integer> sumaResultado = new ArrayList<Integer>(Collections.nCopies(7, 0));//asignar 0's
            for(int i = 0; i < lista.size(); i++){
                for(int j = 0; j < lista.get(i).getResultados().size(); j++){
                    if(lista.get(i).getResultados().get(j).getIDCategoria().equals(filtro.getCategoria_id())){
                        List<Integer> res = lista.get(i).getResultados().get(j).getRespuesta();
                        for(int k = 0; k < res.size(); k++){
                            Integer indice = res.get(k);
                            Integer suma = sumaResultado.get(indice-1)+1;
                            sumaResultado.set(indice-1,suma);
                        }

                    }
                }
            }
            return sumaResultado;
        }else{
            //if por cada variable sociodemografico
            return null;
        }
        //return encuestadoRepository.findAllByIdregionAndTipoEncuestaAndFechaBetween(filtro.getRegion_id(),filtro.getTipoEncuesta(),filtro.getFechaInicial(),filtro.getFechaFinal());

        /*if(variableSD.isEmpty()){
        }else{
            //if por cada variable sociodemografico
            return null;
        }*/
    }
}
