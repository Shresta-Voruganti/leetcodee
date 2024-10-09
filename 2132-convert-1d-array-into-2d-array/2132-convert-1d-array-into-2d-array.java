class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) 
    {
        if(m*n==original.length)
        {
            int resultArray[][] = new int[m][n];
            int index = 0;
            for(int i=0;i<=m-1;i++)
            {
                for(int j=0;j<=n-1;j++)
                {
                    resultArray[i][j] = original[index];
                    index++;
                }
            }
            return resultArray;
        }
        else
        {
            return new int[0][0];
        }
    }
}