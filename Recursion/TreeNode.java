package com.yssr.dsa;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class printNodesAtK{
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> parent = new HashMap();
        dfs(parent, root, null);

        Queue<TreeNode> queue = new LinkedList();
        queue.add(null);
        queue.add(target);

        Set<TreeNode> seen = new HashSet();
        seen.add(target);
        seen.add(null);

        int dist = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (dist == K) {
                    List<Integer> ans = new ArrayList();
                    for (TreeNode n: queue) ans.add(n.val);
                    return ans;
                }
                queue.offer(null);
                dist++;
            } else {
                if (!seen.contains(node.left)) {
                    seen.add(node.left);
                    queue.offer(node.left);
                }
                if (!seen.contains(node.right)) {
                    seen.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode par = parent.get(node);
                if (!seen.contains(par)) {
                    seen.add(par);
                    queue.offer(par);
                }
            }
        }

        return new ArrayList<Integer>();
    }

    public static void dfs(Map<TreeNode, TreeNode> parent, TreeNode node, TreeNode par) {
        if (node != null) {
            parent.put(node, par);
            dfs(parent, node.left, node);
            dfs(parent, node.right, node);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nodes = sc.nextLine().split(" ");
        int targetVal = sc.nextInt();
        int K = sc.nextInt();

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.add(root);

        int i = 1;
        while(i < nodes.length && !queue.isEmpty()) {
            TreeNode node = queue.poll();

            if(node == null) continue;

            if(!nodes[i].equals("-1")) {
                node.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(node.left);
            } else {
                queue.add(null);
            }
            i++;

            if(i < nodes.length && !nodes[i].equals("-1")) {
                node.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(node.right);
            } else {
                queue.add(null);
            }
            i++;
        }

        TreeNode target = findTarget(root, targetVal);
        List<Integer> res = distanceK(root, target, K);
        for(Integer val : res) {
            System.out.print(val + " ");
        }
    }

    public static TreeNode findTarget(TreeNode root, int targetVal) {
        if(root == null) {
            return null;
        }
        if(root.val == targetVal) {
            return root;
        }
        TreeNode left = findTarget(root.left, targetVal);
        TreeNode right = findTarget(root.right, targetVal);
        if(left != null) {
            return left;
        }
        return right;
    }
}
