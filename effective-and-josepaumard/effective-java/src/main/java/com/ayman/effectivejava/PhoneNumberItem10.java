package com.ayman.effectivejava;

import com.google.common.base.MoreObjects;

import java.util.Formattable;
import java.util.Formatter;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

// Item 10, 11, 12 covered
public class PhoneNumberItem10 implements Formattable {

    private static final PhoneNumberItem10 COMMON = new PhoneNumberItem10("123", 1234);//Flyweight pattern: Using common variables
    private final String areaCode;
    private final int number;

    // private final int hashCode; // Eager initialization
    private int hashCode;// Lazy initialization

    /* public vs private constructor
    public constructor: Default constructor without static factory method.
	public constructor: Used in case of static factory method. Minimizes instantiatibiliy of constructor, leading to less constructor objects.
	*/

    // private constructor: Used in static factory method
    private PhoneNumberItem10(String areaCode, int number) {
        this.areaCode = areaCode;
        this.number = number;
        // this.hashCode = Objects.hash(this.areaCode, this.number);// Eager initialization
    }

    // YANAGA likes of method name
    public static PhoneNumberItem10 of(String areaCode, int number) {

        checkArgument(number >1000);

        if (areaCode.equals("123") && number==1234){
            return COMMON;
        }
        return new PhoneNumberItem10(areaCode, number);
    }

    @Override
    public boolean equals(Object obj){

        //if (obj == this) return true;// Why is this working. Why all the shenanigans below

        if(obj instanceof PhoneNumberItem10){
            PhoneNumberItem10 objVariables = (PhoneNumberItem10) obj;
            //return this.number==objVariables.number && this.areaCode==objVariables.areaCode;
            return this.number==objVariables.number && Objects.equals(this.areaCode, objVariables.areaCode);
        }

        return false;
    }

    @Override
    public int hashCode(){
        int result = hashCode;
        if (result == 0){
            result = Objects.hash(this.areaCode, this.number);
            return result;
        }
        this.hashCode = result;
        return result;

        // return hashCode; // Eager initialization. Declared in constructor. Better performance.
        // return Objects.hash(this.areaCode, this.number);//performance problems as hash method creates array of values.
    }

    @Override
    public String toString(){
        return MoreObjects.toStringHelper(this)
                .add("areaCode", areaCode)
                .add("number", number)
                .toString();
    }

    public static void main(String[] args){

        System.out.println(PhoneNumberItem10.of("123", 1234));
        System.out.println(String.format("%s",PhoneNumberItem10.of("123", 1234)));
    }


    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision){
        formatter.format("%s-%d", areaCode, number);
    }


}
