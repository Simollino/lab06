package it.unibo.exceptions.fakenetwork;

import java.io.IOException;

public class NetworkException extends IOException{

    public NetworkException() {
        new NetworkException("Network error: no response");
    }

    public NetworkException(String message) {
        new NetworkException("Network error while sending message: " + message);
    }
    
}
