//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            int A = obj.maxSum(a);
            System.out.println(A);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int maxSum(int[] arr) {
        // Your code here
        int n = arr.length;
        if(n == 1) {
            return 0;
        }

        int sum = 0;
        int currprod = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            currprod += (i * arr[i]);
        }

        int maxprod = currprod;
        for(int i = 1; i < n; i++) {
            currprod = currprod + sum - (n) * arr[n - i];
            maxprod = Math.max(maxprod, currprod);
        }

        return maxprod;
    }
}
