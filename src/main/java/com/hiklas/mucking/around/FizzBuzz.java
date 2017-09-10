package com.hiklas.mucking.around;


import java.util.Optional;
import java.util.function.Function;

public class FizzBuzz
{

    protected Function<Integer, Optional<String>> divideByThreeFunction()
    {
        return (numberToTransform) -> {
            return Optional.empty();
        };
    }

    protected Function<Integer, Optional<String>> divideByFiveFunction()
    {
        return (numberToTransform) -> {
            return Optional.empty();
        };
    }

}