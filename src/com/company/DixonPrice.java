package com.company;

public class DixonPrice extends Problem {
    public DixonPrice(int d, int maxFES) {
        super(d, maxFES);
        for(int i = 0; i < d; i++) {
            upper[i] = 10;
            lower[i] = -10;
        }
    }

    @Override
    public double evaluate(double[] x) {
        double fitness = 0.0;
        double s1 = 0.0;
        for(int i = 1; i < x.length; i++) {
            s1 = s1 + i+1*Math.pow(2*Math.pow(x[i],2)-x[i-1], 2);
        }

        fitness = Math.pow(x[0]-1,2) + s1;
        return fitness;
    }
}
