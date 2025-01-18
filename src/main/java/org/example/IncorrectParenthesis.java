package org.example;

public class IncorrectParenthesis {

    public static void printParenthesis(String s, int index, String curr){
        if(index==s.length()){
            System.out.println(curr);
            return;
        }

        for(int i=index; i<s.length(); i++){
            printParenthesis(s, i+1, curr+s.charAt(i));
        }
    }

    public static void main(String[] args){
        printParenthesis("()())()", 0, "");
    }
}
