
List of Java 8 Features:

1. forEach() method in Iterable interface

Syntax:
`myList.forEach(new Consumer<? super <type-of-myList>> action)`

Implementation:
    
    myList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                
            }
    });


2. default and static methods in Interfaces
3. Functional Interfaces and Lambda Expressions
4. Java Stream API for Bulk Data Operations on Collections
5. Java Time API
6. Collection API improvements
7. Concurrency API improvements
8. Java IO improvements
9,  Miscellaneous Core API improvements