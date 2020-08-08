package org.Lambda.chaining.function;


import java.util.Objects;

// Default Methods to Combine Lamdbas
@FunctionalInterface
public interface Predicate_2<T> {

    boolean test(T t);

    default Predicate_2<T> and(Predicate_2<T> other){
        Objects.requireNonNull(other);
        return (T t) -> this.test(t) && other.test(t);
    }

    default Predicate_2<T> negate(){
        return (T t) -> !test(t);
    }
}
