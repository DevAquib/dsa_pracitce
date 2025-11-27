class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int n = candidates.length;

        // Sort to ensure duplicates are adjacent → required for skipping duplicates
        Arrays.sort(candidates);

        helper(candidates, n, target, res, ans, 0);
        return res;
    }

    private void helper(int[] c, int n, int target,
                        List<List<Integer>> res, List<Integer> ans, int ind) {

        // If target becomes 0 → a valid combination is formed
        if (target == 0) {
            res.add(new ArrayList<>(ans)); // store the current combination
            return;
        }

        // If index goes out of bounds OR target becomes negative → stop exploring
        if (ind >= n || target < 0) {
            return;
        }

        // ----------------------------
        // 1️⃣ PICK the current element
        // ----------------------------
        ans.add(c[ind]);                     // choose element c[ind]
        helper(c, n, target - c[ind], res, ans, ind + 1);
        ans.remove(ans.size() - 1);          // backtrack: undo the pick

        // ---------------------------------------------------------------
        // 2️⃣ SKIP the current element AND skip all duplicates of it
        //
        // Why?  
        // If we do NOT skip duplicates here, we will generate duplicate
        // combinations like:
        //   [1(from index 0), 2(index2)]
        //   [1(from index 1), 2(index2)]
        //
        // Since both 1s have same value → skipping consecutive duplicates
        // ensures we only explore one "version" of that choice.
        // ---------------------------------------------------------------
        while (ind + 1 < n && c[ind] == c[ind + 1]) {
            ind++;   // skip over duplicates of the same number
        }

        // Move to the next distinct element (skip action)
        helper(c, n, target, res, ans, ind + 1);
    }
}
