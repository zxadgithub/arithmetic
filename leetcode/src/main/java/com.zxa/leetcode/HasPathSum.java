package com.zxa.leetcode;

public class HasPathSum {

	/**
	 * 树的问题递归root.left||root.right
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null){
			return false;
		}
		if(root.left == null && root.right == null){
			return sum - root.val == 0;
		}

		return hasPathSum(root.left, sum - root.val)
				|| hasPathSum(root.right, sum - root.val
		);

	}
}



class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public int getVal() {
		return val;
	}

	public TreeNode getLeft() {
		return left;
	}

	public TreeNode getRight() {
		return right;
	}
}

