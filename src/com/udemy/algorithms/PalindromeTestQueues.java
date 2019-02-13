package com.udemy.algorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeTestQueues {

    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    private static boolean checkForPalindrome(String string) {
        String lower = string.toLowerCase();
        char[] arr = lower.toCharArray();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for(char ch : arr) {
            if(Character.isAlphabetic(ch)) {
                queue.add(ch);
                stack.push(ch);
            }
        }

        while(!stack.isEmpty()) {
            Character front = queue.poll();
            Character back = stack.pop();
            if(!front.equals(back)) {
                return false;
            }
        }

        return true;
    }


}
