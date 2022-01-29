package com.systemorderproducer.insfrastructure.http;

public class ObjectNotfoundException extends Exception{
    public ObjectNotfoundException(String message) {
        super(String.format("uid: " + message + " Não encontrado"));
    }
}
