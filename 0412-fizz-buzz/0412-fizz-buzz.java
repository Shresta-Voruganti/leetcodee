class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ss = new ArrayList<>();
        for(int i=1; i<=n; i++)
        {
            if(i%15==0)
            {
                ss.add("FizzBuzz");
            }
            else if(i%3==0)
            {
                ss.add("Fizz");
            }
            else if(i%5==0)
            {
                ss.add("Buzz");
            }
            else
            {
                ss.add(String.valueOf(i));
            }
        }
        return ss;
    }
}