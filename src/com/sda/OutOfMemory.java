package com.sda;

public class OutOfMemory {
    public static void main(String[] args) {
        byte[] xs = new byte[40 * 1024 * 1024];
        System.out.println(xs.length);
    }
}
