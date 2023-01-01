package edu.yu.introtoalgs;

public class Aliens extends BigOMeasurable{

    private int populationSize;
    private UnionFind uf;

    private UnionFind incompatible;

    @Override
    public void setup(final int n) {
        this.populationSize = populationSize;
        this.uf = new UnionFind(populationSize);
        this.incompatible = new UnionFind(populationSize);
    }

    @Override
    public void execute() {


    }

    public void setIncompatible(int xeno1, int xeno2) {
        checkForInputError(xeno1, xeno2);
        if (areIncompatible(xeno1, xeno2) || areCompatible(xeno2, xeno1)) {
            return;
        }
        incompatible.union(xeno1, xeno2);

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


        return uf.connected(xeno1, xeno2);
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

        return incompatible.connected(xeno1, xeno2);

    }

    private void checkForInputError(int xeno1, int xeno2) {
        if (xeno1 < 0 || xeno2 < 0 || xeno1 >= populationSize || xeno2 >= populationSize || xeno1 == xeno2) {
            throw new IllegalArgumentException();
        }
    }
}
