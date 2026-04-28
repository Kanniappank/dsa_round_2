
import java.util.*;

public class BasicStrings {
    public static class Pair {
        char ch;
        int freq;

        public Pair(char c, int freq) {
            this.ch = c;
            this.freq = freq;
        }

        public String toString() {
            return "[ch = " + ch + ", freq = " + freq + "]" + "\n";
        }
    }

    private static String reverseString(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] strCharArr = s.toCharArray();
        while (left < right) {
            char temp = strCharArr[left];
            strCharArr[left] = strCharArr[right];
            strCharArr[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(strCharArr);
    }

    private static boolean isPalindrome(String s) {
        return s.equals(reverseString(s));
    }

    private static String largestOddNumber(String s) {
        int lastIndex = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if ((s.charAt(i) - '0') % 2 != 0) {
                lastIndex = i;
                break;
            }
        }
        if (lastIndex == -1) {
            return "";
        }
        int i = 0;
        while (i < lastIndex && s.charAt(i) == '0') {
            i++;
        }

        return s.substring(i, lastIndex + 1);

    }

    private static String longestCommonPrefix(String[] s) {

        if (s.length == 1) {
            return s[0];
        }
        Arrays.sort(s);
        String firstStr = s[0];
        String lastStr = s[s.length - 1];
        String longestCommonPrefix = "";
        for (int i = 0; i <= Math.min(firstStr.length() - 1, lastStr.length() - 1); i++) {
            if (firstStr.charAt(i) != lastStr.charAt(i)) {
                break;
            }
            longestCommonPrefix += firstStr.charAt(i);
        }
        return longestCommonPrefix;

    }

    private static boolean isomorphicString(String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
                return false;
            }
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }

    private static boolean rotateString(String s, String goal) {
        String left = "";
        String right = "";

        for (int i = 0; i < s.length() - 1; i++) {
            right = s.substring(i);
            if ((right + left).equals(goal)) {
                return true;
            }
            left += s.charAt(i);
        }
        return false;
    }

    private static boolean rotateStringOptimal(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }
        String temp = s + s;
        return temp.contains(goal);
    }

    private static boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);
    }

    private static List<Character> frequencySort(String s) {

        Pair[] freq = new Pair[26];

        for (int i = 0; i < 26; i++) {
            freq[i] = new Pair((char) (i + 'a'), 0);
        }

        for (char ch : s.toCharArray()) {
            freq[ch - 'a'].freq++;
        }
        System.out.println(Arrays.toString(freq));

        Arrays.sort(freq, (p1, p2) -> {
            if (p1.freq > p2.freq)
                return -1;
            if (p1.freq < p2.freq)
                return 1;
            if (p1.ch < p2.ch)
                return -1;
            if (p1.ch > p2.ch)
                return 1;
            return 0; 

        });

        List<Character> ans = new ArrayList();
        for (Pair p : freq) {
            if (p.freq > 0) {
                ans.add(p.ch);
            }
        }
        return ans;

    }

    public static void main(String[] args) {

        // System.out.println("reverse of String Kanniappan is " +
        // reverseString("Kanniappan"));
        // System.out.println("Is aba palindrome ? " + isPalindrome("aba"));
        // System.out.println(largestOddNumber("0214638"));
        // String[] stArr = { "test", "test", "test" };
        // System.out.println(longestCommonPrefix(stArr));
        // System.out.println(isomorphicString("foo", "bar"));
        // System.out.println(rotateString("abcde", "cdeab"));
        // System.out.println(rotateStringOptimal("abcde", "cdeab"));

        System.out.println(frequencySort("tree"));

    }

}
