package com.sda;

public class Main {

    private static void allocateMemoryOnStack(int x){
        System.out.println(x);
        byte[] xs = new byte[1024];
        allocateMemoryOnStack(x + 1);
    }

    public static void main(String[] args) {
        allocateMemoryOnStack(1);
    }
}
