package br.com.wsoubar.hello.service;

import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@Service
@WebService
public class HelloServiceImpl {

    @WebMethod
    public String hello() {
        return "Olá mundo";
    }

}
