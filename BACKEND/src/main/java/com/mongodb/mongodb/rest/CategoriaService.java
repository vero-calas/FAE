package com.mongodb.mongodb.rest;

import com.mongodb.mongodb.model.Categoria;
import com.mongodb.mongodb.model.Pregunta;
import com.mongodb.mongodb.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/categories")
public class CategoriaService extends AbstractoService{

    @Autowired
    CategoriaRepository categoriaRepository;

    //Obtener todas las categorias, con sus preguntas
    @GetMapping(value="/all")
    public ResponseEntity getAllCategories(){
        return new ResponseEntity<>(categoriaRepository.findAll(),HttpStatus.OK);
    }

    //Insertar una nueva categoria, con nuevas preguntas
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity create(@RequestBody Categoria resource){
        if(!isAuthorized(1))
            return new ResponseEntity<>("No está autorizado.",HttpStatus.UNAUTHORIZED);
        else{
            if(categoriaRepository.findById(resource.getID()).isPresent()) {
                return new ResponseEntity<>("ID ya existe. ",HttpStatus.BAD_REQUEST);
            }
            else
                return new ResponseEntity<>(categoriaRepository.save(resource),HttpStatus.CREATED);
        }
    }

    //Actualizar una categoría agregando una pregunta
    @RequestMapping(value="/update/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity agregarPregunta(@PathVariable("id") String id, @RequestBody Pregunta pregunta){
        if(!isAuthorized(1)){
            return new ResponseEntity<>("No está autorizado.",HttpStatus.UNAUTHORIZED);
        }else{
            if(categoriaRepository.findById(id).isPresent()){
                Categoria categoria = categoriaRepository.findById(id).get();
                List<Pregunta> listadoPreguntas = categoria.getPreguntas();
                int idPregunta = findMax(listadoPreguntas.size(),null,listadoPreguntas,1);
                if(Integer.parseInt(pregunta.getIdpregunta()) <= idPregunta){
                    return new ResponseEntity<>("ID Pregunta ya existe.", HttpStatus.BAD_REQUEST);
                }else{
                    listadoPreguntas.add(pregunta);
                    categoria.setPreguntas(listadoPreguntas);
                    categoriaRepository.save(categoria);
                    return new ResponseEntity<>(categoria,HttpStatus.OK);
                }
            }else{
                return new ResponseEntity<>("ID Categoria no existe.",HttpStatus.BAD_REQUEST);
            }
        }
    }

    //Actualizar una pregunta de una categoría dada.
    @RequestMapping(value="/updatePregunta/{categoria_id}/{pregunta_id}",method = RequestMethod.PUT)
    @ResponseStatus
    @ResponseBody
    public ResponseEntity actualizarPregunta(@PathVariable("categoria_id") String categoria_id, @PathVariable("pregunta_id") String pregunta_id, @RequestBody Pregunta pregunta){
        if(!isAuthorized(1)){
            return new ResponseEntity<>("No está autorizado",HttpStatus.UNAUTHORIZED);
        }else{
            if(categoriaRepository.findById(categoria_id).isPresent()){
                Categoria categoria = categoriaRepository.findById(categoria_id).get();
                List<Pregunta> listadoPreguntas = categoria.getPreguntas();
                Pregunta pregunta1;
                for(int i = 0; i < listadoPreguntas.size(); i++){
                    pregunta1 = listadoPreguntas.get(i);
                    if(pregunta1.getIdpregunta().equals(pregunta_id)){
                        pregunta1.setPregunta(pregunta.getPregunta());
                        pregunta1.setEscala(pregunta.getEscala());
                        pregunta1.setOpciones(pregunta.getOpciones());
                        listadoPreguntas.set(i,pregunta1);
                        categoria.setPreguntas(listadoPreguntas);
                        categoriaRepository.save(categoria);
                        return new ResponseEntity<>(categoria,HttpStatus.OK);
                    }
                }
                return new ResponseEntity<>("ID Pregunta no existe",HttpStatus.BAD_REQUEST);
            }else{
                return new ResponseEntity<>("ID Categoría no existe",HttpStatus.BAD_REQUEST);
            }
        }
    }

    //Eliminar una pregunta dada una categoria
    @RequestMapping(value="/deletePregunta/{categoria_id}/{pregunta_id}",method = RequestMethod.DELETE)
    @ResponseStatus
    @ResponseBody
    public ResponseEntity eliminarPregunta(@PathVariable("categoria_id") String categoria_id, @PathVariable("pregunta_id") String pregunta_id){
        if(!isAuthorized(1)){
            return new ResponseEntity<>("No está autorizado",HttpStatus.UNAUTHORIZED);
        }else{
            if(categoriaRepository.findById(categoria_id).isPresent()){
                Categoria categoria = categoriaRepository.findById(categoria_id).get();
                List<Pregunta> listadoPreguntas = categoria.getPreguntas();
                for(int i = 0; i < listadoPreguntas.size(); i++){
                    if(listadoPreguntas.get(i).getIdpregunta().equals(pregunta_id)){
                        listadoPreguntas.remove(i);
                        categoria.setPreguntas(listadoPreguntas);
                        categoriaRepository.save(categoria);
                        return new ResponseEntity<>(categoriaRepository.findAll(), HttpStatus.OK);
                    }
                }
                return new ResponseEntity<>("ID Pregunta no existe",HttpStatus.BAD_REQUEST);
            }else{
                return new ResponseEntity<>("ID Categoría no existe",HttpStatus.BAD_REQUEST);
            }
        }
    }

    //Actualizar una categoria (Sin actualizar preguntas)
    @RequestMapping(value="/updateCategoria/{categoria_id}",method = RequestMethod.PUT)
    @ResponseStatus
    @ResponseBody
    public ResponseEntity actualizarCategoria(@PathVariable("categoria_id") String categoria_id, @RequestBody Categoria categoria){
        if(!isAuthorized(1)){
            return new ResponseEntity<>("No está autorizado.",HttpStatus.UNAUTHORIZED);
        }else{
            if(categoriaRepository.findById(categoria_id).isPresent()){
                Categoria categoria1 = categoriaRepository.findById(categoria_id).get();
                categoria1.setNombre(categoria.getNombre());
                categoria1.setDescripcion(categoria.getDescripcion());
                categoriaRepository.save(categoria1);
                return new ResponseEntity<>(categoriaRepository.findAll(),HttpStatus.OK);
            }else{
                return new ResponseEntity<>("ID Categoría no existe",HttpStatus.BAD_REQUEST);
            }
        }
    }


    //Entrega el último ID de la Categoría + 1
    @RequestMapping(value="/id", method = RequestMethod.GET)
    @ResponseStatus
    @ResponseBody
    public ResponseEntity getLastId(){
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        int id = findMax(listaCategorias.size(),listaCategorias,null,0)+1;
        return new ResponseEntity<>(Integer.toString(id),HttpStatus.OK);
    }


    //Entrega el último ID de pregunta de una categoría dada
    @RequestMapping(value="/preguntaid/{categoriaid}", method = RequestMethod.GET)
    @ResponseStatus
    @ResponseBody
    public ResponseEntity getLastIDpregunta(@PathVariable("categoriaid") String categoriaId){
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        int idPregunta=0;
        for(int i = 0; i < listaCategorias.size(); i++){
            if(listaCategorias.get(i).ID.equals(categoriaId)){
                List<Pregunta> preguntas1 = listaCategorias.get(i).preguntas;
                idPregunta = findMax(preguntas1.size(),null,preguntas1,1)+1;
            }
        }
        return new ResponseEntity<>(Integer.toString(idPregunta),HttpStatus.OK);
    }

    @RequestMapping(value="/deleteCategoria/{categoriaid}", method = RequestMethod.DELETE)
    @ResponseStatus
    public ResponseEntity eliminarCategoria(@PathVariable("categoriaid") String categoriaId){
        if(!isAuthorized(1)){
            return new ResponseEntity<>("No está autorizado.",HttpStatus.UNAUTHORIZED);
        }else{
            if(categoriaRepository.findById(categoriaId).isPresent()){
                categoriaRepository.deleteById(categoriaId);
                return new ResponseEntity<>(categoriaRepository.findAll(),HttpStatus.OK);
            }else{
                return new ResponseEntity<>("ID Categoría no existe.",HttpStatus.BAD_REQUEST);
            }
        }
    }


    //Actualiza el nombre de la empresa con la que se debe reemplazar a "Chile"
    @RequestMapping(value="/updateEmpresa/{nombreempresa}", method = RequestMethod.PUT)
    @ResponseStatus
    @ResponseBody
    public ResponseEntity updateEmpresa(@PathVariable("nombreempresa") String nombreEmpresa){
        if(!isAuthorized(1)){
            return new ResponseEntity<>("No está autorizado.",HttpStatus.UNAUTHORIZED);
        }else{
            List<Categoria> categorias = categoriaRepository.findAll();
            for(int i = 0; i < categorias.size(); i++){
                System.out.println(nombreEmpresa);
                categorias.get(i).setEmpresa(nombreEmpresa);
                categoriaRepository.save(categorias.get(i));
            }
            return new ResponseEntity<>("Nombre Empresa agregado exitosamente",HttpStatus.OK);
        }
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