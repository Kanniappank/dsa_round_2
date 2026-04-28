
import java.util.ArrayList;
import java.util.List;

public class BasicMath {

    private static int countLength(int n) {
        if (n == 0) {
            return 1;
        }
        int count = 0;
        while (n > 0) {
            n = n / 10;
            count++;
        }
        return count;
    }

    private static int countOddNumbers(int n) {
        int oddCount = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            if (lastDigit % 2 != 0) {
                oddCount++;
            }
            n = n / 10;
        }
        return oddCount;
    }

    private static int reverseNumber(int n) {
        int reverse = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            reverse = (reverse * 10) + lastDigit;
            n = n / 10;
        }
        return reverse;
    }

    private static boolean isPalindrome(int n) {
        return n == reverseNumber(n);
    }

    private static int largestDigitInNumber(int n) {
        int largest = 0;
        while (n != 0) {
            int lastDigit = n % 10;
            if (lastDigit > largest) {
                largest = lastDigit;
            }
            n = n / 10;
        }
        return largest;
    }

    private static int factorial(int n) {

        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * i;
        }
        return ans;

    }

    private static boolean amstrongNumber(int n) {
        int sum = 0;
        int temp = n;
        int count = (int) Math.log10(n) + 1;
        System.out.println("count " + count);
        while (n != 0) {
            int lastDigit = n % 10;
            sum = sum + (int) Math.pow(lastDigit, count);
            n = n / 10;
        }
        return sum == temp;
    }

    public static boolean perfectNumber(int n) {
        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum = sum + i;
                if (i != n / i) {
                    sum = sum + (n / i);
                }
            }
            // System.out.println("sum : " + sum + " n :" + n+" i "+i);
        }
        return sum == n;
    }

    private static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int primeUptoN(long n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private static int gcd(int n1, int n2) {
        while (n1 != 0 && n2 != 0) {
            if (n1 > n2) {
                n1 = n1 % n2;
            } else {
                n2 = n2 % n1;
            }
        }
        return n1 + n2;
    }

    private static int lcm(int n1, int n2) {
        // brute force
        // int i = 1;
        // int maxNumber = Math.max(n1, n2);
        // do {
        // int multiple = i * maxNumber;
        // if (multiple % n1 == 0 && multiple % n2 == 0) {
        // return multiple;
        // }
        // return -1;
        // } while (true);

        // Optimal
        return (n1 * n2) / gcd(n1, n2);

    }

    private static List<Integer> divisor(int n) {
        List<Integer> divisors = new ArrayList<>();
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) {
                    divisors.add(n / i);
                }
            }
        }
        return divisors;
    }

    public static void main(String[] args) {
        int number = 634336;

        // System.out.println("Number Length : " + countLength(34532));
        // System.out.println("Odd Number Length : " + countOddNumbers(34532));
        // System.out.println("Reverse Number : " + reverseNumber(1234));
        // System.out.println("is "+number+" a palindrome "+ isPalindrome(number));
        // System.out.println("largest digit in "+number +" is
        // "+largestDigitInNumber(number));
        // System.out.println("Factorial of 5 is " + factorial(5));
        // System.out.println("Amstrong Number "+amstrongNumber(number));
        System.out.println("is perfect Number " + perfectNumber(36));
        // System.out.println(primeUptoN(100000000));
        // System.out.println(gcd(124, 84));
        // System.out.println("divisors " + divisor(8));

    }

}
