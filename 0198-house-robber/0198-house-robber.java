class Solution {
    public int rob(int[] nums) {
     int rob=0;
     int not=0;
     for(int i=0;i<nums.length;i++){
        int newrob=not+nums[i];
        int newnotrob=Math.max(not,rob);
        rob=newrob;
        not=newnotrob;
     }
     return Math.max(rob,not);
    }
}