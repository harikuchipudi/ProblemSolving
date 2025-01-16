package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class WordLadderTwo {

    public static void backtrack(String start, String end, List<String> wordList, List<List<String>> result, List<String> curr, int index){

        if(start.equals(end)){
            System.out.println(" ");
            for(String s: curr){
                System.out.print(s + " -> ");
            }
//            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index; i<wordList.size(); i++){
            String temp_next = wordList.get(i);
            if(isValid(temp_next, start)){
                curr.add(temp_next);
                backtrack(temp_next, end, wordList, result, curr, i+1);
                curr.remove(curr.size()-1);
            }
        }

    }

    public static boolean isValid(String s1, String s2){
        int diff = 0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                diff += 1;
            }
        }
        if(diff==1){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        List<List<String>> result = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        curr.add("hit");
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        backtrack("hit", "cog", wordList, result, curr, 0);

    }
}
