package com.udemy.algorithms;

import java.util.Stack;

public class PalindromeTest {

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
        Stack<Character> characterStack = new Stack<>();
        for(char ch : arr) {
            if(Character.isAlphabetic(ch)) {
                characterStack.push(ch);
            }
        }

        for(char ch : arr) {
            if(Character.isAlphabetic(ch)){
                Character chFromStack = characterStack.pop();
                if(!chFromStack.equals(ch)) {
                    return false;
                }
            }
        }

        return true;
    }


}
