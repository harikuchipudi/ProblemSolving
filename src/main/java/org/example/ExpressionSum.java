package org.example;

import java.util.List;

public class ExpressionSum {

    public static void solveExpression(String expr, int target){
        char[] ops = {'+', '-', '*'};
        int target_value = expr.charAt(0)-'0';
//        String curr_string = String.valueOf(expr.charAt(0));
        backtrack(expr, target_value, 0, "", 0,0);
    }

    public static void backtrack(String num, int target, int index, String result, long currentValue, long lastOperand){
        if(index==num.length() && target==currentValue){
            System.out.println(result);
            return;
        }


        for(int i=index; i<num.length(); i++){
            if(i!=index && num.charAt(i) == '0'){
                break;
            }

            String currentSubstring = num.substring(index, i + 1);
            long currentNumber = Long.parseLong(currentSubstring);

            if(index==0){
                backtrack(num, target, i+1, currentSubstring, currentValue, currentNumber);
            }
            else{
                backtrack(num, target, i+1, result+'+'+currentSubstring, currentValue+currentNumber, currentNumber );

                backtrack(num, target, i+1, result+'-'+currentSubstring, currentValue-currentNumber, -currentNumber );

                backtrack(num, target, i+1, result+'*'+currentSubstring, currentValue*currentNumber, currentValue - lastOperand + lastOperand * currentNumber );
            }
        }
    }



    public static void main(String[] args){
        String num = "1234";
        solveExpression(num, 10);
    }
}
