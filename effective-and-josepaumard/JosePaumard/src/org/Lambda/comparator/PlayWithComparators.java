package org.Lambda.comparator;

import org.Lambda.comparator.model.Person;

import java.util.Comparator;

public class PlayWithComparators {


    public static void main(String[] args){

        Person Ayman = new Person("Ayman", 29);
        Person Chinmay = new Person("Chinmay", 39);
        Person Shrey = new Person("Shrey", 19);
        Person Aish = new Person("Aish", 31);

        Comparator<Person> cmpName = (p1,p2) -> {
            String name1 = p1.getName();
            String name2 = p2.getName();
            return name1.compareTo(name2);//class String implements java.io.Serializable, Comparable<String>, ...
        };
        System.out.println("Ayman GREATER THAN Aish" + (cmpName.compare(Ayman,Shrey) > 0));
    }
}
