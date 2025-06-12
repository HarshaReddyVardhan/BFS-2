// Time Complexity (TC):
// O(n) – You visit each node once in the binary tree.

// Space Complexity (SC):
// O(h) – Where h is the height of the tree, due to the recursion stack in DFS.
// In the worst case (skewed tree), this can go up to O(n).

// Approach (in 3 sentences):
// use DFS (depth-first search) to traverse the tree level by level.
// At each level, first visit the right child, and only add the node's value to the result if it’s the first node seen at that level (i.e., res.size() == level).
// This way, the first node visited on each level from the right side is stored, giving the right-side view.

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int> result;
        if(!root) return result; 
        helper(root,result,0);
        return result;
    }

    void helper(TreeNode* root, vector<int> &res, int level){
        if(!root) return;
        // logic
        if(res.size() == level)
            res.emplace_back(root->val);
        helper(root->right, res, level+1);
        helper(root->left, res, level+1);
    }
};
