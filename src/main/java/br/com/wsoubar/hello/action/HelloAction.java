package br.com.wsoubar.hello.action;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import br.com.wsoubar.hello.service.HelloWorldService;

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


    public String testaDB() {
        try {
            // Faz o lookup do DataSource configurado no Tomcat
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MySampleDB");

            // Tenta obter uma conexão
            try (Connection con = ds.getConnection()) {
                message = "✅ Conexão OK: " + con.getMetaData().getURL();
                logger.info(message);
            }

        } catch (Exception e) {
            message = "❌ Erro de conexão: " + e.getMessage();
            logger.error(message, e);
        }        
        return SUCCESS;
    }

    public String sayBye() {
        logger.info("sayBye()");
        return "sayBye...";
    }

    // Getter e Setter para que o JSP possa acessar
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
