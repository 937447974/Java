/**
 * <p>Title: TreeNode</p>
 * <p>Description: </p>
 * <p>Create Time: 2018/1/31 下午2:47</p>
 * <p>Copyright: © 2018年 java. All rights reserved.</p>
 *
 * @author 阳君
 * @version 1.0
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }

}