class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(0,new ArrayList<>(),nums);
            return ans;
        }
    public  void backtracking(int index,List<Integer>subset,int []nums){
        if(index==nums.length){
            ans.add(new ArrayList<>(subset));
            return ;
        }
        subset.add(nums[index]);
        backtracking(index+1,subset,nums);
        subset.remove(subset.size()-1);
        backtracking(index+1,subset,nums);
    }
    }
