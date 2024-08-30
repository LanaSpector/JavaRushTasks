package com.javarush.task.jdk13.task41.task4114;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private final Map<String, Operation> operationMap = new HashMap<>();

    public Calculator() {
        Processor processor = new Processor();
        operationMap.put("+", processor::plus);
        operationMap.put("*", processor::multiply);
        operationMap.put("-", processor::minus);
        operationMap.put("/", processor::divide);
    }

    public void calculate(int first, String operation, int second) {
        if (!operationMap.containsKey(operation)) {
            throw new IllegalStateException("no operation registered for" + operation);
        }
        operationMap.get(operation).execute(first, second);
    }
}
