package org.example.calculate;

import java.util.List;

public class Calculator {
    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());

    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        //일반적인 방식
        /*if("+".equals(operator)){
            return operand1 + operand2;
        } else if("-".equals(operator)){
            return operand1 - operand2;
        } else if("*".equals(operator)){
            return operand1 * operand2;
        } else if("/".equals(operator)){
            return operand1 / operand2;
        }
        return 0;*/

        //enum 방식
        /*return ArithmeticOperator.calculate(operand1, operator, operand2);*/

        //인터페이스를 이용한 방식
        return arithmeticOperators.stream()
                .filter(arithmeticOperator -> arithmeticOperator.supports(operator))
                .map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
