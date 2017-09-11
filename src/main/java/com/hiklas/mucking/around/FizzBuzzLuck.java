package com.hiklas.mucking.around;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class FizzBuzzLuck extends FizzBuzz
{
    public static final String LUCK="luck";

    private final List<Object> LUCK_STEPS = new ArrayList<Object>()
    {{
       add( divideByThreeFunction() );
       add( divideByFiveFunction() );
       add( stopIfAlreadyHaveResult() );
       add( returnNumberAsString() );
    }};


    /**
     * Return the list of steps to process
     *
     * @return
     */
    @Override
    protected List<Object> getSteps()
    {
        return LUCK_STEPS;
    }

    protected Function<Integer, Optional<String>> checkForThreeDigit()
    {
        return (numberToTransform) -> {
            if ( numberToTransform.toString().contains("3") ) return Optional.of(LUCK);
            return Optional.empty();
        };
    }

}