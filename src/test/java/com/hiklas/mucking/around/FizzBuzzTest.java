package com.hiklas.mucking.around;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

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

    @Test
    public void divideByThreeFunction_returnsNonEmptyFor15()
    {
        Optional<String> result = fizzBuzzToTest.divideByThreeFunction().apply(15);
        assertThat(result.isPresent(), equalTo(true));
        assertThat(result.get(), equalTo(FizzBuzz.FIZZ));
    }

    @Test
    public void divideByFiveFunction_returnsNonEmptyFor15()
    {
        Optional<String> result = fizzBuzzToTest.divideByFiveFunction().apply(15);
        assertThat(result.isPresent(), equalTo(true));
        assertThat(result.get(), equalTo(FizzBuzz.BUZZ));
    }

    @Test
    public void returnNumberAsStringFunctionReturned()
    {
        Object returnNumberAsString = fizzBuzzToTest.returnNumberAsString();

        assertThat(returnNumberAsString, notNullValue());
        assertThat(returnNumberAsString, instanceOf(Function.class));
    }

    @Test
    public void returnNumberAsStringFunction_returnsNonEmptyForZero()
    {
        Optional<String> result = fizzBuzzToTest.returnNumberAsString().apply(0);
        assertThat(result.isPresent(), equalTo(true));
        assertThat(result.get(), equalTo("0"));
    }

    @Test
    public void stopIfAlreadyHaveResultFunctionReturned()
    {
        Object returnNumberAsString = fizzBuzzToTest.stopIfAlreadyHaveResult();

        assertThat(returnNumberAsString, notNullValue());
        assertThat(returnNumberAsString, instanceOf(Predicate.class));
    }

    @Test
    public void stopIfAlreadyHaveResult_returnFalseOnEmptyString()
    {
        boolean result = fizzBuzzToTest.stopIfAlreadyHaveResult().test("");
        assertThat(result, equalTo(false));
    }

    @Test
    public void stopIfAlreadyHaveResult_returnTrueOnOneCharacter()
    {
        boolean result = fizzBuzzToTest.stopIfAlreadyHaveResult().test("A");
        assertThat(result, equalTo(true));
    }

    @Test
    public void stopIfAlreadyHaveResult_returnTrueOnNumber()
    {
        boolean result = fizzBuzzToTest.stopIfAlreadyHaveResult().test("1");
        assertThat(result, equalTo(true));
    }

    @Test
    public void stopIfAlreadyHaveResult_returnTrueOnFizzBuzz()
    {
        boolean result = fizzBuzzToTest.stopIfAlreadyHaveResult().test("fizzbuzz");
        assertThat(result, equalTo(true));
    }

}