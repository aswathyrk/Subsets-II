public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       List<List<Integer>> result= new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return result;
        int n=nums.length;
        Arrays.sort(nums);
        dfs(nums,n,0,result, new ArrayList<Integer>());
        result.add(new ArrayList<Integer>());
        return result;
    }
    
    public void dfs(int[] nums,int n,int startIndex,List<List<Integer>> result,List<Integer> list){
        
        if(startIndex>=n){
            return;
        }
        int prev=Integer.MIN_VALUE;
        for(int i=startIndex;i<n;i++){
           if(nums[i]==prev){continue;}
           list.add(nums[i]);
           result.add(new ArrayList<Integer>(list));
           dfs(nums,n,i+1,result,list);
           list.remove(list.size()-1);
           prev=nums[i];
        } 
    }
}