package org.example;

import java.util.HashMap;
import java.util.Map;

public class NumToWords {

    String[] nums = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] tens = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] teens = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        StringBuilder result = new StringBuilder();
        Map<Integer, String> places = new HashMap<>();
        places.put(3, "Hundred");
        places.put(4, "Thousand");
        places.put(6, "Lakh");
        places.put(8, "Crore");

        int count = 1;
        while (num > 0) {
            if (count <= 2) { // Handle last two digits
                int curr_num = num % 100;
                String temp = twoDigits(curr_num);
                if (!temp.isEmpty()) {
                    result.insert(0, temp + " ");
                }
                num /= 100;
                count += 2;
            } else if (count == 3) { // Handle "Hundred"
                int curr_num = num % 10;
                if (curr_num > 0) {
                    result.insert(0, nums[curr_num - 1] + " " + places.get(3) + " ");
                }
                num /= 10;
                count += 1;
            } else { // Handle larger place values
                int placeValue = count <= 5 ? 4 : (count <= 7 ? 6 : 8);
                int curr_num = num % 100;
                String temp = twoDigits(curr_num);
                if (!temp.isEmpty()) {
                    result.insert(0, temp + " " + places.get(placeValue) + " ");
                }
                num /= 100;
                count += 2;
            }
        }
        return result.toString().trim();
    }

    public String twoDigits(int num) {
        if (num == 0) return "";
        if (num < 10) {
            return nums[num - 1];
        } else if (num < 20 && num != 10) {
            return teens[num - 11];
        } else {
            int onesPlace = num % 10;
            int tensPlace = num / 10;
            String result = tens[tensPlace - 1];
            if (onesPlace > 0) {
                result += " " + nums[onesPlace - 1];
            }
            return result;
        }
    }

    public static void main(String[] args) {
        NumToWords converter = new NumToWords();
        System.out.println(converter.numberToWords(12345678)); // Output: "One Crore Twenty Three Lakh Forty Five Thousand Six Hundred Seventy Eight"
        System.out.println(converter.numberToWords(0)); // Output: "Zero"
        System.out.println(converter.numberToWords(1001)); // Output: "One Thousand One"
        System.out.println(converter.numberToWords(1000000)); // Output: "Ten Lakh"
    }
}
