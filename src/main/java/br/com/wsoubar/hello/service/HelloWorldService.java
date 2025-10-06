package br.com.wsoubar.hello.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    public String getHelloMessage() {
        return "@@ serviço @@";
    }
}
