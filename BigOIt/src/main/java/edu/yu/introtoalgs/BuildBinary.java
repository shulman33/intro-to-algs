package edu.yu.introtoalgs;

import java.util.ArrayList;
import java.util.List;

public class BuildBinary extends BigOMeasurable {
    private Node root;
    static class Node {
        private int value;
        private Node left;
        private Node right;
        Node (int value) {
            this.value = value;
            this.right = null;
            this.left = null;
        }
    }

    private int start = 0;
    private String treeInStringRepresentation;

    public BuildBinary() {

    }

    @Override
    public void setup(final int n) {
        this.treeInStringRepresentation = buildStringTree(n);

    }
    @Override
    public void execute() {
        if (!isValid(treeInStringRepresentation) || !inRange(treeInStringRepresentation)) {
            throw new IllegalArgumentException("null tree");
        }
        Node root = buildTree(treeInStringRepresentation);
    }

    private Node buildTree(String treeInStringRepresentation) {
        if (start >= treeInStringRepresentation.length()) {
            return null;
        }
        int num = 0;
        while (start < treeInStringRepresentation.length() && Character.isDigit(treeInStringRepresentation.charAt(start))) {
            int digit = Character.getNumericValue(treeInStringRepresentation.charAt(start));
            num = num * 10 + digit;
            start++;
        }

        Node node = new Node(num);

        if (start >= treeInStringRepresentation.length()) {
            return node;
        }

        if (start < treeInStringRepresentation.length() && treeInStringRepresentation.charAt(start) == '(') {
            start++;
            node.left = buildTree(treeInStringRepresentation);
        }

        if (start < treeInStringRepresentation.length() && treeInStringRepresentation.charAt(start) == ')') {
            start++;
            return node;
        }

        if (start < treeInStringRepresentation.length() && treeInStringRepresentation.charAt(start) == '(') {
            start++;
            node.right = buildTree(treeInStringRepresentation);
        }

        if (start < treeInStringRepresentation.length() && treeInStringRepresentation.charAt(start) == ')') {
            start++;
            return node;
        }
        return node;
    }
    private int height(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (leftHeight > rightHeight) {
            return (leftHeight + 1);
        } else {
            return (rightHeight + 1);
        }
    }

    private List<Integer> addCurrentLevel(Node root, int level) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> currentLevel = new ArrayList<>();
        if (level == 1) {
            currentLevel.add(root.value);
        } else if (level > 1) {
            currentLevel.addAll(addCurrentLevel(root.left, level - 1));
            currentLevel.addAll(addCurrentLevel(root.right, level - 1));
        }
        return currentLevel;
    }

    private List<List<Integer>> addAllLists(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        int height = height(root);
        for (int i = 1; i <= height; i++) {
            result.add(addCurrentLevel(root, i));
        }
        return result;
    }

    private boolean isValid(String treeInStringRepresentation) {
        if (treeInStringRepresentation == null) {
            return false;
        }
        if(!treeInStringRepresentation.isEmpty()) {
            // Checks if the first character is an integer.
            if (!Character.isDigit(treeInStringRepresentation.charAt(0))) {
                return false;
            }
        }

        int openParens = 0;
        int closedParens = 0;
        for (int i = 0; i < treeInStringRepresentation.length(); i++) {
            if (treeInStringRepresentation.charAt(i) == '(') {
                openParens++;
            } else if (treeInStringRepresentation.charAt(i) == ')') {
                closedParens++;
            }
        }
        return openParens == closedParens;
    }

    private boolean inRange(String str){
        // given str = "1(2(4)(5))(3(6(8)(9))(7))"

        // "1 2 4) 5)) 3 6 8) 9)) 7))"
        String noLeftParen = str.replace("(", " ");
        // "1 2 4  5   3 6 8  9   7  "
        String noParens = noLeftParen.replace(")", " ");
        // [1, 2, 4, "", 5, "", 3, 6, 8, "", 9, "", 7, ""]
        String[] strArr = noParens.split(" ");
        for (String s : strArr) {
            if (s.isEmpty()) {
                continue;
            }
            try {
                int num = Integer.parseInt(s);
                if (num < 0 || num > 9) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    // a valid string tree representation is 1(8(3)(4))(2(6)(7))
    // Create a function that takes in a number n and returns a string tree representation of a binary tree
    private String buildStringTree(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be greater than 0");
        }
        if (n == 1) {
            return "1";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        for (int i = 2; i <= n; i++) {
            sb.append("(");
            sb.append(i);
            sb.append("()");
            sb.append(")");
        }
        return sb.toString();
    }


}
