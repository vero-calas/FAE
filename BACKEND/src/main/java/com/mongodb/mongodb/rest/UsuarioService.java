package com.mongodb.mongodb.rest;

import com.mongodb.mongodb.config.JwtConfig;
import com.mongodb.mongodb.model.Usuario;
import com.mongodb.mongodb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static com.mongodb.mongodb.config.JwtConfig.HEADER_STRING;
import static com.mongodb.mongodb.config.JwtConfig.TOKEN_PREFIX;
import static com.mongodb.mongodb.config.JwtConfig.tokenize;

@CrossOrigin(origins = {"http://localhost:8081"})
@RestController
@RequestMapping("/usuarios")
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    //Get All Usuarios
    @GetMapping(value = "/all")
    public List<Usuario> getAllUsuario() { return usuarioRepository.findAll(); }

    //Agregar un nuevo usuario
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Usuario create(@RequestBody Usuario resource){
        if(usuarioRepository.findByCorreo(resource.getCorreo())==null){
            return usuarioRepository.save(resource);
        }else{
            return null;
        }
    }

    //Editar la información de un usuario
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseStatus
    @ResponseBody
    public List<Usuario> update(@PathVariable("id") String id, @RequestBody Usuario usuario){

        Usuario usuario1 = usuarioRepository.findById(id).get();
        usuario1.setActivo(usuario.getActivo());
        usuario1.setContrasena(usuario.getContrasena());
        usuario1.setCorreo(usuario.getCorreo());
        usuario1.setNombre(usuario.getNombre());
        usuario1.setRol(usuario.getRol());
        usuarioRepository.save(usuario1);
        return usuarioRepository.findAll();
    }

    //Filtrar por nombre
    @RequestMapping(value="/name/{nombre}", method = RequestMethod.GET)
    @ResponseStatus
    @ResponseBody
    public List<Usuario> getByName(@PathVariable("nombre") String nombre){
        return usuarioRepository.findAllByNombreContaining(nombre);
    }

    //Filtrar por correo
    @RequestMapping(value="/email/{correo}", method = RequestMethod.GET)
    @ResponseStatus
    @ResponseBody
    public Usuario getByEmail(@PathVariable("correo") String correo){
        return usuarioRepository.findByCorreo(correo);
    }

    //Entrega el último ID + 1
    @RequestMapping(value="/id", method = RequestMethod.GET)
    @ResponseStatus
    @ResponseBody
    public String getLastId(){
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        int id = findMax(listaUsuarios.size(),listaUsuarios)+1;
        return Integer.toString(id);
    }


    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody Usuario user){
        Usuario realUser = usuarioRepository.findByCorreo(user.getCorreo());
        if(realUser != null) {
            if(realUser.getContrasena().equals(user.getContrasena())){
                MultiValueMap<String, String> multivalue = new LinkedMultiValueMap<String, String>();
                multivalue.add(HEADER_STRING,TOKEN_PREFIX + tokenize(user));
                return new ResponseEntity(multivalue,HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Contraseña Incorrecta",HttpStatus.UNAUTHORIZED);
            }
        }else{
            return new ResponseEntity<>("No existe usuario.", HttpStatus.BAD_REQUEST);
        }
    }

    private int findMax(int size, List<Usuario> lista){
        String id;
        int id1;
        int max = 0;
        for(int i = 0; i < size; i++){
            id = lista.get(i).ID;
            id1 = Integer.parseInt(id);
            max = Math.max(id1,max);
        }
        return max;
    }
}