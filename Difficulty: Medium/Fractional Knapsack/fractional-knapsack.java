//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Item
{
    int value;
    int weight;
    Item(int x, int y)
    {
        this.value = x;
        this.weight = y;
    }
}

class itemComparator implements Comparator<Item>
{
    public int compare(Item a, Item b)
    {
        double r1 = (double) a.value / (double) a.weight;
        double r2 = (double) b.value / (double) b.weight;
        if(r1 > r2)
        {
            return -1;
        }
        else if(r1 < r2)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}

class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> values, List<Integer> weights, int w) {
        // code here
        int n = values.size();
        Item[] arr = new Item[n];
        for(int i=0; i<n; i++)
        {
            arr[i] = new Item(values.get(i), weights.get(i));
        }
        Arrays.sort(arr, new itemComparator());
        double finalval = 0.0;
        // double curweight = 0.0;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i].weight <= w)
            {
                finalval += arr[i].value;
                w = w-arr[i].weight;
            }
            else
            {
                finalval += (double) arr[i].value / (double) arr[i].weight * w;
                break;
            }
        }
        return finalval;
    }
}