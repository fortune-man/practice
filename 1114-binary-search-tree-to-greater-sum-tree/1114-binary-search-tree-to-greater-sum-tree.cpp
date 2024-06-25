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
    int sum = 0;
    void Traversal(TreeNode* root) {
        if(root->right) Traversal(root->right);
        sum += root->val;
        root->val = sum;
        if(root->left) Traversal(root->left);
    }
    TreeNode* bstToGst(TreeNode* root) {
        // 그냥 큰 값부터 순차적으로 이동하면서 값 바꿔주면 되는거 아닌가
        // 순차적으로 이동하는게 어려운건가.
        // dfs 하면 어떨까
        Traversal(root);
        return root;
    }
};