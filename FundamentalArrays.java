public class FundamentalArrays {

    private static int returnTarget(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private static int largetsElement(int[] arr) {
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (largest < arr[i]) {
                largest = arr[i];
            }
        }
        return largest;
    }

    private static int secondLargestElement(int[] arr) {
        if (arr.length == 1) {
            return -1;
        }
        int largest = Integer.MIN_VALUE;
        int secondLargestElement = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargestElement = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargestElement && arr[i] < largest) {
                secondLargestElement = arr[i];
            }
        }
        return secondLargestElement == Integer.MIN_VALUE ? -1 : secondLargestElement;
    }

    private static int maxConsecutiveOnes(int[] arr) {
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
            } else {
                count = 0;
            }
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }

    private static int[] rotateArrayByOneElement(int[] arr) {
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;

    }

    public static void main(String[] args) {
        int[] arr = { 8, 8, 7, 6, 5 };
        System.out.println(secondLargestElement(arr));

    }
}
