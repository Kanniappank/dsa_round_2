import java.util.Arrays;

class BasicHashing {

    private static int maxElementOfArray(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static int highestOccuringElementInArray(int[] arr) {
        int maxElement = -1;
        int element = 0;
        int[] hash = new int[maxElementOfArray(arr) + 1];
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }
        for (int j = 0; j < hash.length; j++) {
            if (hash[j] > maxElement) {
                maxElement = hash[j];
                element = j;
            }
        }
        return element;
    }

    private static int secondHighestOccuringElement(int[] nums) {
        int element1 = -1;
        int element2 = -1;
        int element1Frequency = 0;
        int element2Frequency = 0;

        int[] hash = new int[maxElementOfArray(nums) + 1];

        System.out.println("hash " + Arrays.toString(hash));

        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]]++;
        }

        for (int j = 0; j < hash.length; j++) {
            int count = hash[j];

            if (count > element1Frequency) {
                element2Frequency = element1Frequency;
                element2 = element1;
                element1Frequency = count;
                element1 = j;
            } else if (count > element2Frequency) {
                element2Frequency = count;
                element2 = j;
            }
        }
        return element2;
    }

    private static int sumOfMinFreqAndMaxFreq(int[] nums) {
        int maxFreq = 0;
        int minFreq = nums.length;
        int[] hash = new int[maxElementOfArray(nums) + 1];
        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]]++;
        }

        for (int j = 0; j < hash.length; j++) {
            if(hash[j] !=0){
                maxFreq = Math.max(maxFreq, hash[j]);
                minFreq = Math.min(minFreq,hash[j]);
            }
        }
        return maxFreq + minFreq;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 4, 5, 5, 6, 7 };
        // System.out.println("highest occuring element " +
        // highestOccuringElementInArray(nums));
        System.out.println("second highest occuring number " + secondHighestOccuringElement(nums));
    }
}