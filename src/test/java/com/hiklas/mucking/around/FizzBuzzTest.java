package com.hiklas.mucking.around;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        boolean result = fizzBuzzToTest.stopIfAlreadyHaveResult().test(new StringBuffer(""));
        assertThat(result, equalTo(false));
    }

    @Test
    public void stopIfAlreadyHaveResult_returnTrueOnOneCharacter()
    {
        boolean result = fizzBuzzToTest.stopIfAlreadyHaveResult().test(new StringBuffer("A"));
        assertThat(result, equalTo(true));
    }

    @Test
    public void stopIfAlreadyHaveResult_returnTrueOnNumber()
    {
        boolean result = fizzBuzzToTest.stopIfAlreadyHaveResult().test(new StringBuffer("1"));
        assertThat(result, equalTo(true));
    }

    @Test
    public void stopIfAlreadyHaveResult_returnTrueOnFizzBuzz()
    {
        boolean result = fizzBuzzToTest.stopIfAlreadyHaveResult().test(new StringBuffer("fizzbuzz"));
        assertThat(result, equalTo(true));
    }

    @Test
    public void processOneNumber_emptySteps()
    {
        List<Object> steps = createSteps();
        String result = fizzBuzzToTest.processOneNumberWithSteps(1, steps);

        assertThat(result, equalTo(""));
    }

    @Test
    public void processOneNumber_singleStepDefault()
    {
        List<Object> steps = createSteps(fizzBuzzToTest.returnNumberAsString());
        String result = fizzBuzzToTest.processOneNumberWithSteps(1, steps);

        assertThat(result, equalTo("1"));
    }

    @Test
    public void processOneNumber_singleStepFizz()
    {
        List<Object> steps = createSteps(fizzBuzzToTest.divideByThreeFunction());
        String result = fizzBuzzToTest.processOneNumberWithSteps(3, steps);

        assertThat(result, equalTo("fizz"));
    }

    @Test
    public void processOneNumber_singleStepBuzz()
    {
        List<Object> steps = createSteps(fizzBuzzToTest.divideByFiveFunction());
        String result = fizzBuzzToTest.processOneNumberWithSteps(5, steps);

        assertThat(result, equalTo("buzz"));
    }

    @Test
    public void processOneNumber_singleStepNoBuzz()
    {
        List<Object> steps = createSteps(fizzBuzzToTest.divideByFiveFunction());
        String result = fizzBuzzToTest.processOneNumberWithSteps(3, steps);

        assertThat(result, equalTo(""));
    }

    @Test
    public void processOneNumber_twoStepNoFizzBuzz()
    {
        List<Object> steps = createSteps(
                fizzBuzzToTest.divideByThreeFunction(),
                fizzBuzzToTest.divideByFiveFunction()
        );

        String result = fizzBuzzToTest.processOneNumberWithSteps(1, steps);

        assertThat(result, equalTo(""));
    }

    @Test
    public void processOneNumber_twoStepFizzBuzz()
    {
        List<Object> steps = createSteps(
                fizzBuzzToTest.divideByThreeFunction(),
                fizzBuzzToTest.divideByFiveFunction()
        );

        String result = fizzBuzzToTest.processOneNumberWithSteps(15, steps);

        assertThat(result, equalTo("fizzbuzz"));
    }

    @Test
    public void processOneNumber_twoStepBuzzFizz()
    {
        List<Object> steps = createSteps(
                fizzBuzzToTest.divideByFiveFunction(),
                fizzBuzzToTest.divideByThreeFunction()

        );

        String result = fizzBuzzToTest.processOneNumberWithSteps(15, steps);

        assertThat(result, equalTo("buzzfizz"));
    }

    @Test
    public void processOneNumber_threeStepsBuzzNoFizz()
    {
        List<Object> steps = createSteps(
                fizzBuzzToTest.divideByFiveFunction(),
                fizzBuzzToTest.stopIfAlreadyHaveResult(),
                fizzBuzzToTest.divideByThreeFunction()

        );

        String result = fizzBuzzToTest.processOneNumberWithSteps(15, steps);

        assertThat(result, equalTo("buzz"));
    }

    @Test
    public void processOneNumber_fourStepsJustNumber()
    {
        List<Object> steps = createSteps(
                fizzBuzzToTest.divideByFiveFunction(),
                fizzBuzzToTest.divideByThreeFunction(),
                fizzBuzzToTest.stopIfAlreadyHaveResult(),
                fizzBuzzToTest.returnNumberAsString()
        );

        String result = fizzBuzzToTest.processOneNumberWithSteps(7, steps);

        assertThat(result, equalTo("7"));
    }

    @Test
    public void processOneNumber_fourStepsFizzBuzz()
    {
        List<Object> steps = createSteps(
                fizzBuzzToTest.divideByThreeFunction(),
                fizzBuzzToTest.divideByFiveFunction(),
                fizzBuzzToTest.stopIfAlreadyHaveResult(),
                fizzBuzzToTest.returnNumberAsString()
        );

        String result = fizzBuzzToTest.processOneNumberWithSteps(30, steps);

        assertThat(result, equalTo("fizzbuzz"));
    }

    @Test
    public void processOneNumber_fourStepsJustFizz()
    {
        List<Object> steps = createSteps(
                fizzBuzzToTest.divideByThreeFunction(),
                fizzBuzzToTest.divideByFiveFunction(),
                fizzBuzzToTest.stopIfAlreadyHaveResult(),
                fizzBuzzToTest.returnNumberAsString()
        );

        String result = fizzBuzzToTest.processOneNumberWithSteps(27, steps);

        assertThat(result, equalTo("fizz"));
    }

    @Test
    public void processOneNumber_fourStepsJustBuzz()
    {
        List<Object> steps = createSteps(
                fizzBuzzToTest.divideByThreeFunction(),
                fizzBuzzToTest.divideByFiveFunction(),
                fizzBuzzToTest.stopIfAlreadyHaveResult(),
                fizzBuzzToTest.returnNumberAsString()
        );

        String result = fizzBuzzToTest.processOneNumberWithSteps(50, steps);

        assertThat(result, equalTo("buzz"));
    }

    @Test
    public void processStringOfNumbers_returnsEmptyStringForEmptyInput()
    {
        String result = fizzBuzzToTest.processStringOfNumbers("");
        assertThat(result, notNullValue());
    }

    @Test
    public void processStringOfNumbers_returnsZeroForZeroInput()
    {
        String result = fizzBuzzToTest.processStringOfNumbers("0");
        assertThat(result, notNullValue());
        assertThat(result, equalTo("0"));
    }

    @Test
    public void processStringOfNumbers_returnsFizzForThreeInput()
    {
        String result = fizzBuzzToTest.processStringOfNumbers("3");
        assertThat(result, notNullValue());
        assertThat(result, equalTo("fizz"));
    }

    @Test
    public void processStringOfNumbers_returnsBuzzForFiveInput()
    {
        String result = fizzBuzzToTest.processStringOfNumbers("5");
        assertThat(result, notNullValue());
        assertThat(result, equalTo("buzz"));
    }

    @Test
    public void processStringOfNumbers_returnsFizzBuzzForFifteenInput()
    {
        String result = fizzBuzzToTest.processStringOfNumbers("15");
        assertThat(result, notNullValue());
        assertThat(result, equalTo("fizzbuzz"));
    }

    /**
     * Utility method to create a list of steps
     *
     * @param steps
     * @return
     */
    private List<Object> createSteps(Object... steps)
    {
        List<Object> result = new ArrayList<>(Arrays.asList(steps));
        return result;
    }
}