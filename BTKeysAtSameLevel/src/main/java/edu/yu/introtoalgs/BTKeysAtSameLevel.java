package edu.yu.introtoalgs;

/** Defines the API for the BTKeysAtSameLevel assignment: see the requirements
 * document for more information.
 *
 * Students MAY NOT change the constructor signature.  My test code will only
 * invoke the API defined below.
 *
 * @author Avraham Leff
 */

import java.util.*;

public class BTKeysAtSameLevel {
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

  /** Constructor
   */
  public BTKeysAtSameLevel() {
    // fill this in!
  }

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
    // throws IllegalArgumentException if the String is null, or doesn't correspond to a valid String representation of a binary tree.
    if (!isValid(treeInStringRepresentation) || !inRange(treeInStringRepresentation)) {
      throw new IllegalArgumentException("null tree");
    }
    // Returns an empty list if the tree is empty.
    if (treeInStringRepresentation.isEmpty()) {
      return new ArrayList<>();
    }
    Node root = buildTree(treeInStringRepresentation);
    // Calls the private method addAllLists which assembles all nested lists into one list.
    return addAllLists(root);
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


}
