package Adapters;

import org.example.Adapters.CurrencyAdapter;
import org.example.Adapters.DistanceAdapter;
import org.example.Adapters.TemperatureAdapter;
import org.example.Enums.Currency;
import org.example.Enums.Distance;
import org.example.Enums.Temperature;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TemperatureAdapterTest {
    @Test
    public void celsiusToFahrenheitConversion(){
        double celsiusDegrees = 36.6;
        double tolerance = 0.0000000001;

        TemperatureAdapter temperatureAdapter = new TemperatureAdapter();
        double result = temperatureAdapter.convert(celsiusDegrees, Temperature.CELSIUS, Temperature.FAHRENHEIT);
        Assert.assertEquals(result,(celsiusDegrees * 9/5 + 32),tolerance);
    }

    @Test
    public void fahrenheitToCelsiusConversion(){
        double fahrenheitDegrees = 451;
        double tolerance = 0.0000000001;

        TemperatureAdapter temperatureAdapter = new TemperatureAdapter();
        double result = temperatureAdapter.convert(fahrenheitDegrees, Temperature.FAHRENHEIT, Temperature.CELSIUS);
        Assert.assertEquals(result,((fahrenheitDegrees -32 ) * 5/9),tolerance);
    }

    @Test
    public void negativeCelsiusConversion(){
        double celsiusDegrees = -20;
        double tolerance = 0.0000000001;

        TemperatureAdapter temperatureAdapter = new TemperatureAdapter();
        double result = temperatureAdapter.convert(celsiusDegrees, Temperature.CELSIUS, Temperature.FAHRENHEIT);
        Assert.assertEquals(result,(celsiusDegrees * 9/5 + 32),tolerance);
    }
}