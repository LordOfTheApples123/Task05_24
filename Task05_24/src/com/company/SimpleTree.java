package com.company;

import java.util.Random;

public class SimpleTree {
    private static class TreeItem{
        int value;
        TreeItem left;
        TreeItem right;

        public TreeItem(int value, TreeItem left, TreeItem right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public TreeItem(int value) {
            this(value, null, null);
        }

        public int getValue() {
            return value;
        }

        public TreeItem getLeft() {
            return left;
        }

        public TreeItem getRight() {
            return right;
        }
    }

    public SimpleTree(TreeItem root) {
        this.root = root;
    }

    public SimpleTree(){
        this(null);
    }

    private TreeItem root = null;

    public TreeItem getRoot() {
        return root;
    }

    public void printOutTree(){
        printOutTree(root, "");
    }

    private void printOutTree(TreeItem node, String spacing){
        System.out.println(spacing + node.value);
        spacing += "    ";
        if(node.left != null) {
            printOutTree(node.left, spacing);
        }
        if(node.right != null) {
            printOutTree(node.right, spacing);
        }
    }




    public static SimpleTree createRandomTree(int minValue, int maxValue, double leftP, double rightP, int maxHeight){
        TreeItem root = createRandomNode(minValue, maxValue, leftP, rightP, maxHeight, 0);
        return new SimpleTree(root);
    }

    private static TreeItem createRandomNode(int minValue, int maxValue, double leftP, double rightP, int maxHeight, int currHeight){
        if(currHeight == maxHeight){
            return null;
        }
        TreeItem node = new TreeItem(rndInt(minValue, maxValue));
        if(nodeChance(leftP)){
             node.left = createRandomNode(minValue, maxValue, leftP, rightP, maxHeight, currHeight + 1);
        }
        if(nodeChance(rightP)){
            node.right = createRandomNode(minValue, maxValue, leftP, rightP, maxHeight, currHeight + 1);
        }
        return node;
    }

    private static int rndInt(int min, int max){
        Random rnd = new Random();
        return rnd.nextInt(max - min + 1) + min;
    }

    private static boolean nodeChance(double p){
        Random rnd = new Random();
        return rnd.nextDouble() <= p;
    }
}
