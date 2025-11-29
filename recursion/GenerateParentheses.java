class Solution {
    public List<String> generateParenthesis(int n) {

        // Result list to store all valid combinations
        List<String> ans = new ArrayList<>();

        // StringBuilder used to build the string efficiently
        StringBuilder s = new StringBuilder();

        // ocur = number of '(' placed so far
        // ccur = number of ')' placed so far
        helper(n, ans, 0, 0, s);

        return ans;
    }

    private void helper(int n, List<String> ans, int ocur, int ccur, StringBuilder s) {

        // Base condition:
        // If we have used all '(' and all ')', we formed a valid string
        if (ocur == n && ccur == n) {
            ans.add(s.toString());
            return;
        }

        // OPTION 1: Add '(' if possible
        // We can only add '(' when we haven't used all n '(' yet
        if (ocur < n) {
            s.append('(');                       // choose '('
            helper(n, ans, ocur + 1, ccur, s);   // explore
            s.deleteCharAt(s.length() - 1);      // undo choice (backtracking)
        }

        // OPTION 2: Add ')' if valid
        // We can add ')' ONLY when count of ')' is less than '('
        // This ensures prefix is always valid (never more ')' than '(')
        if (ccur < ocur) {
            s.append(')');                       // choose ')'
            helper(n, ans, ocur, ccur + 1, s);   // explore
            s.deleteCharAt(s.length() - 1);      // undo choice (backtracking)
        }
    }
}
