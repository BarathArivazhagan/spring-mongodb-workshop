package com.barath.app.exception;

public class CustomerAlreadyExistsException extends RuntimeException{


    private static final long serialVersionUID = 3618723446381468988L;


    public CustomerAlreadyExistsException(){
        super();
    }


    public CustomerAlreadyExistsException(String message){
        super(message);
    }

}