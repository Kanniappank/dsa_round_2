import java.util.Arrays;

public class Recursion {

    private static char[] reverseString(char[] s, int left, int right) {
        if (left >= right) {
            return s;
        }
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        return reverseString(s, left + 1, right - 1);
    }

    private static boolean isPalindromeCheck(String s) {
        return isPalindrome(s, 0, s.length()-1);

    }

    private static boolean isPalindrome(String s, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        return isPalindrome(s, left+1, right-1);
    }

    public static void main(String[] args) {
        // char[] s = { 'K', 'a', 'n', 'n', 'i', 'a', 'p', 'p', 'a', 'n' };
        // System.out.println("Reverse of Kanniappan is : " + Arrays.toString(reverseString(s, 0, s.length - 1)));

        String s = "madam";
        System.out.println("Madam is a palindrome : "+isPalindromeCheck(s));

    }
}   