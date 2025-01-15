package org.example;

import java.util.*;

public class Combinations {
    public static void combinationsList(){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(4, 2, result, curr, 1);
    }

    public static void backtrack(int n , int k, List<List<Integer>> result, List<Integer> curr, int index){
        if(curr.size()==k){
            System.out.println("-->");
            for(int num: curr) {
                System.out.print(num);
            }
            return;
        }
        for(int i=index; i<=n; i++){
            curr.add(i);
            backtrack(n, k, result, curr, i+1);
            curr.remove(curr.size()-1);
        }
    }

    public static void main(String[] args){
        combinationsList();
    }
}

