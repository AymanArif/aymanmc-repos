
package org.Lambda.chaining.function;


import java.util.Objects;

//Setup Generic Types of a Chained Function
@FunctionalInterface
public interface Function_3<T, R> {

    R apply(T t);

    //Implementing the Chaining of Functions with Default Methods
    //Function_3<Meteo_3, Double> readF = readCelsius<Meteo_3, Integer>.andThen(celsiusToF<Integer, Double>);
    default <V> Function_3<T, V> andThen(Function_3<R,V> other){ //T: Meteo; R:Integer; V: Double

       return (T t) -> {
            R r = this.apply(t);
            return other.apply(r);
        };
    }

    //Implementing the Chaining of Functions with Default Methods
    //Function_3<Meteo_3, Double> readF = celsiusToF<Integer, Double>.composing(readCelsius<Meteo_3, Integer>);
    default <V> Function_3<V, R> composing(Function_3<V,T> other){ //T: Meteo; R:Integer; V: Double

        return (V v) -> {
            T t = other.apply(v);
            return this.apply(t);
        };
    }

    static <T> Function_3<T, T> identity(){
        return t -> t;
    }



}
