//Q1: Merge Sorted Array
//You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
// Merge nums1 and nums2 into a single array sorted in non-decreasing order.
// The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

//Brute Force
 
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mergedArray = new int[m + n];
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                mergedArray[k] = nums1[i];
                i++;
            } else {
                mergedArray[k] = nums2[j];
                j++;
            }
            k++;
        }
        
        while (i < m) {
            mergedArray[k] = nums1[i];
            i++;
            k++;
        }
        
        while (j < n) {
            mergedArray[k] = nums2[j];
            j++;
            k++;
        }
        
        for (int l = 0; l < m + n; l++) {
            nums1[l] = mergedArray[l];
        }
    }
}

// Optimal Solution

class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}

