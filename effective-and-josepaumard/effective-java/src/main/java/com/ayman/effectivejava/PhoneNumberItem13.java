package com.ayman.effectivejava;

import com.google.common.base.MoreObjects;

import java.util.*;

import static com.google.common.base.Preconditions.checkArgument;

// Item 13  and immutable, sort (JDK) covered
public class PhoneNumberItem13 implements Formattable, Comparable<PhoneNumberItem13> {

    private static final PhoneNumberItem13 COMMON = new PhoneNumberItem13("123", 1234);
    private final String areaCode;
    private final int number;

    private int hashCode;// Lazy initialization

    /* public vs private constructor
    public constructor: Default constructor without static factory method.
	public constructor: Used in case of static factory method. Minimizes instantiatibiliy of constructor, leading to less constructor objects.
	*/

    // private constructor: Used in static factory method
    private PhoneNumberItem13(String areaCode, int number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    // YANAGA likes of method name
    public static PhoneNumberItem13 of(String areaCode, int number) {

        checkArgument(number >100);

        if (areaCode.equals("123") && number==1234){
            return COMMON;
        }
        return new PhoneNumberItem13(areaCode, number);
    }

    @Override
    public boolean equals(Object obj){

        if(obj instanceof PhoneNumberItem10){
            PhoneNumberItem13 objVariables = (PhoneNumberItem13) obj;
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
  }

    @Override
    public String toString(){
        return MoreObjects.toStringHelper(this)
                .add("areaCode", areaCode)
                .add("number", number)
                .toString();
    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision){
        formatter.format("%s-%d", areaCode, number);
    }

    public static Comparator COMPARATOR_NUM_TO_AREACODE = Comparator.comparingInt((PhoneNumberItem13 p) -> p.number)
                                                      .thenComparing(p -> p.areaCode);
    @Override
    public int compareTo(PhoneNumberItem13 obj) {
        return COMPARATOR_NUM_TO_AREACODE.compare(this, obj);

    }

    public static void main(String[] args){

        PhoneNumberItem13 p1 = PhoneNumberItem13.of("123",1234);
        PhoneNumberItem13 p2 = PhoneNumberItem13.of("567",5678);
        PhoneNumberItem13 p3 = PhoneNumberItem13.of("12345",9123);

        ArrayList<PhoneNumberItem13> phoneNumberList = new ArrayList<>();
        phoneNumberList.add(p1);
        phoneNumberList.add(p2);
        phoneNumberList.add(p3);
        Collections.sort(phoneNumberList);
        phoneNumberList.sort(COMPARATOR_NUM_TO_AREACODE);
        System.out.println(phoneNumberList);


    }
}
