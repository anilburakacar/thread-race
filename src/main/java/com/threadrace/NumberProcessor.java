package com.threadrace;

import java.util.List;

public class NumberProcessor extends Thread{
    private List<Integer> numbers;
    private List<Integer> evenNumbers;
    private List<Integer> oddNumbers;

    public NumberProcessor(List<Integer> numbers, List<Integer> evenNumbers, List<Integer> oddNumbers) {
        this.numbers = numbers;
        this.evenNumbers = evenNumbers;
        this.oddNumbers = oddNumbers;
    }

    @Override
    public void run() {
        for (int number : numbers) {
            if (number % 2 == 0) {
                synchronized (evenNumbers) {
                    evenNumbers.add(number);
                }
            } else {
                synchronized (oddNumbers) {
                    oddNumbers.add(number);
                }
            }
        }
    }
}
