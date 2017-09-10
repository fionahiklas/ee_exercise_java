package com.hiklas.mucking.around;

import org.junit.Before;
import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.instanceOf;

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
}