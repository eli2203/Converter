package Adapters;

import org.example.Adapters.CurrencyAdapter;
import org.example.Enums.Currency;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrencyAdapterTest{
    @Test
    public void ilsToUsdConversion(){
        double ilsRate = 0.27;
        double ilsAmount = 40.5;
        double tolerance = 0.0000000001;

        CurrencyAdapter currencyAdapter = new CurrencyAdapter();
        double result = currencyAdapter.convert(ilsAmount, Currency.USD, Currency.ILS);
        Assert.assertEquals(result,(ilsAmount/ilsRate),tolerance);
    }

    @Test
    public void crossConversionEurToGBP(){
        double eurRate = 1.09;
        double gbpRate = 1.27;
        double eurAmount = 10;
        double tolerance = 0.0000000001;

        CurrencyAdapter currencyAdapter = new CurrencyAdapter();
        double result = currencyAdapter.convert(eurAmount, Currency.EUR, Currency.GBP);
        Assert.assertEquals(result,(eurAmount * eurRate/gbpRate),tolerance);
    }

    @Test
    public void zeroAmountConversion(){
        double ilsRate = 0.27;
        double ilsAmount = 0;
        double tolerance = 0.0000000001;

        CurrencyAdapter currencyAdapter = new CurrencyAdapter();
        double result = currencyAdapter.convert(ilsAmount, Currency.USD, Currency.ILS);
        Assert.assertEquals(result,(ilsAmount/ilsRate),tolerance);
    }

    @Test
    public void negativeAmountConversion(){
        double ilsRate = 0.27;
        double ilsAmount = -5;
        double tolerance = 0.0000000001;

        CurrencyAdapter currencyAdapter = new CurrencyAdapter();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            currencyAdapter.convert(ilsAmount, Currency.USD, Currency.ILS);
        });
    }
}