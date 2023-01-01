package edu.yu.introtoalgs;

import java.util.*;


/** Defines the API for the WealthTransfer assignment: see the requirements
 * document for more information.
 *
 * Students MAY NOT change the constructor signature.  My test code will only
 * invoke the API defined below.
 *
 * @author Avraham Leff
 */

public class WealthTransfer {
  private Node root;
  private int populationSize;
  private Map<Integer, ArrayList<Integer>> percentToTransfer = new HashMap<Integer, ArrayList<Integer>>();
  private Map<Integer, ArrayList<Integer>> intentToTransfer = new HashMap<Integer, ArrayList<Integer>>();
  private Set setWealth = new HashSet();

  /** Constructor: specifies the size of the population.
   *
   * @param populationSize a positive integer specifying the number of people
   * in the population.  Members of the population are uniquely identified by
   * an integer 1..populationSize.  Initial wealth transfer must be initiated
   * by the person with id of "1".
   */
  public WealthTransfer(final int populationSize) {
    this.populationSize = populationSize;
    this.root = new Node(1, 0, false);
  } // constructor

  /** Specifies that one person want to make a wealth transfer to another
   * person.
   *
   * @param from specifies who is doing the wealth transfer, must correspond to
   * a valid population id
   * @param to specifies who is receiving the wealth transfer, must correspond
   * to a valid population id, and can't be identical to "from"
   * @param percentage the percentage of "from"'s wealth that will be
   * transferred to "to": must be an integer between 1..100
   * @param isWealthSquared if true, the wealth received is the square of the
   * money transferred
   * @throws IllegalArgumentException if the parameter Javadoc specifications
   * aren't satisfied or if this "from" has previously specified a wealth
   * transfer to this "to".
   */
  public void intendToTransferWealth(final int from, final int to, final int percentage, final boolean isWealthSquared) {

    if (from < 1 || from > populationSize || to < 1 || to > populationSize || from == to || percentage < 1 || percentage > 100 || from > to) {
      throw new IllegalArgumentException("Invalid parameters for intendToTransferWealth");
    }

    if (intentToTransfer.containsKey(from)){
      if (intentToTransfer.get(from).contains(to)){
        throw new IllegalArgumentException("Already promised to transfer wealth to this person");
      }
    }

    Node root = this.root;

    if (root == null){return;}

    Queue<Node > q = new LinkedList<>(); // Create a queue
    q.add(root);

    while (!q.isEmpty())
    {
      int n = q.size();

      // If this node has children
      while (n > 0)
      {
        // Dequeue an item from queue
        // and print it
        Node p = q.peek();
        q.remove();
        if (p.getId() == from){
          p.addChild(new Node(to, percentage, isWealthSquared));
        }

        // Enqueue all children of
        // the dequeued item
        for (int i = 0; i < p.getChildren().size(); i++)
          q.add(p.getChildren().get(i));
        n--;
      }

    }

    intentToTransfer.put(from, new ArrayList<Integer>());
    intentToTransfer.get(from).add(to);

    if (!percentToTransfer.containsKey(from)){
      percentToTransfer.put(from, new ArrayList<Integer>());
    }

    percentToTransfer.get(from).add(percentage);

  }

  /** Specifies the wealth that the person must have in order for the overall
   * wealth transfer problem to be considered solved.
   *
   * @param id must correspond to a member of the population from 2..populationSize
   * @param wealth the wealth that the designated person must have as a result
   * of wealth transfers, must be positive.
   * @throw IllegalArgumentException if parameter Javadoc specifications aren't
   * met.
   */
  public void setRequiredWealth(final int id, final int wealth) {

    if (id < 2){
      throw new IllegalArgumentException("id must be greater than 1");
    }
    if (id > populationSize){
      throw new IllegalArgumentException("id can't be greater than populationSize");
    }
    if (wealth <= 0){
      throw new IllegalArgumentException("wealth must be positive");
    }

    if (!setWealth.add(id)){
      throw new IllegalArgumentException("Already set the required wealth for this person");
    }

    Node root = this.root;

    if (root == null){return;}

    Queue<Node > q = new LinkedList<>(); // Create a queue
    q.add(root);

    while (!q.isEmpty())
    {
      int n = q.size();

      // If this node has children
      while (n > 0)
      {
        // Dequeue an item from queue
        Node p = q.peek();
        q.remove();
        if (p.getId() == id){
          p.setMinWealth(wealth);
        }

        // Enqueue all children of
        // the dequeued item
        for (int i = 0; i < p.getChildren().size(); i++)
          q.add(p.getChildren().get(i));
        n--;
      }

    }
    setWealth.add(id);
  }

  /** Solves the wealth transfer problem by determining the MINIMAL amount of
   * wealth that "person with id of 1" must transfer such that all members of
   * the population receive the wealth that they have been promised.
   *
   * The amount of wealth that a person has been promised is specified by
   * invocations of setRequiredWealth().  The amount of wealth that a person
   * actually receives is specified by invocations of intendToTransferWealth().
   * The "person with id of 1" initiates all wealth transfers between members
   * of the population.  This method returns the minimum amount of that
   * initiating wealth transfer that will satisfy the remaining population's
   * needs.
   *
   * NOTE: at the time that this method is invoked, all persons transfering
   * wealth MUST be on record as intending to transfer 100 percent of their
   * wealth.  If this pre-condition doesn't hold, the implementation MUST throw
   * an IllegalStateException in lieu of solving the problem.
   *
   * @return the minimum amount transfered by person with id #1: must be
   * accurate to four digits after the decimal point.
   */
  public double solveIt() {

    double totalPercent = 0;

    for (List list : percentToTransfer.values()){
      // loop through all the percentages in each set
      for (int i = 0; i < list.size(); i++){
        // add all the percentages together
        totalPercent += (int) list.get(i);
      }
      // if the total percentage is not 100, throw an exception
      if (totalPercent != 100){
        throw new IllegalStateException("Total percentage must be 100");
      }
      // if the total percentage is 100, reset the total percentage
      totalPercent = 0;
    }

    Node root = this.root;
    Stack<Node> stack = new Stack<Node>();
    Stack<Node> out = new Stack<Node>();

    stack.push(root);

    while (!stack.isEmpty()) {
      Node curr = stack.pop();
      out.push(curr);

      if (curr.getChildren().size() > 0) {
        for (int i = 0; i < curr.getChildren().size(); i++) {
          stack.push(curr.getChildren().get(i));
        }
      }
    }
    while (!out.isEmpty()){
      Node curr = out.pop();

      if (curr.getChildren().size() > 0) {
        double largestChildValue = Double.MIN_VALUE;
        for (Node child : curr.getChildren()) {
          if (child.getSquared()){
            child.setMinWealth(Math.sqrt(child.getMinWealth()));
          }
          if (child.getMinWealth() / (child.getPercent() * 0.01) > largestChildValue) {
            largestChildValue = child.getMinWealth() / (child.getPercent() * 0.01);
          }
        }
        curr.setMinWealth(largestChildValue);
      }

    }

    return root.getMinWealth();
  }
} // class
