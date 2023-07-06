package org.example.Adapters;

import java.io.File;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Main;
import org.example.Mocks.CurrencyRate;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;


public class CurrencyAdapter {
    public double convert(double value, Enum<?> inputUnit, Enum<?> outputUnit){
        if (value < 0) {
            throw new IllegalArgumentException("The amount for conversion must be positive !!!");
        }

        try {
            //In this case I'm using static data from currencies.json, but I could receive dynamic Data via API call
            //TODO: change File path to relative path and clear comments below
            double inputRate = -1;
            double outputRate = -1;
            double result = -1;
            boolean isAllRatesFound = false;

            ObjectMapper objectMapper = new ObjectMapper();
            CurrencyRate[] currencyRates = objectMapper.readValue(new File("./mocks/currencies.json"), CurrencyRate[].class);
            for (CurrencyRate currencyRate : currencyRates) {
                if (currencyRate.getCurrency().equals(inputUnit.toString())) {
                    inputRate = currencyRate.getValue();
                } else if ((currencyRate.getCurrency().equals(outputUnit.toString()))) {
                    outputRate = currencyRate.getValue();
                }
                if ((inputRate != -1) && (outputRate != -1)) {
                    isAllRatesFound = true;
                    break;
                }
            }

            if (isAllRatesFound) {
                result = value * inputRate / outputRate;
                System.out.println(value +" " + inputUnit.toString() + " equals to " + result + " " + outputUnit.toString());
            } else if (inputRate == -1){
                System.out.println("The rate of " + inputUnit.toString() + " (input currency is not found)");
            } else if (outputRate == -1){
                System.out.println("The rate of " + outputUnit.toString() + " (output currency is not found)");
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
