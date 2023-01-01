package edu.yu.introtoalgs;

/** Defines the API for the XenoHematology assignment: see the requirements
 * document for more information.
 *
 * Students MAY NOT change the constructor signature.  My test code will only
 * invoke the API defined below.
 *
 * @author Avraham Leff
 */

public class XenoHematology {
  private int populationSize;
  private UnionFind uf;

  /** Constructor: specifies the size of the xeno population.
   *
   * @param populationSize a non-negative integer specifying the number of
   * aliens in the xeno population.  Members of the population are uniquely
   * identified by an integer 0..populationSize -1.
   */
  public XenoHematology(final int populationSize) {
    if (populationSize < 0){
      throw new IllegalArgumentException();
    }
    this.populationSize = populationSize;
    this.uf = new UnionFind(populationSize);
  }

  /** Specifies that xeno1 and xeno2 are incompatible.  Once specified
   * as incompatible, the pair can never be specified as being
   * "compatible".  In that case, don't throw an exception, simply
   * treat the method invocation as a "no-op".  A xeno is always
   * compatible with itself, is never incompatible with itself:
   * directives to the contrary should be treated as "no-op"
   * operations.
   *
   * Both parameters must correspond to a member of the population.
   *
   * @param xeno1 non-negative integer that uniquely specifies a member of the
   * xeno population, differs from xeno2
   * @param xeno2 non-negative integer that uniquely specifies a member of the
   * xeno population.
   * @throws IllegalArgumentException if the supplied values are incompatible
   * with the above semantics or those specified by the requirements doc.
   */
  // union find
  public void setIncompatible(int xeno1, int xeno2) {
    checkForInputError(xeno1, xeno2);
    if (areIncompatible(xeno1, xeno2) || areCompatible(xeno2, xeno1)) {
      return;
    }

    uf.addIncompatible(xeno1);
    uf.addIncompatible(xeno2);
//    uf.union(xeno1,xeno2);

  }

  /** Specifies that xeno1 and xeno2 are compatible.  Once specified
   * as compatible, the pair can never be specified as being
   * "incompatible".  In that case, don't throw an exception, simply
   * treat the method invocation as a "no-op".  A xeno is always
   * compatible with itself, is never incompatible with itself:
   * directives to the contrary should be treated as "no-op"
   * operations.
   *
   * Both parameters must correspond to a member of the population.
   *
   * @param xeno1 non-negative integer that uniquely specifies a member of the
   * xeno population.
   * @param xeno2 non-negative integer that uniquely specifies a member of the
   * xeno population
   * @throws IllegalArgumentException if the supplied values are incompatible
   * with the above semantics or those specified by the requirements doc.
   */
  public void setCompatible(int xeno1, int xeno2) {
    checkForInputError(xeno1, xeno2);
    if (areIncompatible(xeno1, xeno2) || areCompatible(xeno2, xeno1)) {
      return;
    }
    uf.union(xeno1, xeno2);

  }

  /** Returns true iff xeno1 and xeno2 are compatible from a hematology
   * perspective, false otherwise (including if we don't know one way or the
   * other).  Both parameters must correspond to a member of the population.
   *
   * @param xeno1 non-negative integer that uniquely specifies a member of the
   * xeno population, differs from xeno2
   * @param xeno2 non-negative integer that uniquely specifies a member of the
   * xeno population
   * @return true iff compatible, false otherwise
   * @throws IllegalArgumentException if the supplied values are incompatible
   * with the above semantics or those specified by the requirements doc.
   */
  public boolean areCompatible(int xeno1, int xeno2) {
    checkForInputError(xeno1, xeno2);
//    if (alreadyIncompatable(xeno1, xeno2)){
//      return false;
//    }

    if (uf.getIncompatibleSet().contains(xeno1) && uf.getIncompatibleSet().contains(xeno2) || (!uf.getIncompatibleSet().contains(xeno2) && uf.getIncompatibleSet().contains(xeno1)) ||
            (uf.getIncompatibleSet().contains(xeno2) && !uf.getIncompatibleSet().contains(xeno1))) {
      return true;
    }
    return uf.connected(xeno1, xeno2);
  }
  private boolean alreadyIncompatable(int xeno1, int xeno2){

    if (uf.getIncompatibleSet().contains(xeno1) && uf.getIncompatibleSet().contains(xeno2)) {
      return true;
    }
    return false;

  }

  /** Returns true iff xeno1 and xeno2 are incompatible from a hematology
   * perspective, false otherwise (including if we don't know one way or the
   * other).  Both parameters must correspond to a member of the population.
   *
   * @param xeno1 non-negative integer that uniquely specifies a member of the
   * xeno population, differs from xeno2
   * @param xeno2 non-negative integer that uniquely specifies a member of the
   * xeno population
   * @return true iff compatible, false otherwise
   * @throws IllegalArgumentException if the supplied values are incompatible
   * with the above semantics or those specified by the requirements doc.
   */
  public boolean areIncompatible(int xeno1, int xeno2) {

    checkForInputError(xeno1, xeno2);

    if ((!uf.getIncompatibleSet().contains(xeno1) && uf.getIncompatibleSet().contains(xeno2)) || (uf.getIncompatibleSet().contains(xeno1) && !uf.getIncompatibleSet().contains(xeno2))) {
      return true;
    }

    return uf.getIncompatibleSet().contains(xeno1) && uf.getIncompatibleSet().contains(xeno2);

  }

  private void checkForInputError(int xeno1, int xeno2) {
    if (xeno1 < 0 || xeno2 < 0 || xeno1 >= populationSize || xeno2 >= populationSize) {
        throw new IllegalArgumentException();
    }
  }
}
