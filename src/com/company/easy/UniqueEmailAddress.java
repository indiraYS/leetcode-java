package com.company.easy;

/**
 * ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * "test.email+alex@leetcode.com" = "testemail@leetcode.com"
 */
public class UniqueEmailAddress {
    public String canonize(String email) {
        char[] arr = email.toCharArray();
        boolean plus = false;
        boolean domain = false;
        int next = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!domain) {
                if (arr[i] == '.') {
                    continue;
                } else if (arr[i] == '+') {
                    plus = true;
                    continue;
                } else if (arr[i] == '@') {
                    domain = true;
                } else if (plus) {
                    continue;
                }
            }
            arr[next] = arr[i];
            next++;
        }

        return String.valueOf(arr).substring(0, next);
    }
    public int numUniqueEmails(String[] emails) {
        return 0;
    }
}
