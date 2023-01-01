package edu.yu.introtoalgs;

import java.util.List;
import java.util.*;

/** Defines the API for the HydratedHakofos assignment: see the requirements
 * document for more information.
 *
 * Students MAY NOT change the constructor signature.  My test code will only
 * invoke the API defined below.
 *
 * @author Avraham Leff
 */

public class HydratedHakofos {
  public HydratedHakofos() {}

  /** Determines whether or not a table exists such that hakofos, beginning
   * from this table, can successfully traverse the entire circuit without
   * getting dehydrated ("negative water level").  If multiple tables are
   * valid, return the lowest-numbered table (numbered 1..n).  Otherwise,
   * return the sentinel value of "-1".
   *
   * @param waterAvailable an array, indexed from 0..n-1, such that the ith
   * element represents the amount of water available at the ith table.
   * @param waterRequired an array, indexed from 0..n-1, such that the ith
   * element represents the amount of water required to travel from the ith
   * table to the next table.
   * @return a number from 1..n or -1 as appropriate.
   *
   * NOTE: if the client supplies arrays of differing lengths, or if the arrays
   * are null, or empty, or if the client supplies non-positive values in
   * either of these arrays, the result is undefined.  In other words: you
   * don't have to check for these conditions (unless you want to prevent
   * errors during development).
   */
  public int doIt(int[] waterAvailable, int[] waterRequired) {
      // fill in with your implementation
      if (invalidInput(waterAvailable, waterRequired)) {
          throw new IllegalArgumentException("Undefined input");
      }

      // ************************************* First version *************************************


//      int totalWaterAvailable = 0;
//      int currentWaterAvailable = 0;
//      int startingTable = 0;
//      int index = 0;
//
//      while(index < waterAvailable.length){
//          for (int i = index; i < waterAvailable.length; ++i){
//              totalWaterAvailable += waterAvailable[i] - waterRequired[i];
//              currentWaterAvailable += waterAvailable[i] - waterRequired[i];
//              if (currentWaterAvailable < 0){
//                  startingTable = i + 1;
//                  currentWaterAvailable = 0;
//              }
//          }
//          for (int i = 0; i < index; ++i){
//              totalWaterAvailable += waterAvailable[i] - waterRequired[i];
//              currentWaterAvailable += waterAvailable[i] - waterRequired[i];
//              if (currentWaterAvailable < 0){
//                  startingTable = i + 1;
//                  currentWaterAvailable = 0;
//              }
//          }
//          index++;
//
//      }
//        if (totalWaterAvailable >= 0){
//            return startingTable + 1;
//        }
//        return -1;
      /*
       ************************************* More elegant Version *************************************
       */

      int startingTable = 0;
      int totalWaterAvailable = 0;
      int hydrationLevel = 0;
      int n = waterAvailable.length;

      for (int i = 0; i < n; ++i){
            hydrationLevel += waterAvailable[i] - waterRequired[i];
            if (hydrationLevel < 0){
                startingTable = i + 1;
                totalWaterAvailable += hydrationLevel;
                hydrationLevel = 0;
            }
      }
      return totalWaterAvailable + hydrationLevel >= 0 ? startingTable + 1 : -1 ;
  }

  private boolean invalidInput(int[] waterAvailable, int[] waterRequired) {
    if (waterAvailable == null || waterRequired == null) {
      return true;
    }
    if (waterAvailable.length == 0 || waterRequired.length == 0) {
      return true;
    }
    if (waterAvailable.length != waterRequired.length) {
      return true;
    }
    for (int i = 0; i < waterAvailable.length; i++) {
      if (waterAvailable[i] <= 0 || waterRequired[i] <= 0) {
        return true;
      }
    }
    return false;
  }


}
