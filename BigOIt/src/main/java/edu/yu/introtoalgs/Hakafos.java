package edu.yu.introtoalgs;

public class Hakafos extends BigOMeasurable {
    int[] waterAvailable;
    int[] waterRequired;
    public Hakafos() {

    }

    @Override
    public void setup(final int n) {
        this.waterAvailable = new int[n];
        this.waterRequired = new int[n];
    }
    @Override
    public void execute() {
        int n = waterAvailable.length;

        int totalWaterAvailable = 0;
        int currentWaterAvailable = 0;
        int startingTable = 0;
        int index = 0;

        while(index < n){
            for (int i = index; i < n; ++i){
                totalWaterAvailable += waterAvailable[i] - waterRequired[i];
                currentWaterAvailable += waterAvailable[i] - waterRequired[i];
                if (currentWaterAvailable < 0){
                    startingTable = i + 1;
                    currentWaterAvailable = 0;
                }
            }
            for (int i = 0; i < index; ++i){
                totalWaterAvailable += waterAvailable[i] - waterRequired[i];
                currentWaterAvailable += waterAvailable[i] - waterRequired[i];
                if (currentWaterAvailable < 0){
                    startingTable = i + 1;
                    currentWaterAvailable = 0;
                }
            }
            index++;

        }
    }
}
