package Adapters;

import org.example.Adapters.CurrencyAdapter;
import org.example.Adapters.DistanceAdapter;
import org.example.Enums.Currency;
import org.example.Enums.Distance;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DistanceAdapterTest {
    @Test
    public void kmToMConversion(){
        double mInKm = 1000;
        double kmAmount = 5.8;
        double tolerance = 0.0000000001;

        DistanceAdapter distanceAdapter = new DistanceAdapter();
        double result = distanceAdapter.convert(kmAmount, Distance.KM, Distance.M);
        Assert.assertEquals(result,(kmAmount * mInKm),tolerance);
    }

    @Test
    public void mileToKmConversion(){
        double mileAmount = 5;
        double tolerance = 0.0001;

        DistanceAdapter distanceAdapter = new DistanceAdapter();
        double result = distanceAdapter.convert(mileAmount, Distance.MILE, Distance.KM);
        Assert.assertEquals(result,(mileAmount * 1.60934),tolerance);
    }

    @Test
    public void zeroDistanceConversion(){
        double mmInCm = 10;
        double cmAmount = 0;
        double tolerance = 0.0000000001;

        DistanceAdapter distanceAdapter = new DistanceAdapter();
        double result = distanceAdapter.convert(cmAmount, Distance.KM, Distance.M);
        Assert.assertEquals(result,(cmAmount * mmInCm),tolerance);
    }

    @Test
    public void negativeDistanceConversion(){
        double mmInCm = 10;
        double cmAmount = -10;
        double tolerance = 0.0000000001;

        DistanceAdapter distanceAdapter = new DistanceAdapter();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            distanceAdapter.convert(cmAmount, Distance.KM, Distance.M);
        });
    }
}