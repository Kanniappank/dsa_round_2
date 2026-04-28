public class BasicArrays {

    private static int sumOfArrays(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    private static int oddNumberCount(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    private static int[] reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int temp = 0;
        while (left < right) {
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]<arr[i-1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        // System.out.println("Sum is " + sumOfArrays(arr));
        System.out.println("Odd number count " + oddNumberCount(arr));
    }
}
