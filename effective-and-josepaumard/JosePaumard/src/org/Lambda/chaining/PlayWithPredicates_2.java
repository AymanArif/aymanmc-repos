package org.Lambda.chaining;

import org.Lambda.chaining.function.Predicate_2;

// Default Methods to Combine Lamdbas
public class PlayWithPredicates_2 {



    public static void main(String[] args){


        Predicate_2<String> p1 = s -> s != null;
        Predicate_2<String> p2 = s -> !s.isEmpty();
        System.out.println("----------p1------------");
        System.out.println("Test for null: " + p1.test(null));
        System.out.println("Test for empty: " + p1.test(""));
        System.out.println("Test for non-empty: " + p1.test("Hello"));
        System.out.println("----------p2------------");
        System.out.println("Test for null: ThrowsException[p2.test(null)]" );
        System.out.println("Test for empty: " + p2.test(""));
        System.out.println("Test for non-empty: " + p2.test("Hello"));

        // NOT or NEGATE
        Predicate_2<String> notP2 = p2.negate();

        //Predicate_2<String> p3 = p1.and(p2);//P3=P1&&P2
        Predicate_2<String> p3 = p1.and(notP2);  //P3=P1&&!P2
        System.out.println("----------p3------------");
        System.out.println("Test for null: " + p3.test(null));
        System.out.println("Test for empty: " + p3.test(""));
        System.out.println("Test for non-empty: " + p3.test("Hello"));



    }
}
