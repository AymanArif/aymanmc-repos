// Default Methods to Chain Consumers as Lambda Expressions
package org.Lambda.chaining.function;

// @FunctionalInterface: Interface with one(SHOULD HAVE) method. Used for Annotations declaration

import java.util.Objects;

@FunctionalInterface
public interface Consumer_1<T> {

    void accept(T t);

    //constructor
    // Default methods are those methods which have some default implementation and helps in evolving the interfaces without breaking the existing code.
    default Consumer_1<T> andThen(Consumer_1<T> other){

        Objects.requireNonNull(other); //requireNonNull: Checks that the specified object reference is not null. This method is designed primarily for doing parameter validation in methods and constructors
        return (T t) -> {
          this.accept(t);
          other.accept(t);
        };
    }
}
