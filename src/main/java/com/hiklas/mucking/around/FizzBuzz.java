package com.hiklas.mucking.around;


import java.util.Optional;
import java.util.function.Function;

public class FizzBuzz
{
    public static final String FIZZ="fizz";
    public static final String BUZZ="buzz";

    protected Function<Integer, Optional<String>> divideByThreeFunction()
    {
        return (numberToTransform) -> {
            if ( checkModulusOrZero(numberToTransform, 3)) return Optional.of(FIZZ);
            else return Optional.empty();
        };
    }

    protected Function<Integer, Optional<String>> divideByFiveFunction()
    {
        return (numberToTransform) -> {
            if ( checkModulusOrZero(numberToTransform, 5)) return Optional.of(FIZZ);
            else return Optional.empty();
        };
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
}