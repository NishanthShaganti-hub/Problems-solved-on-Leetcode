class Solution {
    public List<List<Integer>> combine(int n, int k) {
         List<List<Integer>> list=new ArrayList<>();
         dfs(n,k,1,list,new ArrayList<>());
         return list;
    }
    public void dfs(int n,int k,int start,List<List<Integer>> list , ArrayList<Integer>sl)
    {
        if(sl.size()==k)
        {
            list.add(new ArrayList<>(sl));
            return;
        }
        for (int i=start;i<=n;i++)
        {
            sl.add(i);
            dfs(n,k,i+1,list,sl);
            sl.remove(sl.size()-1);
        }
    }
}