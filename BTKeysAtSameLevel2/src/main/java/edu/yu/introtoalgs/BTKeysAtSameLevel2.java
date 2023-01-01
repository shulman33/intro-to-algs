package edu.yu.introtoalgs;

/** Defines the API for the BTKeysAtSameLevel assignment: see the requirements
 * document for more information.
 *
 * Students MAY NOT change the constructor signature.  My test code will only
 * invoke the API defined below.
 *
 * @author Avraham Leff
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTKeysAtSameLevel2 {
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

  /** Constructor
   */
  public BTKeysAtSameLevel2() {}

  /** Given a String representation of a binary tree whose keys are Integers,
   * computes a List whose elements are List of keys at the same level (or
   * depth) from the root.  The top-level List is ordered by increasing
   * distance from the root so that the first List element consists of the
   * root's key, followed by the keys of all the root's immediate children,
   * etc.  At a given level, the List is ordered from left to right.  See the
   * requirements doc for an example.
   *
   * The String representation of the binary tree is defined as follows.  Keys
   * consist of a single integer value, from 0 to 9.  The string consists only
   * of parentheses and single digit integers: it must begin with an integer
   * (the value of the root node) followed by zero, one or two pairs of
   * parentheses. A pair of parentheses represents a child binary tree with
   * (recursively) the same structure. If a given node only has one child, that
   * child will be the left child node of the parent.
   * 
   * Note: the "empty" tree is represented by the empty string, and this method
   * should therefore return an empty List.
   *
   * @param treeInStringRepresentation a binary tree represented in the
   * notation defined above.
   * @return a List whose elements are Lists of the tree's (integer) key
   * values, ordered in increasing distance from the root.  Each List element
   * contains the keys at a given level, ordered from left to right.
   * @throws IllegalArgumentException if the String is null, or doesn't
   * correspond to a valid String representation of a binary tree as defined
   * above.
   */
  public List<List<Integer>> compute(final String treeInStringRepresentation) {
    // Returns an empty list if the tree is empty.
    if (treeInStringRepresentation != null && treeInStringRepresentation.isEmpty()) {
      return new ArrayList<>();
    }
    // throws IllegalArgumentException if the String is null, or doesn't correspond to a valid String representation of a binary tree.
    if (!isValid(treeInStringRepresentation) || !inRange(treeInStringRepresentation)) {
      throw new IllegalArgumentException("null tree");
    }
    Node root = buildTree(treeInStringRepresentation);

    return addLevelOrder(root);
  }
  private Node buildTree (String s){

    int multiplier = 1, num = 0;
    Node curr, root = null;
    Stack<Node> stack = new Stack<>();
    char c;

    for (int i = 0; i < s.length(); i++) {
      c = s.charAt(i);
      if (isDigit(c)) {
        // adds the current digit as the lowest digit of a number
        num = 10 * num + (c - '0');
        if (i == s.length() - 1 || !isDigit(s.charAt(i + 1))) {
          // if this is the last char or next char is not a digit
          curr = new Node(num * multiplier);

          // checks if there is a parent node
          // if so, determines whether adding curr to its left or right
          addCurrToParent(curr, stack);

          // add current node to stack
          stack.push(curr);

          // set root
          if (root == null) root = curr;

          // reset
          num = 0;
        }
      } else if (c == ')') {
        // go up one level
        stack.pop();
      }
    }
    return root;
  }

  //checks if there is a parent node
  private boolean hasParent(Stack<Node> stack) {
    return !stack.isEmpty();
  }

  // if there is a parent node, determines whether adding curr to its left or right
  private void addCurrToParent(Node curr, Stack<Node> stack) {
    if (!hasParent(stack)) return;
    Node parent = stack.peek();
    if (parent.left == null) { // always add to left first
      parent.left = curr;
    } else {
      parent.right = curr;
    }
  }

  private boolean isDigit(char c) {
    return c <= '9' && c >= '0';
  }
  private List<List<Integer>> addLevelOrder(Node root){
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    List<Node> queue = new ArrayList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<Integer> currentLevel = new ArrayList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node current = queue.remove(0);
        currentLevel.add(current.value);
        if (current.left != null) {
          queue.add(current.left);
        }
        if (current.right != null) {
          queue.add(current.right);
        }
      }
      result.add(currentLevel);
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


}
