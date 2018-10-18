package com.mongodb.mongodb.rest;

import com.mongodb.mongodb.model.Usuario;
import com.mongodb.mongodb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Arrays;


@Component
public class MongoUserDetailsService implements UserDetailsService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Usuario usuario = usuarioRepository.findByCorreo(username);

        if(usuario == null){
            throw new UsernameNotFoundException("Usuario no Encontrado");
        }
        //Implementar el tema de los roles: Por el momento se tiene con un sólo rol.
        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));
        return new User(usuario.getCorreo(), usuario.getContrasena(), authorities);
    }
}
