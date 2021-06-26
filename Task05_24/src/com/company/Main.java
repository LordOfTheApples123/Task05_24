package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите данные (minValue, maxValue, leftP, rightP, maxHeight");
        SimpleTree tree = SimpleTree.createRandomTree(in.nextInt(), in.nextInt(), in.nextDouble(), in.nextDouble(), in.nextInt());
        tree.printOutTree();
    }
}
