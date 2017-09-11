package com.hiklas.mucking.around;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;


public class FizzBuzzLuckCountTest
{
    public static final String ZERO_STATISTICS_OUTPUT =
            "fizz: 0\nbuzz: 0\nfizzbuzz: 0\nluck: 0\nnumber: 0\n";

    private FizzBuzzLuckCount fizzBuzzLuckCountToTest;


    @Before
    public void setup()
    {
        fizzBuzzLuckCountToTest = new FizzBuzzLuckCount();
    }



    @Test
    public void processStringOfNumbers_returnsFullStringForTaskTestDataForLuck()
    {
        String result = fizzBuzzLuckCountToTest.processStringOfNumbers("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20");
        assertThat(result, notNullValue());
        assertThat(result, equalTo("1 2 luck 4 buzz fizz 7 8 fizz buzz 11 fizz luck 14 fizzbuzz 16 17 fizz 19 buzz"));
    }

    @Test
    public void statisticsOutputNotEmptyAfterProcessing()
    {
        fizzBuzzLuckCountToTest.processStringOfNumbers("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20");
        String result = fizzBuzzLuckCountToTest.outputStatistics();
        assertThat(result, notNullValue());
        assertThat(result.length(), greaterThan(0));
    }

    @Test
    public void statisticsOutputNotEmptyAfterProcessingEmptyString()
    {
        fizzBuzzLuckCountToTest.processStringOfNumbers("");
        String result = fizzBuzzLuckCountToTest.outputStatistics();
        assertThat(result, notNullValue());
        assertThat(result.length(), greaterThan(0));
        assertThat(result, equalTo(ZERO_STATISTICS_OUTPUT));
    }

}