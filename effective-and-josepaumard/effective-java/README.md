
 Ayman Book Link https://github.com/AymanArif/Notes/tree/master/Java/Effective-Java
[YT Link](https://www.youtube.com/watch?v=ANZXvXVa1Lg)

# Timeline
|Timestamp|Topics covered|
|---|---|
|7:34|[Item 1] Factory methods, guava check argument, Flyweight pattern|
|16:50|[Item 10,11]`@Override` `equals`, then `hashCode`| 
|26:35|[Item 12] `toString` and `Formattable`|
|30:31|[Item 13]Comparable, guava CompariosnChain, Comparator|
|34:18|Immutable list, sort|
|37:25|builder|
|47:31|Enum, AttributeConverter|
|1:04:00|try-with-resources|
|1:07:35|Functional Interface|
|1:24:30|Threadsafe hashcode, code autogeneration|
|1:29:28|Functional interface with Streams|
|1:42:58|Method Reference|
|1:48:02|Identity function|
|1:49:57|Optional|
|1:57:03|var|
|2:04:10|Immutability and object creation|
|2:17:30|Q&A|
|2:23:38|More on method references|

# [Item 1] Factory methods, guava check argument, Flyweight pattern


## guava
Guava has bad versioning.

## Flyweight pattern

# [Item 10,11] `@Override` 1.`equals`, 2. then `hashCode`
## `equals`

## `hashCode`
**Always implement `hashCode` after `equals` method**
 
`return Objects.hash(this.areaCode, this.number);`

But performance problems as hash method creates array of values.

Performance up:
Use hashcode in constructor. Look code for understanding.

# [Item 12] `toString` and `Formattable`
## `toString`
**Always implement `toString` after `hashCode` method**
Used for debugging purpose.
Implement according to your needs.

## `Formattable`
Not part of Effective Java. Used in business context. It is a java library.



# Comparable, guava CompariosnChain, Comparator
## Comparable
`Comparable` is class

## Comparator
`Comaprator` is functional interface

    public static Comparator<ClassName> COMPARATOR = Comparator.comparingInt((PhoneNumberItem13 p) -> p.number)
                                            .thenComparing(p -> p.areaCode);
    @Override
    public int compareTo(ClassName obj) {
        return COMPARATOR.compare(this, obj);
    }


    
    
`

## guava ComparisonChain
Don't use dependencies. JDK already provides ComparisonChain


# Immutable list sort

# builder 
ROT: If less than or equal to 3 parameters, use `static factory`
If more than 3, use `builder`

Allows for optional parameters too.
Final == Immutable and mandatory.
Non-final == Mutable and optional.


# Enum, AttributeConverter
# try-with-resources
# Functional Interface
# Threadsafe hashcode, code autogeneration
# Functional interface with Streams 
# Method Reference
# Identity function
# Optional
# var 
# Immutability and object creation
# Q&A
# More on method references
