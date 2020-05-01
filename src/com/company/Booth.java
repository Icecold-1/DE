package com.company;

public class Booth extends Problem {
    public Booth(int d, int maxFES) {
        super(d, maxFES);
        for(int i = 0; i < d; i++) {
            upper[i] = 10;
            lower[i] = -10;
        }
    }

    @Override
    public double evaluate(double[] x) {
        double fitness = 0.0;
        fitness = Math.pow(x[0]+2*x[1]-7,2)+Math.pow(2*x[0]+x[1]-5,2);
        return fitness;
    }
}
