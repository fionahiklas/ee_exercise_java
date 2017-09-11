package com.hiklas.mucking.around;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FizzBuzz
{
    public static final String FIZZ="fizz";
    public static final String BUZZ="buzz";

    private final List<Object> STEPS = new ArrayList<Object>()
    {{
       add( divideByThreeFunction() );
       add( divideByFiveFunction() );
       add( stopIfAlreadyHaveResult() );
       add( returnNumberAsString() );
    }};

    /**
     * Process a string that is expected to contain integers seperated by
     * spaces.  Pass each number to the the {@link #processStringOfNumbers(String)}
     * method and collect the results as a space-seperated string
     *
     * @param stringOfNumbers
     * @return
     */
    public String processStringOfNumbers(String stringOfNumbers)
    {
        StringBuffer outputBuffer = new StringBuffer();
        StringTokenizer tokeniser = new StringTokenizer(stringOfNumbers, " ");
        String item = null;
        Integer itemAsInteger = null;

        while(tokeniser.hasMoreTokens())
        {
            if( outputBuffer.length() > 0 ) outputBuffer.append(" ");

            item = tokeniser.nextToken();
            itemAsInteger = Integer.parseInt(item);

            outputBuffer.append(
              processOneNumberWithSteps(itemAsInteger, STEPS)
            );
        }

        return outputBuffer.toString();
    }


    /**
     * Take one number and figure out what the output should be
     *
     * @param numberToProcess
     * @param stepsToCheck
     * @return
     */
    public String processOneNumberWithSteps(Integer numberToProcess, List<Object> stepsToCheck)
    {
        StringBuffer outputBuffer = new StringBuffer();

        for(Object step:stepsToCheck)
        {
            if( step instanceof Function) {
                Optional<String> stepResult = processStepFunction(step, numberToProcess);

                if( stepResult.isPresent() ) outputBuffer.append( stepResult.get() );
            }

            if( step instanceof Predicate) {

                if( processStepPredicate(step, outputBuffer) ) break;
            }

            // TODO: Handle something other than the above to make code more robust
        }

        return outputBuffer.toString();
    }

    /**
     * Return a function that tests whether the given number is
     * divisible by three.  If it is then an output string is returned,
     * in the Optional result, otherwise this is empty
     *
     * @return
     */
    protected Function<Integer, Optional<String>> divideByThreeFunction()
    {
        return (numberToTransform) -> {
            if ( checkModulusOrZero(numberToTransform, 3)) return Optional.of(FIZZ);
            else return Optional.empty();
        };
    }

    /**
     * Return a function that tests whether the given number is
     * divisible by five.  If it is then an output string is returned,
     * in the Optional result, otherwise this is empty
     *
     * @return
     */
    protected Function<Integer, Optional<String>> divideByFiveFunction()
    {
        return (numberToTransform) -> {
            if ( checkModulusOrZero(numberToTransform, 5)) return Optional.of(BUZZ);
            else return Optional.empty();
        };
    }


    protected Function<Integer, Optional<String>> checkForThreeDigit()
    {
        return (numberToTransform) -> {
            return Optional.empty();
        };
    }


    /**
     * Return a function that performs a dummy operation, it returns a
     * string version of the number that is passed to it.
     *
     * @return
     */
    protected Function<Integer, Optional<String>> returnNumberAsString()
    {
        return (numberToTransform) -> Optional.of(Integer.toString(numberToTransform));
    }

    /**
     * Return a predicate that checks some property of the output buffer to decide if
     * we're done processing a single number
     *
     * @return
     */
    protected Predicate<StringBuffer> stopIfAlreadyHaveResult()
    {
        return (currentResult) -> (currentResult != null && currentResult.length() > 0);
    }

    /**
     * Check if the numberToTest can be divided equally by the divisor,
     * if it can return true.  If numberToTest is zero or can't be
     * divided equally by the divisor return false
     *
     * @param numberToTest
     * @param divisor
     * @return
     */
    private boolean checkModulusOrZero(Integer numberToTest, Integer divisor)
    {
       return (numberToTest != 0 && numberToTest % divisor == 0);
    }


    private Optional<String> processStepFunction(Object step, Integer numberToProcess)
    {
        Function<Integer, Optional<String>> stepFunction = (Function<Integer, Optional<String>>) step;
        return stepFunction.apply(numberToProcess);
    }


    private boolean processStepPredicate(Object step, StringBuffer outputBuffer)
    {
        Predicate<StringBuffer> stepPredicate = (Predicate<StringBuffer>) step;
        return stepPredicate.test(outputBuffer);
    }
}