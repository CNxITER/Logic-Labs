import java.util.Stack;

public class optimized {
    public int largestRectangleArea(int[] heights) {
         Stack<Integer> stack = new Stack<>();
         stack.push(-1);                                                                                                                     // Brilliant sentinel to handle left boundaries
         int maxArea = 0;                                                                                                                 // Main processing loop
        for (int i = 0; i < heights.length; i++) {                                                                            // Pop and process all bars taller than current bar
               while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                         int height = heights[stack.pop()];                                                               // Bar being processed
                         int width = i - stack.peek() - 1;                                                                     // NSE - PSE - 1
                         maxArea = Math.max(maxArea, height * width);
                    }
           stack.push(i);
       }
       while (stack.peek() != -1) {                                                                                 // Process remaining bars (those extending to array end)
              int height = heights[stack.pop()];
              int width = heights.length - stack.peek() - 1;                                         // NSE = n
              maxArea = Math.max(maxArea, height * width);
         }
         return maxArea;
     }
    }