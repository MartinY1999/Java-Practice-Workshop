package com.balancedbrackets;

import java.io.*;
import java.util.*;

class Solution {
    static String isBalanced(String s) {
        char[] brackets = s.toCharArray();

        if (brackets.length % 2 != 0)
            return "NO";

        Stack<Bracket> unmatched = new Stack<>();
        unmatched.push(new Bracket(brackets[0]));

        for (int i = 1; i < brackets.length; i++) {
            Iterator<Bracket> iterator = unmatched.iterator();
            Bracket removeable = null;

            while (iterator.hasNext()) {
                Bracket current = iterator.next();
                if (current.opposite == brackets[i]) {
                    removeable = current;
                    break;
                }
            }

            if (removeable != null)
                unmatched.remove(removeable);
            else
                unmatched.push(new Bracket(brackets[i]));
        }

        if (unmatched.isEmpty())
            return "YES";
        else
            return "NO";
    }

    private static class Bracket {
        private char bracket;
        private char opposite;

        public Bracket(char bracket) {
            this.bracket = bracket;
            setOpposite();
        }

        private void setOpposite() {
            if (this.bracket == '(')
                this.opposite = ')';
            else if (this.bracket == '[')
                this.opposite = ']';
            else if (this.bracket == '{')
                this.opposite = '}';
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            System.out.println(result);
        }
    }
}
