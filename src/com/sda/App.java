package com.sda;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;

public class App {
    private static class Message implements Serializable {
        private final String value;
        private Message(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    public static void main(String[] args) throws Exception {
        final App app = new App();
        final Message message = new App.Message("Hello");
        try (FileOutputStream fos = new FileOutputStream("test");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(message);
        }
    }
}