package edu.yu.introtoalgs;

import java.util.*;

/** Defines the API for the LinelandNavigation assignment: see the requirements
 * document for more information.
 *
 * Students MAY NOT change the constructor signature.  My test code will only
 * invoke the API defined below.
 *
 * @author Avraham Leff
 */

public class LinelandNavigation {

  /** Even though Lineland extends forward (and backwards) infinitely, for
   * purposes of this problem, the navigation goal cannot exceed this value
   */
  public final static int MAX_FORWARD = 1_000_000;
  private int g;
  private int m;
  private Set<Integer> minedSet = new HashSet<>();

  /** Constructor.  When the constructor completes successfully, the navigator
   * is positioned at position 0.
   *
   * @param g a positive value indicating the minimim valued position for a
   * successful navigation (a successful navigation can result in a position
   * that is greater than g).  The value of this parameter ranges from 1 to
   * MAX_FORWARD (inclusive).
   * @param m a positive integer indicating the exact number of positions that
   * must always be taken in a forward move. The value of this parameter cannot
   * exceed MAX_FORWARD.
   * @throws IllegalArgumentException if the parameter values violate the
   * specified semantics.
   */
  public LinelandNavigation(final int g, final int m) {
    // fill me in!
    if (g < 1 || g > MAX_FORWARD) {
      throw new IllegalArgumentException("g must be between 1 and " + MAX_FORWARD);
    }

    if (m < 1 || m > MAX_FORWARD) {
      throw new IllegalArgumentException("m must be between 1 and " + MAX_FORWARD);
    }

    this.g = g;
    this.m = m;

  }

  /** Adds a mined line segment to Lineland (an optional operation).
   *
   * NOTE: to simplify computation, assume that no two mined line segments can
   * overlap with one another, even at their end-points.  You need not test for
   * this (although if it's easy to do so, consider sprinkling asserts in your
   * code).
   *
   * @param start a positive integer representing the start (inclusive)
   * position of the line segment
   * @param end a positive integer represending the end (inclusive) position of
   * the line segment, must be greater or equal to start, and less than
   * MAX_FORWARD.
   */
  public void addMinedLineSegment(final int start, final int end) {
    // fill me in!
    if ( start < 1 || end < 1 || start > end || end >= MAX_FORWARD ) {
      throw new IllegalArgumentException("start and end must be positive, start must be less than end, and end must be less than MAX_FORWARD");
    }
    for (int i = start; i <= end; i++){
      minedSet.add(i);
    }

  }


  /** Determines the minimum number of moves needed to navigate from position 0
   * to position g or greater, where forward navigation must exactly m
   * positions at a time and backwards navigation can be any number of
   * positions.
   *
   * @return the minimum number of navigation moves necessary, or "0" if no
   * navigation is possible under the specified constraints.
   */
  public final int solveIt() {

    // Create a queue to use for breadth-first search
    Queue<Integer> queue = new LinkedList<>();

    // Initialize distances array and add starting position to queue
    int[] distances = new int[MAX_FORWARD + 1];
    Arrays.fill(distances, Integer.MAX_VALUE);
    queue.add(0);
    distances[0] = 0;


    while (!queue.isEmpty()) {
      int currentPosition = queue.poll();

      // Check if current position is the goal
      if (currentPosition >= g) {
        return distances[currentPosition];
      }

      // Get neighbors of current position
      Queue<Integer> neighbors = getNeighbors(currentPosition);
      for (int neighbor : neighbors) {
        if (distances[neighbor] == Integer.MAX_VALUE) {
          // Update distance to neighbor and add to queue
          distances[neighbor] = distances[currentPosition] + 1;
          queue.add(neighbor);
        }
      }
    }

    // Return 0 if no path to g was found
    return 0;

  }


  private Queue<Integer> getNeighbors(int currentPosition) {
    Queue<Integer> neighbors = new LinkedList<>();


    // Add forward and backward neighbors
    if (currentPosition + m <= MAX_FORWARD && !minedSet.contains(currentPosition + m)) {
      neighbors.add(currentPosition + m);
    }

    int maxBackward = m - 1;
    for (int i = 1; i <= maxBackward; i++) {
      if (!minedSet.contains(currentPosition - i) && currentPosition - i >= 0) {
        neighbors.add(currentPosition - i);
      }

    }

    return neighbors;

  }


} // LinelandNavigation
