package org.example;

import org.example.Adapters.CurrencyAdapter;
import org.example.Adapters.DistanceAdapter;
import org.example.Adapters.TemperatureAdapter;
import org.example.Enums.AdapterTypes;

public class ConvertorExercise<T> {
    private TemperatureAdapter temperatureAdapter;
    private DistanceAdapter distanceAdapter;
    private CurrencyAdapter currencyAdapter;



    public ConvertorExercise() {
        this.temperatureAdapter = new TemperatureAdapter();
        this.distanceAdapter = new DistanceAdapter();
        this.currencyAdapter = new CurrencyAdapter();

    }

    public double convert(AdapterTypes adapterType, double inputValue, Enum<?>[] options) throws Exception {
        double result;

       switch(adapterType){
           case TEMPERATURE:
               result = this.temperatureAdapter.convert(inputValue, options[0], options[1]);
               break;
           case DISTANCE:
               result = this.distanceAdapter.convert(inputValue, options[0], options[1]);
               break;
           case CURRENCY:
               result = this.currencyAdapter.convert(inputValue, options[0], options[1]);
               break;
           default:
               throw new Exception("Converter type " + adapterType + " is invalid!");
       }
       return result;
    }
}

