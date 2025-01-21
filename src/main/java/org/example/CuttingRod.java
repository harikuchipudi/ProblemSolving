package org.example;

import java.util.ArrayList;
import java.util.List;

public class CuttingRod {
    public static void multipleWayToCutTheRod(int length){
        List<Integer> arr = new ArrayList<>();
        for(int i=1; i<=length; i++){
            arr.add(i);
        }
        backtrack(arr, 0, 0, new ArrayList<>());
        return;
    }

    //this method outputs the possible ways to cut the rod and these different values are to be added based on the prices array to find the maximum value that can be achieved
    public static void backtrack(List<Integer> arr, int index, int sum, List<Integer> curr){
        if(arr.size() == sum){
            for(int i=0; i<curr.size()-1; i++){
                System.out.print(curr.get(i) + "->");
            }
            System.out.println(curr.get(curr.size()-1));
            return;
        }

        if(sum > arr.size()){
            return;
        }

        for(int i=index; i<arr.size(); i++){
            curr.add(arr.get(i));
            backtrack(arr, i+1, sum+arr.get(i), curr);
            curr.removeLast();
        }
    }

    public static void main(String[] args) {
        multipleWayToCutTheRod(8);
    }
}
