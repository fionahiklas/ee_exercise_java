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

        switch (result)
        {
            case "luck":
                luckCount++;
                break;

            case "fizzbuzz":
                fizzBuzzCount++;
                break;

            case "fizz":
                fizzCount++;
                break;

            case "buzz":
                buzzCount++;
                break;

            default:
                digitCount++;
                break;
        }

        return result;
    }

    public String outputStatistics() {
        StringBuffer outputBuffer = new StringBuffer();

        outputBuffer.append(String.format("fizz: %d\n", fizzCount));
        outputBuffer.append(String.format("buzz: %d\n", buzzCount));
        outputBuffer.append(String.format("fizzbuzz: %d\n", fizzBuzzCount));
        outputBuffer.append(String.format("luck: %d\n", luckCount));
        outputBuffer.append(String.format("number: %d\n", digitCount));

        return outputBuffer.toString();
    }
}
