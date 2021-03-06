package com.hiklas.mucking.around;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
import java.util.function.Function;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


public class FizzBuzzLuckTest
{
    private FizzBuzzLuck fizzBuzzLuckToTest;


    @Before
    public void setup()
    {
        fizzBuzzLuckToTest = new FizzBuzzLuck();
    }


    @Test
    public void checkForThreeDigitFunctionReturned()
    {
        Object checkForThreeDigit = fizzBuzzLuckToTest.checkForThreeDigit();

        assertThat(checkForThreeDigit, notNullValue());
        assertThat(checkForThreeDigit, instanceOf(Function.class));
    }

    @Test
    public void checkForThreeDigitFunction_returnsEmptyForZero()
    {
        Optional<String> result = fizzBuzzLuckToTest.checkForThreeDigit().apply(0);
        assertThat(result.isPresent(), equalTo(false));
    }

    @Test
    public void checkForThreeDigitFunction_returnsLuckForThree()
    {
        Optional<String> result = fizzBuzzLuckToTest.checkForThreeDigit().apply(3);
        assertThat(result.isPresent(), equalTo(true));
        assertThat(result.get(), equalTo("luck"));
    }

    @Test
    public void processStringOfNumbers_returnsFullStringForTaskTestDataForLuck()
    {
        String result = fizzBuzzLuckToTest.processStringOfNumbers("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20");
        assertThat(result, notNullValue());
        assertThat(result, equalTo("1 2 luck 4 buzz fizz 7 8 fizz buzz 11 fizz luck 14 fizzbuzz 16 17 fizz 19 buzz"));
    }


}