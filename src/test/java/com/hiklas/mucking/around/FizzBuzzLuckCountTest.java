package com.hiklas.mucking.around;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;


public class FizzBuzzLuckCountTest
{
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


}