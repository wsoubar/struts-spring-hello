package br.com.wsoubar.hello.action;

import com.opensymphony.xwork2.ActionSupport;

import br.com.wsoubar.hello.service.HelloService;
import br.com.wsoubar.hello.service.HelloWorldService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class HelloAction extends ActionSupport {

    private static final Logger logger = LoggerFactory.getLogger(HelloAction.class);
    private String message;

    @Autowired
    HelloWorldService helloWorldService;

    public String sayHello() {
        logger.info("sayHello(2)");
        // Mensagem vinda do Spring ou default
        //if (message == null) {
            message = "Hello World from Struts 2 + Spring 3! - " + helloWorldService.getHelloMessage();
        //}
        return SUCCESS;
    }

    // Getter e Setter para que o JSP possa acessar
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
