package org.Lambda.chaining;

import org.Lambda.chaining.function.Function_3;

//Static Methods on Functional Interfaces to Create Lambdas
public class PlayWithIdentity_4 {

    public static void main(String[] args) {

        Function_3<String,String> identity = Function_3.identity();
    }
}
