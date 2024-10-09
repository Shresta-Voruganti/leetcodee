class Solution {
    public boolean isValid(String s) 
    {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray())
        {
            if(ch=='(' || ch=='{' || ch=='[')
            {
                st.push(ch);
            }
            else //other parenthesis symbols - ),},]
            {
                if(st.isEmpty()) //despite having parenthesis symbols in string, stack is empty, hence there is no chance of popping elements, so invalid parenthesis
                {
                    return false;
                }
                char pee = st.peek();
                if((ch==')' && pee=='(') || (ch=='}' && pee=='{') || (ch==']' && pee=='['))
                { 
                    st.pop();
                }
                else //mismatched parenthesis - eg., [)
                    //parenthesis symbol mismatch - opening and closing parenthesis mismatch
                {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
