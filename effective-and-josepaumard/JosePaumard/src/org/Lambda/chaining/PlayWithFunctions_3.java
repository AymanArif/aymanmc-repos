package org.Lambda.chaining;

import org.Lambda.chaining.function.Function_3;
import org.Lambda.chaining.model.Meteo_3;
//Setup Generic Types of a Chained Function
public class PlayWithFunctions_3 {

    public static void main(String[] args) {

        Meteo_3 meteo = new Meteo_3(20);

        Function_3<Meteo_3, Integer> readCelsius = m -> m.getTemperature();
        Function_3<Integer, Double> celsiusToF = t -> t*9d/5d +32d;


        Function_3<Meteo_3, Double> readFChaining = readCelsius.andThen(celsiusToF);
        Function_3<Meteo_3, Double> readFComposing = celsiusToF.composing(readCelsius);

        System.out.println("Meteo in F (Chaining): " + readFChaining.apply(meteo));
        System.out.println("Meteo in F (Composing): " + readFComposing.apply(meteo));



    }
}
