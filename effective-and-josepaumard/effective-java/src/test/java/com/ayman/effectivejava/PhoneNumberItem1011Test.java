package com.ayman.effectivejava;

import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneNumberItem1011Test {

    @Test
    public void testReflexiveForEqualsMethod() {
        PhoneNumberItem10 p1 = PhoneNumberItem10.of("123", 1234);
        assertTrue("Reflexive for equals method", p1.equals(p1));

    }

    @Test
    public void testTransitiveForEqualsMethod(){
        PhoneNumberItem10 p1 = PhoneNumberItem10.of("123", 1234);
        PhoneNumberItem10 p2 = PhoneNumberItem10.of("123", 1234);
        PhoneNumberItem10 p3 = PhoneNumberItem10.of("123", 1234);
        assertTrue("Transitive for equals method (p1=p2)", p1.equals(p2));
        assertTrue("Transitive for equals  method (p2=p3)", p2.equals(p3));
        assertTrue("Transitive for equals method (p1=p3)", p1.equals(p3));

    }
    @Test
    public void testSymmetricalForEqualsMethod(){
        PhoneNumberItem10 p1 = PhoneNumberItem10.of("123", 1234);
        PhoneNumberItem10 p2 = PhoneNumberItem10.of("123", 1234);
        assertTrue("Symmetrical for equals method (p1=p2)", p1.equals(p2));
        assertTrue("Symmetrical for equals method (p2=p1)", p2.equals(p1));
    }

    @Test
    public void NotNullityForEqualsMethod(){
        PhoneNumberItem10 p1 = PhoneNumberItem10.of("123", 1234);
        assertFalse("Not-nullity (p1!=null)", p1.equals(null));
    }

    @Test
    public void testConsistentForEqualsMethod(){
        PhoneNumberItem10 p1 = PhoneNumberItem10.of("123", 1234);
        PhoneNumberItem10 p2 = PhoneNumberItem10.of("123", 1234);
        assertTrue("Consistent testing (p1=p2)", p1.equals(p2));
        assertTrue("Consistent testing (p1=p2)", p1.equals(p2));
        assertTrue("Consistent testing (p1=p2)", p1.equals(p2));

    }


}