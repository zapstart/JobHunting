/*#################################### Maximum Depth of Binary Tree ##################
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node
down to the farthest leaf node.
####################################################################################*/

// ###########################################################################
// 思路分析：
// 基本的 BST 操作. 
// 每个结点的 depth = max(dep(leftNode), dep(rightNode)) + 1
//
// 易错点:
//
// 难点:
//
// 复杂度分析:
// 时间: O(n)
// 空间: O(1)
// ###########################################################################
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        int lmax, rmax;

        if (root == null) {
            return 0;
        }
        else {
            lmax = maxDepth(root.left);
            rmax = maxDepth(root.right);
            return Math.max(lmax, rmax) + 1;
        }
    }
}
