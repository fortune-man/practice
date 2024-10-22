import java.lang.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 // 이진 트리 root의 하위 경로를 형성하는지 boolean값을 return
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        // 현재 트리 노드와 리스트 헤드가 일치하는 경우 하위 경로 형성을 체크
        if (checkPath(head, root)) {
            // 확인되면 true를 return
            return true;
        }
        // 트리의 왼쪽과 오른쪽 자식 노드를 재귀적으로 탐색
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean checkPath(ListNode head, TreeNode root) {
        // head가 null이면 리스트의 끝까지 탐색되었으므로 하위 경로 형성 확인 ok
        if (head == null) return true;
        // root가 null이거나 값이 일치하지 않으면 경로 불일치
        if (root == null || head.val != root.val) return false;
        // head의 다음 노드와 트리의 왼쪽/오른쪽 자식 노드를 재귀적으로 탐색
        return checkPath(head.next, root.left) || checkPath(head.next, root.right);
    }
}
