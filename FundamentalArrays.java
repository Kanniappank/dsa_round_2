import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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
        return arr;

    }

    private static int[] reverseArray(int[] arr, Integer start, Integer end) {
        if (start == null) {
            start = 0;
        }
        if (end == null) {
            end = arr.length - 1;
        }
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }

    private static int[] rotateArrayLeftByDelements(int[] arr, int d) {
        d = d % arr.length;
        reverseArray(arr, 0, d - 1);
        reverseArray(arr, d, arr.length - 1);
        reverseArray(arr, 0, arr.length - 1);
        return arr;
    }

    private static void swap(int[] arr, int firstPostion, int secondPosition) {
        int temp = arr[firstPostion];
        arr[firstPostion] = arr[secondPosition];
        arr[secondPosition] = temp;
    }

    private static int[] moveZerosToEnd(int[] arr) {
        // int j=-1;
        // for(int i=0;i<arr.length;i++){
        // if(arr[i]==0){
        // j=i;
        // break;
        // }
        // }
        // for(int i=j+1;i<arr.length;i++){
        // if(arr[i]!=0){
        // swap(arr,i,j);
        // j++;
        // }
        // }
        // return arr;

        int j = 0; // zero elements

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) { // non-zero elements
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                j++;
            }
        }
        return arr;
    }

    private static int returnNoOfUniqueElements(int[] arr) {
        // Brute force

        // Set<Integer> s = new TreeSet<>();

        // for (int i = 0; i < arr.length; i++) {
        // s.add(arr[i]);
        // }

        // int setSize = s.size();
        // int i = 0;
        // for (Integer num : s) {
        // arr[i] = num;
        // }
        // return setSize;

        // Optimal solution

        int j = 0;
        for (int i = 1; i < arr.length; i++) { // i=1 first element is already considered as unique
            if (arr[j] != arr[i]) {
                arr[j + 1] = arr[i];
                j++;
            }
        }
        return j + 1;
    }

    private static int missingNumber(int[] arr) {
        /*
         * 1. first brute force get the size of the array and run a loop from 1 to n
         * check whether the looping number is available in the array or not if not
         * available
         * it is the missing number
         * 2. Better solution iterate over the array and hash by marking 1 in the
         * indexes of the array
         * the missing numbers index alone be 0 return the index by iterating over the
         * hash array
         * 3. there are 2 optimal solutions one is finding the sum of the natural
         * numbers from the
         * and iterate through the array and get the sum of the array and subtract the
         * sum and sum of the array
         * the balance is the missing number
         * 4. second optimal solution we can find using the xor from 1 to n number and
         * iterate througth the
         * the array and xor every element and xor 1 and xor 2 you will get the missing
         * number
         * 
         */

        // brute force
        // for(int i =1;i<arr.length;i++){
        // int flag=0;
        // for(int j=0;j<arr.length;j++){
        // if(i==arr[j]){
        // flag=1;
        // break;
        // }
        // }
        // if(flag == 0){
        // return i;
        // }
        // }

        // better
        // int[] hash = new int[arr.length];

        // for (int i = 0; i < arr.length; i++) {
        // hash[i] = 1;
        // }

        // for (int i = 1; i < hash.length; i++) {
        // if (hash[i] == 0) {
        // return i;
        // }
        // }

        // optimal 1
        // int length = arr.length;
        // int sum = length*(length+1)/2;
        // int s2=0;
        // for(int i = 0 ;i<arr.length;i++){
        // s2+=arr[i];
        // }
        // return sum-s2;

        // optimal 2
        int xor1 = 0;
        int xor2 = 0;

        for (int i = 0; i < arr.length; i++) {
            xor2 ^= arr[i];
            xor1 ^= (i);
        }

        int n = arr.length;

        xor1 ^= n;

        return xor1 ^ xor2;

    }

    private static List<Integer> unionTwoSortedArrays(int[] arr1, int[] arr2) {

        /*
         * Brute force
         * use a set add all the elements of arr1 and arr2 get back all the added
         * elements to the
         * new array and return the array this array consist only unique elements
         */
        // List<Integer> result = new ArrayList<>();
        // Set<Integer> set = new TreeSet<>();
        // for (int i = 0; i < arr1.length; i++) {
        // set.add(arr1[i]);
        // }

        // for (int i = 0; i < arr2.length; i++) {
        // set.add(arr2[i]);
        // }

        // for (Integer num : set) {
        // result.add(num);
        // }
        // return result;

        // Optimal
        List<Integer> result = new ArrayList<>();
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0;
        int j = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                if (result.size() == 0 || result.get(result.size() - 1) != arr1[i]) {
                    result.add(arr1[i]);
                }
                i++;
            } else {
                if (result.size() == 0 || result.get(result.size() - 1) != arr2[j]) {
                    result.add(arr2[j]);
                }
                j++;
            }
        }
        while (i < n1) {
            if (result.size() == 0 || result.get(result.size() - 1) != arr1[i]) {
                result.add(arr1[i]);
            }
            i++;
        }
        while (j < n2) {
            if (result.size() == 0 || result.get(result.size() - 1) != arr2[j]) {
                result.add(arr2[j]);
            }
            j++;
        }

        return result;

    }

    private static int[] intersectionOfTwoArrays(int[] nums1, int[] nums2) {

        // brute force
        // List<Integer> result = new ArrayList<>();
        // int n1 = nums1.length;
        // int n2 = nums2.length;
        // int[] visitedArr = new int[n2];

        // for (int i = 0; i < n1; i++) {
        // for (int j = 0; j < n2; j++) {
        // if (nums1[i] == nums2[j] && visitedArr[j] == 0) {
        // result.add(nums2[j]);
        // visitedArr[j] = 1;
        // break;
        // }
        // if (nums2[j] > nums1[i]) {
        // break;
        // }
        // }

        // }
        // int[] intersection = new int[result.size()];
        // for (int i = 0; i < result.size(); i++) {
        // intersection[i] = result.get(i);
        // }

        // return intersection;

        // optimal solution

        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                result.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] intersection = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            intersection[k] = result.get(k);
        }
        return intersection;
    }

    private static int majorityElement(int[] arr) {
        // Brute force
        // int n = arr.length;
        // for (int i = 0; i < n; i++) {
        // int count = 0;
        // for (int j = 0; j < n; j++) {
        // if (arr[i] == arr[j]) {
        // count++;
        // }

        // }
        // if (count > n / 2) {
        // return arr[i];
        // }
        // }
        // return -1;

        // better

        // int n = arr.length;
        // HashMap<Integer, Integer> hash = new HashMap<>();
        // for (int num : arr) {
        // hash.put(num, hash.getOrDefault(num, 0) + 1);
        // }

        // for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
        // if (entry.getValue() > n / 2) {
        // return entry.getKey();
        // }
        // }
        // return -1;

        /*
         * Optimal solution Moore's voting algorithm
         * If an element occurs more than half the time, it can “cancel out” all other
         * elements combined.
         * The algorithm keeps:
         * 
         * a candidate
         * a count
         * 
         * Rules:
         * 
         * If count == 0, choose current element as candidate.
         * If current element equals candidate → increment count.
         * Otherwise → decrement count.
         * 
         * After one pass, the remaining candidate is the majority element (if one
         * exists).
         */

        int element = 0;
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                count = 1;
                element = arr[i];
            } else if (element == arr[i]) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int j = 0; j < n; j++) {
            if (element == arr[j]) {
                count++;
            }
        }
        if (count > n / 2) {
            return element;
        }
        return -1;
    }

    private static int[] leadersOfarray(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int min = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > min) {
                ans.add(nums[i]);
                min = nums[i];
            }
        }
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

    private static int[] arrangeElements(int[] nums) {
        // Brute force
        int n = nums.length;
        // List<Integer> pos = new ArrayList<>();
        // List<Integer> neg = new ArrayList<>();
        // for (int i = 0; i < n; i++) {
        // if (nums[i] < 0) {
        // neg.add(nums[i]);
        // } else {
        // pos.add(nums[i]);
        // }
        // }
        // for (int i = 0; i < n/2; i++) {
        // nums[2 * i] = pos.get(i);
        // nums[2 * i + 1] = neg.get(i);
        // }
        // return nums;

        // optimal

        int[] ans = new int[n];
        int posIndex = 0;
        int negIndex = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans[posIndex] = nums[i];
                posIndex += 2;
            } else
                ans[negIndex] = nums[i];
            negIndex += 2;
        }
        return ans;
    }

    private static List<Integer> printSpiralMatrix(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = columns - 1;

        while (top <= bottom && left <= right) {
            // right
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            for (int j = top; j <= bottom; j++) {
                ans.add(matrix[j][right]);
            }
            right--;
            if (top <= bottom) {
                for (int k = right; k >= left; k--) {
                    ans.add(matrix[bottom][k]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int l = bottom; l >= top; l--) {
                    ans.add(matrix[l][left]);
                }
                left++;
            }
        }
        return ans;
    }

    private static int ncr(int n, int r) {
        int res = 1;
        for (int i = 0; i < r; i++) {
            res *= (n - i);
            res /= i + 1;
        }
        return res;
    }

    private static List<Integer> printNthRowPascalTriangle(int n) {
        int ans = 1;
        List<Integer> res = new ArrayList<>();
        res.add(ans);
        for (int i = 1; i < n; i++) {
            ans *= (n - i);
            ans /= i;
            res.add(ans);
        }
        return res;
    }

    private static List<List<Integer>> pascalTriangleOfNrows(int n) {
        List<List<Integer>> finalList = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            List<Integer> tempList = printNthRowPascalTriangle(i);
            finalList.add(tempList);
        }
        return finalList;
    }

    private static int[] twoSum(int[] arr, int target) {
        int[] ans = new int[2];
        int n = arr.length;
        // Brute force
        /*
         * Use a nested loop pick one element at a time and compare with the other
         * elements
         * if it matches the target the current index and the comparing index
         */

        // for (int i = 0; i < n; i++) {
        // for (int j = i + 1; j < n; j++) {
        // if (arr[i] + arr[j] == target) {
        // ans[0]=i;
        // ans[1]=j;
        // }
        // }
        // }

        // Better solution
        /*
         * Better solution is using a hash map
         * with the current index subtract the current element with the target if the
         * diffrence number
         * is available return the current index and the available numbers index stored
         * in the hash map
         */
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int balance = target - arr[i];
            if (hash.containsKey(balance)) {
                ans[0] = hash.get(balance);
                ans[1] = i;
            }
            hash.put(arr[i], i);
        }
        return ans;

        // optimal approach
        /*
         * there are 2 varity of asking this question varity 1 is we have to tell
         * wheather we have
         * the two number that add up to give the target
         * the second varity is we need to return the two numbers indexes for the second
         * varity the better
         * is the optimal approach
         * for the 1st varity we have a two pointer approach sort the given array and
         * use to pointer at the
         * start and end add the 2 elements if the sum is grater than the target decreas
         * the right pointer
         * if the sum is smaller than the target the increase the left pointer if it
         * matches the target return true
         */

        // int left = 0;
        // int right = n;
        // Arrays.sort(arr);
        // while (left < right) {
        // if (arr[left] + arr[right] > target) {
        // right--;
        // }
        // else if(arr[left]+arr[right]<target){
        // left++;
        // }
        // else{
        // return true;
        // }
        // }
        // return false;

    }

    private static int[][] rotateMatrix90degree(int[][] mat) {
        // brute force
        // int n = mat.length;
        // int[][] ans = new int[n][n];
        // for (int i = 0; i < mat.length; i++) {
        // for (int j = 0; j < mat.length; j++) {
        // ans[j][(n - 1) - i] = mat[i][j];
        // }
        // }
        // return ans;

        // optimal
        int n = mat.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            reverseArray(mat[i], null, null);
        }
        return mat;
    }

    private static List<List<Integer>> triplesSumZero(int[] arr) {

        // Brute force is to use the 3 nested loops to find the
        // List<List<Integer>> ans = new ArrayList<>();
        // Set<List<Integer>> st = new HashSet<>();
        // int n = arr.length;
        // for (int i = 0; i < n; i++) {
        // for (int j = i + 1; j < n; j++) {
        // for (int k = j + 1; k < n; k++) {
        // int sum = arr[i] + arr[j] + arr[k];
        // if (sum == 0) {
        // List<Integer> temp = new ArrayList<>();
        // st.add(Arrays.asList(arr[i], arr[j], arr[k]));
        // Collections.sort(temp);
        // st.add(temp);
        // }
        // }
        // }
        // }
        // for (List<Integer> item : st) {
        // ans.add(item);
        // }
        // return ans;

        // Better solution
        /*
         * Reducing the looping to a 2 loop instead of a 3 loops
         * with the formula x+y+z=0 x=-(z+y)
         */

        // List<List<Integer>> ans = new ArrayList<>();
        // Set<List<Integer>> resultSet = new HashSet<>();
        // int n = arr.length;
        // for (int i = 0; i < n; i++) {
        // Set<Integer> comparingSet = new HashSet<>();
        // for (int j = i + 1; j < n; j++) {
        // int balance = -(arr[i] + arr[j]);
        // if (comparingSet.contains(balance)) {
        // List<Integer> temp = Arrays.asList(arr[i], arr[j], balance);
        // Collections.sort(temp);
        // resultSet.add(temp);
        // }
        // comparingSet.add(arr[j]);
        // }
        // }
        // for (List<Integer> item : resultSet) {
        // ans.add(item);
        // }
        // return ans;

        // Optimal approach
        /*
         * to use 2 pointer approach solve this problem
         */
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while (j < k && arr[j] == arr[j - 1])
                        j++;
                    while (j < k && arr[k] == arr[k + 1])
                        k--;
                }
            }
        }
        return ans;

    }

    private static int[] sort012(int[] nums) {

        // brute force
        /* is to use merge sort */

        // Better solution
        /*
         * have 3 variables count0,count1,count2 iterate through the array and increace
         * the coun
         * based on the number you have encountered and run seperate loop for 3 diffrent
         * variable
         * append the actual array with the corresponding number
         */

        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                count0++;
            } else if (nums[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }
        for (int i = 0; i <= count0; i++) {
            nums[i] = 0;
        }
        for (int i = count0; i < count1 + count1; i++) {
            nums[i] = 1;
        }
        for (int i = count0 + count1; i < nums.length; i++) {
            nums[i] = 2;
        }
        return nums;
        // Optimal solution Dutch National flag algorithm
        // int low = 0;
        // int mid = 0;
        // int high = nums.length - 1;
        // while (mid < high) {
        // if (nums[mid] == 0) {
        // swap(nums, mid, low);
        // low++;
        // mid++;
        // } else if (nums[mid] == 1) {
        // mid++;
        // } else {
        // swap(nums, mid, high);
        // high--;
        // }
        // }
        // return nums;
    }

    private static int maxSubarraySum(int[] nums) {

        /*
         * Brute force
         * check all the sub array and return the maximum sub array
         */
        // int n = nums.length;
        // int max = Integer.MIN_VALUE;
        // for (int i = 0; i < n; i++) {
        // for (int j = i; j < n; j++) {
        // int sum = 0;
        // for (int k = i; k <= j; k++) {
        // sum += nums[k];
        // }
        // max = Math.max(max, sum);
        // }
        // }
        // return max;

        /*
         * Better solution
         * better solution is eliminating the inner most loop and add sum in the second
         * array
         * so that you will find the max of all the sums
         */

        // Optimal solution
        int n = nums.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max > 0 ? max : 0;

        /*
         * If they want you to print the sub array
         * int n = nums.length;
         * int sum = 0;
         * int max = Integer.MIN_VALUE;
         * int startIndex = -1;
         * int endIndex = -1;
         * int start=-1
         * for (int i = 0; i < n; i++) {
         * if(sum==0)start=i;
         * sum += nums[i];
         * if(sum>max){
         * max=sum;
         * startindex = start ;
         * endindex = i;
         * }
         * if (sum < 0) {
         * sum = 0;
         * }
         * }
         * return max > 0 ? max : 0;
         */
    }

    private static int[] nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverseArray(nums, null, null);
            return nums;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (nums[index] < nums[i]) {
                swap(nums, index, i);
                break;
            }
        }
        reverseArray(nums, index + 1, n - 1);

        return nums;
    }

    private static List<Integer> majorityElements2(int[] nums) {

        // Brute force method
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        // for (int i = 0; i < n; i++) {
        // int count = 0;
        // if (ans.size() == 0 || ans.get(0) != nums[i]) {
        // for (int j = 0; j < n; j++) {
        // if (nums[j] == nums[i]) {
        // count++;
        // }
        // }
        // if (count > (n / 3)) {
        // ans.add(nums[i]);
        // }
        // }
        // if (ans.size() == 2) {
        // break;
        // }
        // }
        // return ans;

        /*
         * Better method
         * use hashing to find the number of times the element occurs and
         * based on the count add the element to the answer array
         */

        // Map<Integer, Integer> hash = new HashMap<>();
        // int minimum = n / 3 + 1;
        // for (int i = 0; i < n; i++) {
        // hash.put(nums[i], hash.getOrDefault(nums[i], 0) + 1);
        // if (hash.get(nums[i]) == minimum) {
        // ans.add(nums[i]);
        // }
        // if (ans.size() == 2) {
        // break;
        // }
        // }
        // return ans;

        /*
         * Optimal approach
         * this optimal approach is derived from the moores voting algoritm we are going
         * to repliate
         * it for 2 elements and make a slight change
         */

        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < n; i++) {
            if (count1 == 0 && el2 != nums[i]) { // additional set to check wheater the el1 is not equal to el2
                count1 = 1;
                el1 = nums[i];
            } else if (count2 == 0 && el1 != nums[i]) {// additional set to check wheater the el1 is not equal to el2
                count2 = 1;
                el2 = nums[i];
            } else if (el1 == nums[i]) {
                count1++;
            } else if (el2 == nums[i]) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        int minimum = n / 3 + 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == el1) {
                count1++;
            } else if (nums[i] == el2) {
                count2++;
            }
        }
        if (count1 >= minimum) {
            ans.add(el1);
        }
        if (count2 >= minimum) {
            ans.add(el2);
        }
        return ans;
    }

    private static int[] findRepeatingMissingNumber(int[] nums) {

        // Brute force
        int n = nums.length;
        int repeating = -1;
        int missing = -1;
        // for (int i = 1; i <= n; i++) {
        // int count = 0;
        // for (int j = 0; j < n; j++) {
        // if (nums[j] == i) {
        // count++;
        // }
        // }
        // if (count == 2) {
        // repeating = i;
        // }
        // if (count == 0) {
        // missing = i;
        // }
        // if (repeating != -1 && missing != -1) {
        // break;
        // }
        // }

        /*
         * Better solution
         * Hashing hash the numbers in the array based on their frequency and iterate
         * through the array to
         * find the missing number and the repeating numbers
         */

        // int[] hash = new int[n+1];

        // for (int i = 0; i < n; i++) {
        // hash[nums[i]]++;
        // }
        // for (int i = 1; i < hash.length; i++) {
        // if (hash[i] == 2) {
        // repeating = i;
        // }
        // if (hash[i] == 0) {
        // missing = i;
        // }
        // }

        /*
         * Optimal approach
         * is to create 2 equation and solve the problem
         */

        int s = 0;
        int sn = 0;
        int s2 = 0;
        int sn2 = 0;
        sn = (n * (n + 1)) / 2;
        sn2 = (n * (n + 1) * ((2 * n) + 1)) / 6;
        for (int i = 0; i < n; i++) {
            s += nums[i];
            s2 += nums[i] * nums[i];
        }
        int val1 = s - sn; // x-y
        int val2 = s2 - sn2;
        val2 = val2 / val1; // (x+y)(x-y)
        /*
         * Calculate X and Y from X + Y and X - Y
         * X = ((X + Y) + (X - Y)) / 2
         * Y = X - (X - Y)
         */
        repeating = (val1 + val2) / 2;
        missing = repeating - val1;

        return new int[] { repeating, missing };

    }

    // private static int merge(int[] arr, int low,int mid,int high){
    // int temp = new int[high+low-1];

    // }

    // private static int mergeSort(int[] arr, int low, int high) {
    // int count = 0;
    // if (low < high) {
    // int mid = low + high / 2;
    // count = mergeSort(arr, low, mid);
    // count = mergeSort(arr, mid + 1, high);

    // }
    // return count;
    // }

    // private static int noofInversion(int[] nums) {
    // int n = nums.length;
    // return mergeSort(nums, 0, n - 1);
    // }

    private static int maxProductInSubarray(int[] nums) {

        // optimal approach
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        // int prefix = 1;
        // int suffix = 1;
        // for (int i = 0; i < n; i++) {
        // if (prefix == 0)
        // prefix = 1;
        // if (suffix == 0)
        // suffix = 1;
        // prefix *= nums[i];
        // suffix *= nums[n - i - 1];
        // ans = Math.max(ans, Math.max(prefix, suffix));
        // }

        /*
         * Brute force is to use nested loop to create the all the possible subarrays
         * and return the max product
         */

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = i; j < n; j++) {
                product *= nums[j];
            }
            ans = Math.max(ans, product);
        }
        return ans;

    }

    private static void mergeTwoArrays(int[] arr1, int[] arr2, int n, int m) {

        // Brute force solution
        /*
         * time complexity O(n+m)+O(n+m) because iteration over 2 arrays to sort it in
         * to the third array
         * and iteration to the length of 2 arrays to arrange them in the first array
         * and the 2nd array
         * space complexity is O(n+m) additional 3rd array
         */
        // int left = 0;
        // int right = 0;
        // int index = 0;
        // int[] arr3 = new int[n + m];
        // while (left < n && right < m) {
        // if (arr1[left] < arr2[right]) {
        // arr3[index] = arr1[left];
        // left++;
        // index++;
        // } else {
        // arr3[index] = arr2[right];
        // right++;
        // index++;
        // }
        // }
        // while (left < n) {
        // arr3[index++] = arr1[left++];
        // }
        // while (right < m) {
        // arr3[index++] = arr2[right++];
        // }

        // for (int i = 0; i < n + m; i++) {
        // if (i < n) {
        // arr1[i] = arr3[i];
        // } else {
        // arr2[i - n] = arr3[i];
        // }
        // }

        /*
         * Optimal approach 1
         */

        int left = n - 1;
        int right = 0;
        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            }
            else{
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println("first array " + Arrays.toString(arr1));
        System.out.println("second array " + Arrays.toString(arr2));
    }

    public static void main(String[] args) {
        // int[] arr = { 0, 1, 2, 4, 5, 6 };
        // System.out.println(Arrays.toString(moveZerosToEnd(arr)));
        // System.out.println("Missing elements " + missingNumber(arr));
        // int[] nums1 = { 1, 2, 2, 3, 5 };
        // int[] nums2 = { 1, 2, 7 };
        // System.out.println("Intersection array :" +
        // Arrays.toString(intersectionOfTwoArrays(nums1, nums2)));
        // int[] nums = { 7, 0, 0, 1, 7, 7, 2, 7, 7 };
        // System.out.println("Majority occuring element " + majorityElement(nums));
        // int[] nums = { 1, 2, 5, 3, 1, 2 };
        // System.out.println(
        // "Leader of the array " + Arrays.toString(nums) + " is :" +
        // Arrays.toString(leadersOfarray(nums)));
        // int[] nums = { 2, 4, 5, -1, -3, -4 };
        // System.out.println("Rearrangement of nums is: " +
        // Arrays.toString(arrangeElements(nums)));
        // int[][] mat = {
        // { 1, 2, 3, 4 },
        // { 5, 6, 7, 8 },
        // { 9, 10, 11, 12 },
        // { 13, 14, 15, 16 }
        // };
        // System.out.println("spiral of matrix " + printSpiralMatrix(mat));
        // System.out.println("4C2 is " + ncr(5, 3));
        // printNthRowPascalTriangle(4);
        // System.out.println("pascal triangle of the 6 rows is
        // "+pascalTriangleOfNrows(6));
        // int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // System.out.println("Rotated Matrix :" +
        // Arrays.toString(rotateMatrix90degree(mat)));
        // int[][] ans = rotateMatrix90degree(mat);
        // for (int i = 0; i < ans.length; i++) {
        // System.out.println(Arrays.toString(ans[i]));
        // }
        // int[] arr = { 1, 6, 2, 10, 3 };
        // int target = 7;
        // System.out.println("Indexes are : " + Arrays.toString(twoSum(arr, target)));
        // int[] nums = { 2, -2, 0, 3, -3, 5 };
        // { -3,-2, 0, 2, 3, 5 }
        // System.out.println(triplesSumZero(nums));
        // int[] nums = { 1, 0, 2, 1, 0 };
        // System.out.println("sorted arrays : " + Arrays.toString(sort012(nums)));
        // int[] nums = { 3, 2, 1 };
        // System.out.println("Next Permutation is " +
        // Arrays.toString(nextPermutation(nums)));
        // int[] nums = { 4, 5, 3, 7, 1, 2 };
        // System.out.println("repeating and missing numbers " +
        // Arrays.toString(findRepeatingMissingNumber(nums)));
        // System.out.println("max product of the sub array " +
        // maxProductInSubarray(nums));
        int[] nums1 = { -5, -2, 4, 5 };
        int[] nums2 = { -3, 1, 8 };
        mergeTwoArrays(nums1, nums2, nums1.length, nums2.length);
    }
}
