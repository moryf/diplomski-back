package com.konstil.Ponude.exception;

public class ServerException extends RuntimeException{
    public ServerException(String message) {
        super(message);
    }

    public static Exception create(String greskaPrilikomCuvanjaPonude) {
        return new ServerException(greskaPrilikomCuvanjaPonude);
    }
}
