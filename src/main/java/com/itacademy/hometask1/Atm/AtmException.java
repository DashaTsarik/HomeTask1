package com.itacademy.hometask1.Atm;

public class AtmException extends Exception{

    private static final long SerialVersionUID = 1L;

    public AtmException(){}

    public AtmException(String message){
        super(message);
    }

    public AtmException(Exception e){
        super(e);
    }

    public AtmException(String message, Exception e){
        super(message,e);
    }
}
