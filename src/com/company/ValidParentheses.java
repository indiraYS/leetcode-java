package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> wishes = new Stack<>();

        Map<Character, Character> parentheses = new HashMap<Character, Character>() {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};
        for (int i = 0; i < s.length(); i++) {
            if (i==0 || wishes.size() == 0) {
                wishes.push(parentheses.get(s.charAt(i)));
            } else {
                if (wishes.get(wishes.size()-1) == null) break;

                if (s.charAt(i) != wishes.get(wishes.size()-1)) {
                    wishes.push(parentheses.get(s.charAt(i)));
                } else {
                    wishes.pop();
                }
            }
        }
        return wishes.isEmpty();
    }


}
