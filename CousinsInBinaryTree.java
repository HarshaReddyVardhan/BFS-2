// Time Complexity (TC):
// O(n) – You visit each node once in the worst case, where n is the number of nodes in the tree.

// Space Complexity (SC):
// O(w) – Where w is the maximum width of the tree (worst case: number of nodes at the widest level), due to the queue used in level-order traversal.
// In worst case (balanced tree), it could be up to O(n/2) → simplified to O(n).

// Approach (in 3 sentences):
// perform a BFS (level-order traversal) of the binary tree, checking each level independently.
// During traversal, look for both x and y, and ensure they are not siblings (i.e., not children of the same parent).
// If both x and y are found on the same level but not as siblings, they are cousins — otherwise, return false.

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        boolean findX = false;
        boolean findY = false;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i< size;i++){
                TreeNode curr = q.poll();
                if(curr == null) continue;
                if(curr.left != null && curr.right != null 
                    && curr.left.val == x && curr.right.val == y) return false;
                if(curr.left != null && curr.right != null 
                    && curr.left.val == y && curr.right.val == x) return false;

                if(curr.left != null) q.add(curr.left);                    
                if(curr.right != null) q.add(curr.right);
                if(curr.val == x) findX = true;
                if(curr.val == y) findY = true;
            }
            if(findX != findY) return false;
        }
        return true;
    }
}
