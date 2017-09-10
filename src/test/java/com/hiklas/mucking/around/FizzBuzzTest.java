package com.hiklas.mucking.around;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
import java.util.function.Function;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.equalTo;


public class FizzBuzzTest
{
    private FizzBuzz fizzBuzzToTest;


    @Before
    public void setup()
    {
        fizzBuzzToTest = new FizzBuzz();
    }

    @Test
    public void divideByThreeDetectFunctionReturned()
    {
        Object divideByThree = fizzBuzzToTest.divideByThreeFunction();

        assertThat(divideByThree, notNullValue());
        assertThat(divideByThree, instanceOf(Function.class));
    }

    @Test
    public void divideByFiveDetectFunctionReturned()
    {
        Object divideByFive = fizzBuzzToTest.divideByFiveFunction();

        assertThat(divideByFive, notNullValue());
        assertThat(divideByFive, instanceOf(Function.class));
    }

    @Test
    public void divideByThreeFunction_returnsEmptyForZero()
    {
        Optional<String> result = fizzBuzzToTest.divideByThreeFunction().apply(0);
        assertThat(result.isPresent(), equalTo(false));
    }

    @Test
    public void divideByFiveFunction_returnsEmptyForZero()
    {
        Optional<String> result = fizzBuzzToTest.divideByFiveFunction().apply(0);
        assertThat(result.isPresent(), equalTo(false));
    }

    @Test
    public void divideByThreeFunction_returnsEmptyForOne()
    {
        Optional<String> result = fizzBuzzToTest.divideByThreeFunction().apply(1);
        assertThat(result.isPresent(), equalTo(false));
    }

    @Test
    public void divideByFiveFunction_returnsEmptyForOne()
    {
        Optional<String> result = fizzBuzzToTest.divideByFiveFunction().apply(1);
        assertThat(result.isPresent(), equalTo(false));
    }

    @Test
    public void divideByThreeFunction_returnsNonEmptyForThree()
    {
        Optional<String> result = fizzBuzzToTest.divideByThreeFunction().apply(3);
        assertThat(result.isPresent(), equalTo(true));
        assertThat(result.get(), equalTo(FizzBuzz.FIZZ));
    }

    @Test
    public void divideByFiveFunction_returnsNonEmptyForFive()
    {
        Optional<String> result = fizzBuzzToTest.divideByFiveFunction().apply(5);
        assertThat(result.isPresent(), equalTo(true));
        assertThat(result.get(), equalTo(FizzBuzz.BUZZ));
    }


}