package com.example.basicapp;

import java.util.*;

class HelloWorld {
    static native ArrayList<String> special(ArrayList<Integer> input1, int input2);
    static String path;

    static {

        path = System.getProperty("java.library.path");
        try{
            System.loadLibrary("app");
        }catch (UnsatisfiedLinkError e){
            System.out.println("libpath:" + path);
            throw e;
        }
    }

}