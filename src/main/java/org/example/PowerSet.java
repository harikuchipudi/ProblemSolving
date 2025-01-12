package org.example;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static void generatePowerSet(int[] arr, List<Integer> current, int index){
        if(index==arr.length){
            System.out.println(current);
            return;
        }
        generatePowerSet(arr, current, index+1);

        current.add(arr[index]);
        generatePowerSet(arr, current, index+1);
        current.remove(current.size()-1);
    }

    public static void generatePowerSetUsingLoop(int[] arr, List<Integer> current, int index){
        System.out.println(current);
        for(int i=index; i<arr.length; i++){
            current.add(arr[i]);
            generatePowerSetUsingLoop(arr, current, i+1);
            current.remove(current.size()-1);
        }
    }

    public static void generatePartitions(String s, int index, List<String> current){
        if(index==s.length()){
            for(String st: current) {
                System.out.print(st + ", ");
            }
            System.out.println(" ");
        }

        for(int i=index; i<s.length(); i++){
            current.add(s.substring(index, i+1));
            generatePartitions(s, i+1, current);
            current.remove(current.size()-1);
        }
    }

    public static void genePartitionsWithoutLoop(String s, int start, int end, List<String> current){
        if(start == s.length()){
            for(String st: current){
                System.out.print(st+",");
            }
            System.out.println(" ");
        }

        if(end<=s.length() && start-end != 0){
            current.add(s.substring(start, end));
            genePartitionsWithoutLoop(s, end, end+1, current);
            current.remove(current.size()-1);
        }

        if(end <= s.length()){
            genePartitionsWithoutLoop(s, start, end+1, current);
        }

    }

    public static void main(String[] args){

        int[] arr = new int[3];
        for(int i=0; i<3; i++){
            arr[i] = i+1;
        }
//        generatePowerSet(arr, new ArrayList<>(), 0);

//        System.out.println("Generating power set using loops");
//        generatePowerSetUsingLoop(arr, new ArrayList<>(), 0);
        String str = "abc";
        generatePartitions(str, 0, new ArrayList<String>());

        System.out.println("Partitions without using loops");
        genePartitionsWithoutLoop(str, 0, 0, new ArrayList<String>());
    }


}
