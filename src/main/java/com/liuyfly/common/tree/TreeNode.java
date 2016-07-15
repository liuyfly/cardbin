package com.liuyfly.common.tree;

public class TreeNode {
    private int        key;
    private Object     value;
    private TreeNode[] nodes = new TreeNode[10];

    public TreeNode(int key) {
        this(key, null);
    }

    public TreeNode(int key, Object value) {
        this.key = key;
        this.value = value;
    }

    public TreeNode setChildTreeNode(int key, Object value) {

        synchronized (this) {
            TreeNode treeNode = nodes[key];
            if (treeNode == null) {
                nodes[key] = new TreeNode(key);
            }
            getChildTreeNode(key).setValue(value);
        }

        return getChildTreeNode(key);

    }

    public TreeNode setChildTreeNode(int key) {
        synchronized (this) {
            TreeNode treeNode = nodes[key];
            if (treeNode == null) {
                nodes[key] = new TreeNode(key);
            }
        }

        return getChildTreeNode(key);
    }

    public TreeNode getChildTreeNode(int key) {
        return nodes[key];
    }

    public int getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public void removeValue() {
        this.value = null;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String toString() {

        return "(" + key + " , " + value + " )";
    }

}
