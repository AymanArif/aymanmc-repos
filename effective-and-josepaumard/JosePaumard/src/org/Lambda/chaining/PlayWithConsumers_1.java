package org.Lambda.chaining;

import org.Lambda.chaining.function.Consumer_1;

// Default Methods to Chain Consumers as Lambda Expressions
public class PlayWithConsumers_1 {

    public static void main(String[] args){

        Consumer_1<String> c1 = s ->  System.out.println("c1 = " + s );
        Consumer_1<String> c2 = s ->  System.out.println("c2 = " + s );


        Consumer_1<String> c3 = s -> {
          c1.accept(s);
          c2.accept(s);
        };
        c3.accept("Hello from c3");

        Consumer_1<String> c3WithDefaultInterfaceMethodBody = c1.andThen(c2);
        // Consumer<String> c3WithDefaultInterfaceMethodBody = c1.andThen(null); // Use `requireNotNull` @ Consumer Interface to validate Null Exception => Fail fast
        c3WithDefaultInterfaceMethodBody.accept("HelloWithDefaultInterfaceMethodBodyandThen from c3");// andThen method



    }
}
