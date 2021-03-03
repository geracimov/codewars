package ru.geracimov.codewars;

import lombok.experimental.UtilityClass;

/**
 * Write a function that takes a string of parentheses, and determines if the order of the parentheses is valid.
 * The function should return true if the string is valid, and false if it's invalid.
 * Examples
 * "()"              =>  true
 * ")(()))"          =>  false
 * "("               =>  false
 * "(())((()())())"  =>  true
 * Constraints
 * 0 <= input.length <= 100
 * Along with opening (() and closing ()) parenthesis, input may contain any valid ASCII characters. Furthermore, the
 * input string may be empty and/or not contain any parentheses at all. Do not treat other forms of brackets as
 * parentheses (e.g. [], {}, <>).
 * https://www.codewars.com/kata/52774a314c2333f0a7000688
 */
@UtilityClass
public class ValidParentheses {

    public static boolean validParentheses(String parens) {
        if (parens == null || parens.isEmpty()) return true;
        int valid = 0;
        for (char c : parens.toCharArray()) {
            if (c == '(') valid++;
            else if (c == ')') valid--;
            if (valid < 0) return false;
        }
        return valid == 0;
    }

}
