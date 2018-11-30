package com.mongodb.mongodb.config;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import com.mongodb.mongodb.model.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

public class JwtConfig {
    private static final String SECRET = "BQSyS2Wbr7sfJ6SMDDVeUo4j1j8j5lYQwx3CNFfUTfuullMwPjfoC5QeD3r7O8kW";
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    private static final Logger log = LoggerFactory.getLogger(JwtConfig.class);

    //Genera token del json (correo y pass)
    public static String tokenize(Usuario usuario) {
        Map<String, Object> json = new HashMap<>();
        json.put("correo", usuario.getCorreo());
        json.put("contrasena",usuario.getContrasena());
        json.put("rol",usuario.getRol());
        json.put("activo",usuario.getActivo());
        String token = new JWTSigner(SECRET).sign(json);
        return token;
    }

    //Verifica si el token es válido o no
    public static Boolean isAuthenticated(String token) {
        if(null == token)
            return false;
        try {
             return (Boolean) new JWTVerifier(SECRET).verify(token.replace(TOKEN_PREFIX,"")).getOrDefault("activo",false);
        } catch (NoSuchAlgorithmException | InvalidKeyException | IOException | SignatureException | JWTVerifyException e) {
            log.error(e.getMessage(),e);
            return false;
        }
    }

    public static Boolean isAuthorized(String token, int role){
        if(!isAuthenticated(token)){
            log.info("error2");
            return false;}
        try {
            Integer rol =(Integer) new JWTVerifier(SECRET).verify(token.replace(TOKEN_PREFIX,"")).getOrDefault("rol",3);
            log.info("rol: {}",rol);
            log.info("role: {}",role);
            return rol == role;
        } catch (NoSuchAlgorithmException | InvalidKeyException | IOException | SignatureException | JWTVerifyException e) {
            log.error(e.getMessage(),e);
            return false;
        }
    }
}
