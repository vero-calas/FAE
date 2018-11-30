package com.mongodb.mongodb.rest;

import com.mongodb.mongodb.config.JwtConfig;
import static com.mongodb.mongodb.config.JwtConfig.HEADER_STRING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.WebRequest;

@Controller
public abstract class AbstractoService {
    @Autowired
    protected WebRequest webRequest;

    protected boolean isAuthenticated(){
        return JwtConfig.isAuthenticated(webRequest.getHeader(HEADER_STRING));
    }

    protected boolean isAuthorized(int rol){
        return JwtConfig.isAuthorized(webRequest.getHeader(HEADER_STRING), rol);
    }

}
