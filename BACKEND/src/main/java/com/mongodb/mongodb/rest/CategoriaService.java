package com.mongodb.mongodb.rest;

import com.mongodb.mongodb.model.Categoria;
import com.mongodb.mongodb.model.Pregunta;
import com.mongodb.mongodb.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8081"})
@RestController
@RequestMapping("/categories")
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    //Obtener todas las categorias, con sus preguntas
    @GetMapping(value="/all")
    public List<Categoria> getAllCategories(){ return categoriaRepository.findAll(); }

    //Insertar una nueva categoria, con nuevas preguntas
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Categoria create(@RequestBody Categoria resource){
        return categoriaRepository.save(resource);
    }

    //Actualizar una categoría agregando una pregunta
    @RequestMapping(value="/update/{id}",method = RequestMethod.PUT)
    @ResponseStatus
    @ResponseBody
    public Categoria agregarPregunta(@PathVariable("id") String id, @RequestBody Pregunta pregunta){
        Categoria categoria = categoriaRepository.findById(id).get();
        List<Pregunta> listadoPreguntas = categoria.getPreguntas();
        listadoPreguntas.add(pregunta);
        categoria.setPreguntas(listadoPreguntas);
        categoriaRepository.save(categoria);
        return categoria;
    }

    /*
    @RequestMapping(value="/updatePregunta/{categoria_id}/{pregunta_id}",method = RequestMethod.PUT)
    @ResponseStatus
    @ResponseBody
    public Categoria actualizarPregunta(@PathVariable("categoria_id") String categoria_id, @PathVariable("pregunta_id") String pregunta_id, @RequestBody Pregunta pregunta){
        Categoria categoria = categoriaRepository.findById()
    }*/

    //Agregar filtro por id.


    //Entrega el último ID de la Categoría + 1
    @RequestMapping(value="/id", method = RequestMethod.GET)
    @ResponseStatus
    @ResponseBody
    public String getLastId(){
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        int id = findMax(listaCategorias.size(),listaCategorias,null,0)+1;
        return Integer.toString(id);
    }


    //Entrega el último ID de pregunta de una categoría dada
    @RequestMapping(value="/preguntaid/{categoriaid}", method = RequestMethod.GET)
    @ResponseStatus
    @ResponseBody
    public String getLastIDpregunta(@PathVariable("categoriaid") String categoriaId){
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        int idPregunta=0;
        for(int i = 0; i < listaCategorias.size(); i++){
            if(listaCategorias.get(i).ID.equals(categoriaId)){
                List<Pregunta> preguntas1 = listaCategorias.get(i).preguntas;
                idPregunta = findMax(preguntas1.size(),null,preguntas1,1)+1;
            }
        }
        return Integer.toString(idPregunta);
    }

    private int findMax(int size, List<Categoria> listaCategoria, List<Pregunta> listaPreguntas, int esPregunta /*Para saber si es pregunta o categoria*/){
        String id;
        int id1;
        int max = 0;
        if(esPregunta==0){
            for(int i = 0; i < size; i++){
                id = listaCategoria.get(i).ID;
                id1 = Integer.parseInt(id);
                max = Math.max(id1,max);
            }
        }else if(esPregunta==1){
            for(int j = 0; j < size; j++){
                id = listaPreguntas.get(j).getIdpregunta();
                id1 = Integer.parseInt(id);
                max = Math.max(id1,max);
            }
        }
        return max;
    }


}