package org.example;

import java.util.*;

public class wordLadder {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> result = new ArrayList<>();
            if (!wordList.contains(endWord)) {
                return result; // Early exit if endWord is not in wordList
            }

            List<String> curr = new ArrayList<>();
            curr.add(beginWord);

            backtrack(beginWord, endWord, wordList, result, curr, new HashSet<>());

            // Filter results to include only shortest paths
            Collections.sort(result, (list1, list2) -> Integer.compare(list1.size(), list2.size()));
            int minLen = result.isEmpty() ? 0 : result.get(0).size();

            List<List<String>> finalResult = new ArrayList<>();
            for (List<String> path : result) {
                if (path.size() == minLen) {
                    finalResult.add(path);
                }
            }
            return finalResult;
        }

        public void backtrack(String start, String end, List<String> wordList, List<List<String>> result, List<String> curr, Set<String> visited) {
            if (start.equals(end)) {
                result.add(new ArrayList<>(curr));
                return;
            }

            for (String temp_next : wordList) {
                if (!visited.contains(temp_next) && isValid(temp_next, start)) {
                    visited.add(temp_next);
                    curr.add(temp_next);
                    backtrack(temp_next, end, wordList, result, curr, visited);
                    curr.remove(curr.size() - 1);
                    visited.remove(temp_next);
                }
            }
        }

        public boolean isValid(String s1, String s2) {
            int diff = 0;
            for (int i = 0; i < s1.length() && diff <= 1; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    diff++;
                }
            }
            return diff == 1;
        }

        public static void main(String[] args){

        }
    }

