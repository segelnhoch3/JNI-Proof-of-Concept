package com.example.basicapp;

import java.util.ArrayList;

public class Testing {

    public static void hello(){
//        System.out.println(HelloWorld.path);
        ArrayList<Integer> in = new ArrayList<>();
        in.add(1);
        in.add(2);
        in.add(3);
        ArrayList<String> output = HelloWorld.special(in, 4);
        System.out.println(output);
    }
}
