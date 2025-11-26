// User function Template for Java

class Solution {
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
       
        // Start checking from index 0 with target K
        return helper(N,arr,K,0);
        
    }
    private static boolean helper(int n, int[] arr, int target,int ind){

        // If index crossed array length → no more elements left
        if(ind>=n){
            // If target is exactly 0 → subsequence found
            if(target==0)return true;
            // Otherwise → no valid subsequence
            return false;
        }

        // If target becomes negative → cannot reach 0
        if(target<0)return false;

        // If target becomes 0 → valid subsequence formed
        if(target==0)return true;
        
        // Take current element: reduce target by arr[ind] and move forward
        // OR skip current element: keep target same and move forward
        return helper(n,arr,target-arr[ind],ind+1) || helper(n,arr,target,ind+1);

    }
}
