import java.util.Stack;
import java.util.Arrays;

public class bruteforce {
     public static int largestRectangleAreaMethod1(int[] heights) {
           int n = heights.length;
           if (n == 0) return 0;
           int[] pse = previousSmallerElementIndices(heights);                                // Find Previous Smaller Element indices
           int[] nse = nextSmallerElementIndices(heights);                                       // Find Next Smaller Element indices
           int maxArea = 0;                                                                                                // Calculate maximum area
           for (int i = 0; i < n; i++) {
                int width = nse[i] - pse[i] - 1;
                int area = heights[i] * width;
                maxArea = Math.max(maxArea, area);
            }
     return maxArea;
    }
    private static int[] previousSmallerElementIndices(int[] heights) {          //For each element, find index of previous smaller element
       int n = heights.length;
       int[] pse = new int[n];
       Stack<Integer> stack = new Stack<>();
       for (int i = 0; i < n; i++) {
                            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {            // Remove indices with values >= current height
                  stack.pop();  
               }
               pse[i] = stack.isEmpty() ? -1 : stack.peek();                                                      // PSE index (-1 if no smaller element to left)
               stack.push(i);
            }
       return pse;
     }
     private static int[] nextSmallerElementIndices(int[] heights) {                          //For each element, find index of next smaller element
           int n = heights.length;
           int[] nse = new int[n];
           Stack<Integer> stack = new Stack<>();
           Arrays.fill(nse, n);                                                                                                      // Initialize with n (boundary condition)
           for (int i = n - 1; i >= 0; i--) {                                                                                   // Traverse right to left 
                 while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {       // Remove indices with values >= current height
                           stack.pop();
                     }
                 nse[i] = stack.isEmpty() ? n : stack.peek();                                                  // NSE index (n if no smaller element to right)
                 stack.push(i);
           }
       return nse;
    }
}