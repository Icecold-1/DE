package com.company;

public class SumSquare extends Problem {
    public SumSquare(int d, int maxFES) {
        super(d, maxFES);
        for(int i = 0; i < d; i++) {
            upper[i] = 10;
            lower[i] = -10;
        }
    }

    @Override
    public double evaluate(double[] x) {
        double fitness = Math.pow(x[0],2);
        for(int i = 1; i < x.length; i++) {
            fitness = fitness + i*Math.pow(x[i], 2);
        }
        return fitness;
    }
}
