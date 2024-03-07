package com.konstil.Ponude.exception;

import java.io.*;

public class ServerException extends RuntimeException{
    public ServerException(String message) {
        super(message);
        System.out.println("ServerException: " + message);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true));
            writer.write(message);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static Exception create(String greskaPoruka) {
        return new ServerException(greskaPoruka);
    }
}
