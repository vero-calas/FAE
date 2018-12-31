package com.mongodb.mongodb.rest;

import com.mongodb.mongodb.config.JwtConfig;
import com.mongodb.mongodb.model.Usuario;
import com.mongodb.mongodb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mongodb.mongodb.config.JwtConfig.*;

@CrossOrigin(origins = {"http://localhost:8081"})
@RestController
@RequestMapping("/usuarios")
public class UsuarioService extends AbstractoService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    //Get All Usuarios
    @GetMapping(value = "/all")
    public ResponseEntity getAllUsuario() {
        if(!isAuthorized(1)){
            return new ResponseEntity<>("No está autorizado",HttpStatus.UNAUTHORIZED);
        }else{
            return new ResponseEntity<>(usuarioRepository.findAll(),HttpStatus.OK);
        }
    }

    //Agregar un nuevo usuario
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity create(@RequestBody Usuario resource){
        if(usuarioRepository.findByCorreo(resource.getCorreo())==null){
            resource.setActivo(false);
            String encryptPass = bCryptPasswordEncoder.encode(resource.getContrasena());
            resource.setContrasena(encryptPass);
            return new ResponseEntity<>(usuarioRepository.save(resource),HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Correo ya existe.",HttpStatus.BAD_REQUEST);
        }
    }

    //Editar la información de un usuario
    @RequestMapping(value = "/update/{parametro}/{id}", method = RequestMethod.PUT)
    @ResponseStatus
    @ResponseBody
    public ResponseEntity update(@PathVariable("id") String id, @PathVariable("parametro") Integer parametro,@RequestBody Usuario usuario){
        if(!isAuthorized(1) && !isAuthorized(2)){
            return new ResponseEntity<>("No está autorizado",HttpStatus.UNAUTHORIZED);
        }else{
            if(usuarioRepository.findById(id).isPresent()){
                Usuario usuario1;
                switch(parametro){
                    case 0:  //nombre
                        usuario1 = usuarioRepository.findById(id).get();
                        usuario1.setNombre(usuario.getNombre());
                        usuarioRepository.save(usuario1);
                        break;
                    case 1:  //password
                        usuario1 = usuarioRepository.findById(id).get();
                        String[] pass = usuario.getContrasena().split(" ");
                        if(bCryptPasswordEncoder.matches(pass[0],usuario1.getContrasena())){
                            String encryptPass = bCryptPasswordEncoder.encode(pass[1]);
                            usuario1.setContrasena(encryptPass);
                            usuarioRepository.save(usuario1);
                        }else{
                            return new ResponseEntity<>("Contraseña Actual Incorrecta", HttpStatus.BAD_REQUEST);
                        }
                        break;
                    case 2:  //activo
                        usuario1 = usuarioRepository.findById(id).get();
                        usuario1.setActivo(usuario.getActivo());
                        usuarioRepository.save(usuario1);
                        break;
                    case 3:  //telefono
                        usuario1 = usuarioRepository.findById(id).get();
                        usuario1.setTelefono(usuario.getTelefono());
                        usuarioRepository.save(usuario1);
                        break;
                }
                return new ResponseEntity<>(usuarioRepository.findAll(),HttpStatus.OK);
            }else{
                return new ResponseEntity<>("ID Usuario no existe",HttpStatus.BAD_REQUEST);
            }
        }
    }

    //Filtrar por nombre
    @RequestMapping(value="/name/{nombre}", method = RequestMethod.GET)
    @ResponseStatus
    public ResponseEntity getByName(@PathVariable("nombre") String nombre){
        if(!isAuthorized(1))
            return new ResponseEntity<>("No está autorizado",HttpStatus.UNAUTHORIZED);
        else
            return new ResponseEntity<>(usuarioRepository.findAllByNombreContaining(nombre),HttpStatus.OK);
    }

    //Filtrar por correo
    @RequestMapping(value="/email/{correo}", method = RequestMethod.GET)
    @ResponseStatus
    @ResponseBody
    public ResponseEntity getByEmail(@PathVariable("correo") String correo){
        if(!isAuthorized(1))
            return new ResponseEntity<>("No está autorizado",HttpStatus.UNAUTHORIZED);
        else
            return new ResponseEntity<>(usuarioRepository.findByCorreo(correo),HttpStatus.OK);
    }

    //Entrega el último ID + 1
    @RequestMapping(value="/id", method = RequestMethod.GET)
    @ResponseStatus
    public ResponseEntity getLastId(){
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        int id = findMax(listaUsuarios.size(),listaUsuarios)+1;
        return new ResponseEntity<>(Integer.toString(id),HttpStatus.OK);
    }


    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody Usuario user){
        Usuario realUser = usuarioRepository.findByCorreo(user.getCorreo());
        if(realUser != null) {
           // if(realUser.getContrasena().equals(user.getContrasena())){
            if(bCryptPasswordEncoder.matches(user.getContrasena(),realUser.getContrasena())){
                if(realUser.getActivo()){
                    Map<String,String> listaCosas = new HashMap<String, String>();
                    listaCosas.put(HEADER_STRING,TOKEN_PREFIX+tokenize(realUser));
                    listaCosas.put("nombre",realUser.getNombre());
                    listaCosas.put("rol",realUser.getRol().toString());

                    /*MultiValueMap<String, String> multivalue = new LinkedMultiValueMap<String, String>();
                    multivalue.add(HEADER_STRING,TOKEN_PREFIX + tokenize(realUser));
                    multivalue.add("nombre",realUser.getNombre());
                    multivalue.add("rol",realUser.getRol().toString());*/
                    return new ResponseEntity(listaCosas,HttpStatus.OK);
                }else{
                    return new ResponseEntity<>("Usuario Inactivo.",HttpStatus.UNAUTHORIZED);
                }
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