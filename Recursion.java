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
        return isPalindrome(s, 0, s.length() - 1);
    }

    private static boolean isPalindrome(String s, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        return isPalindrome(s, left + 1, right - 1);
    }

    private static boolean isPrime(int n, int divisor) {
        if ((divisor * divisor) > n) {
            return true;
        }
        if (n % divisor == 0) {
            return false;
        }
        return isPrime(n, divisor + 1);
    }

    private static int[] reverseArray(int[] n, int left, int right) {
        if (left >= right) {
            return n;
        }
        int temp = n[left];
        n[left] = n[right];
        n[right] = temp;
        return reverseArray(n, left + 1, right - 1);
    }

    private static boolean isArraySorted(int[] n, int i) {
        if (i >= n.length - 1) {
            return true;
        }
        if (n[i] > n[i + 1]) {
            return false;
        }
        return isArraySorted(n, i+1);

    }

    // private static int addDigits(int num,int sum){
    //     if()


    // }

    private static int fibonacciNumber(int num,int sum){
        if(num==0){
            return sum;
        }
        sum*=num;
        return fibonacciNumber(num-1, sum);
    }
    public static void main(String[] args) {
        // char[] s = { 'K', 'a', 'n', 'n', 'i', 'a', 'p', 'p', 'a', 'n' };
        // System.out.println("Reverse of Kanniappan is : " +
        // Arrays.toString(reverseString(s, 0, s.length - 1)));

        // String s = "madam";
        // System.out.println("Madam is a palindrome : " + isPalindromeCheck(s));
        // int n = 12;
        // System.out.println("does " + n + " prime: " + isPrime(n, 2));

        int[] n = { 1, 4, 5, 7, 8 };
        // System.out.println(Arrays.toString(reverseArray(n, 0, n.length - 1)));
        // System.out.println("is array sorted: "+isArraySorted(n, 0));

        System.out.println("Fibonacci of 5 is: "+fibonacciNumber(5, 1));

    }
}