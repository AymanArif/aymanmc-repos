package com.ayman.effectivejava;

import static com.google.common.base.Preconditions.checkArgument;
public class PhoneNumberItem1 {

    private static final PhoneNumberItem1 COMMON = new PhoneNumberItem1(123, 1234);//Flyweight pattern: Using common variables
    private final int areaCode;
    private final int number;
    /* public vs private constructor
    public constructor: Default constructor without static factory method.
	public constructor: Used in case of static factory method. Minimizes instantiatibiliy of constructor, leading to less constructor objects.
	*/

    // private constructor: Used in static factory method
    private PhoneNumberItem1(int areaCode, int number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    // YANAGA likes of method name
    public static PhoneNumberItem1 of(int areaCode, int number) {
        checkArgument(areaCode >100);
        checkArgument(number >1000);

        if (areaCode == 123 && number==1234){
            return COMMON;
        }
        return new PhoneNumberItem1(areaCode, number);
    }


    public static void main(String[] args){
        PhoneNumberItem1 common1 = PhoneNumberItem1.of(123, 1234);// Flyweight pattern
        PhoneNumberItem1 common2 = PhoneNumberItem1.of(123, 1234);// Flyweight pattern
        System.out.println(common1==common2);// Flyweight pattern
    }
}
