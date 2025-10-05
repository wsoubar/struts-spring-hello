package br.com.wsoubar.hello.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {

    private String message;

    @Override
    public String execute() {
        // Mensagem vinda do Spring ou default
        if (message == null) {
            message = "Hello World from Struts 2 + Spring 3!";
        }
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
