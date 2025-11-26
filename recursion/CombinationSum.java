class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();        // final answer list
        List<Integer> ans = new ArrayList<>();              // current combination being built
        int n = candidates.length;
        helper(candidates, n, res, ans, target, 0);         // start recursion from index 0
        return res;
    }

    private void helper(int[] c, int n, List<List<Integer>> res,
                        List<Integer> ans, int target, int ind) {

        // If we have reached beyond the last index
        if (ind >= n) {
            // Only add the combination if target becomes 0 exactly
            if (target == 0) {
                res.add(new ArrayList<>(ans));              // add a copy of current combination
                return;
            }
            return;                                         // otherwise, just stop
        }

        // If target becomes exactly 0 in the middle (not necessarily at the end)
        if (target == 0) {
            res.add(new ArrayList<>(ans));                  // store valid combination
            return;
        }

        // If target becomes negative → invalid path
        if (target < 0) {
            target += c[ind];                               // undo reduction (not required logically)
            return;                                         // prune this branch
        }

        // ----------- CHOICE 1: Pick current element -----------
        ans.add(c[ind]);                                    // include c[ind] in current list
        helper(c, n, res, ans, target - c[ind], ind);       // stay on same index (can reuse)
        ans.remove(ans.size() - 1);                         // backtrack

        // ----------- CHOICE 2: Skip current element -----------
        helper(c, n, res, ans, target, ind + 1);            // move to next index
    }
}
