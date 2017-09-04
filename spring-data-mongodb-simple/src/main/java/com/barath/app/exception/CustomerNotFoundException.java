package com.barath.app.exception;

public class CustomerNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 2239615383152614055L;


    public CustomerNotFoundException(){
        super();
    }


    public CustomerNotFoundException(String message){
        super(message);
    }


}