package com.company;

import java.util.*;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * Return the answer in any order.
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
public class LetterCombinationPhoneNumber {
    private Map<Character, Character[]> dictionary = new HashMap<>();
    private List<String> combinations = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) // "23" // ['a', 'b', 'c'] ['d', 'e', 'f']
    {
        initDic();
        digits = digits.replace("1", "");
        int[] arr = new int[digits.length()];
        int pos = 0;

        for (Character ch : digits.toCharArray()) // init arr as last indexes
        {
            arr[pos++] = dictionary.get(ch).length - 1;
        }
        pos = digits.length() - 1;
        // if curr has no left ret cur then switch to next
        // if next has no left
        int[] n_arr = Arrays.copyOf(arr, arr.length);

        if (digits.length() > 0) {
            combinations.add(toStr(n_arr, digits));
            loop:
            while (true) {
                int curval = n_arr[digits.length() - 1];
                if (curval == 0) {
                    if (n_arr.length > 1) {
                        for (int i = digits.length() - 2; i > -1; i--) {
                            if (n_arr[i] >= 1) {
                                n_arr[i] = n_arr[i] - 1;
                                pos = i;
                                break;
                            }
                            if (i == 0 && n_arr[i] == 0) break loop;
                        }

                        for (int i = pos + 1; i < digits.length(); i++) {
                            n_arr[i] = arr[i];
                        }
                    } else {
                        break;
                    }
                } else {
                    n_arr[digits.length() - 1] = n_arr[digits.length() - 1] - 1;
                }
                combinations.add(toStr(n_arr, digits));
            }
        }
        return combinations;
    }

    private String toStr(int[] n_arr, String digits) {
        try {
            for (int i = 0; i < n_arr.length; i++) {
                sb.append(dictionary.get(digits.charAt(i))[n_arr[i]]);
            }
            return sb.toString();
        } finally {
            sb.setLength(0);
        }
    }

    private void initDic() {
        dictionary.put('2', new Character[]{'a', 'b', 'c'});
        dictionary.put('3', new Character[]{'d', 'e', 'f'});
        dictionary.put('4', new Character[]{'g', 'h', 'i'});
        dictionary.put('5', new Character[]{'j', 'k', 'l'});
        dictionary.put('6', new Character[]{'m', 'n', 'o'});
        dictionary.put('7', new Character[]{'p', 'q', 'r', 's'});
        dictionary.put('8', new Character[]{'t', 'u', 'v'});
        dictionary.put('9', new Character[]{'w', 'x', 'y', 'z'});
    }
}
