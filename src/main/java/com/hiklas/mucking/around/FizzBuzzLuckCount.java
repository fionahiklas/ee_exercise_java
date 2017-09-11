package com.hiklas.mucking.around;


import java.util.List;

public class FizzBuzzLuckCount extends FizzBuzzLuck {
    private int luckCount = 0;
    private int fizzBuzzCount = 0;
    private int fizzCount = 0;
    private int buzzCount = 0;
    private int digitCount = 0;


    @Override
    public String processOneNumberWithSteps(Integer numberToProcess, List<Object> stepsToCheck) {
        String result = super.processOneNumberWithSteps(numberToProcess, stepsToCheck);
        return result;
    }

    public String outputStatistics() {
        StringBuffer outputBuffer = new StringBuffer();

        outputBuffer.append('\n');
        return outputBuffer.toString();
    }
}
