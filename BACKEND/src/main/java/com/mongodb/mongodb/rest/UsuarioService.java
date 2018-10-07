package com.mongodb.mongodb.rest;

import com.mongodb.mongodb.model.Usuario;
import com.mongodb.mongodb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @ResponseStatus
    @ResponseBody
    public String login(@RequestBody Usuario user){
        Usuario realUser = usuarioRepository.findByCorreo(user.getCorreo());
        if(realUser != null) {
            if(realUser.getContrasena().equals(user.getContrasena())){
                return "Loggeado";
            }else{
                return "Contraseña Incorrecta";
            }
        }else{
            return "No existe usuario.";
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