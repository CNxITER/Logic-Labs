/*
LeetCode Problem: Majority Element II
-------------------------------------
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

---------------------------------------------------------
Brute Force Approach:
- For each element, count its occurrences by scanning the array.
- If the count is greater than n/3 and the element is not already in the result, add it.
- Time Complexity: O(n^2)  (nested loops)
- Space Complexity: O(1)   (only storing results)

---------------------------------------------------------
Optimal Approach (Boyer-Moore Voting Algorithm):
- At most 2 elements can appear more than n/3 times.
- Use two counters and two candidates to track potential answers.
- First pass: find potential candidates.
- Second pass: verify their counts.
- Time Complexity: O(n)
- Space Complexity: O(1)
*/

import java.util.*;

public class medium {

    // Brute Force Solution
    public static List<Integer> majorityElementBruteForce(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;

            // Count occurrences of nums[i]
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }

            // If nums[i] is majority and not already in result
            if (count > n / 3 && !result.contains(nums[i])) {
                result.add(nums[i]);
            }
        }
        return result;
    }

    // Optimal Solution (Boyer-Moore Voting Algorithm)
    public static List<Integer> majorityElementOptimal(int[] nums) {
        int cand1 = 0, cand2 = 0, cnt1 = 0, cnt2 = 0;

        // First pass: find candidates
        for (int num : nums) {
            if (num == cand1) {
                cnt1++;
            } else if (num == cand2) {
                cnt2++;
            } else if (cnt1 == 0) {
                cand1 = num;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                cand2 = num;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        // Second pass: verify candidates
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == cand1) cnt1++;
            else if (num == cand2) cnt2++;
        }

        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        if (cnt1 > n / 3) result.add(cand1);
        if (cnt2 > n / 3) result.add(cand2);

        return result;
    }

    // Main method to test
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 2, 2, 1, 1};

        System.out.println("Brute Force Result: " + majorityElementBruteForce(nums));
        System.out.println("Optimal Result: " + majorityElementOptimal(nums));
    }
}
