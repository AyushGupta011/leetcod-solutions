class Solution {
    private void solve(int n,int open,int close,StringBuilder sb,List<String> result){
        if(sb.length()==n * 2){
            result.add(sb.toString());
            return;
        }

       if(open<n){
         sb.append("(");
        solve(n,open+1,close,sb,result);
        sb.deleteCharAt(sb.length()-1);
       }

        if(close<open){
            sb.append(")");
        solve(n,open,close+1,sb,result);