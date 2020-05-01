package com.company;

public class Matyas extends Problem {
    public Matyas(int d, int maxFES) {
        super(d, maxFES);
        for(int i = 0; i < d; i++) {
            upper[i] = 10;
            lower[i] = -10;
        }
    }

    @Override
    public double evaluate(double[] x) {
        double fitness = 0.0;
        fitness = 0.26*(Math.pow(x[0],2)+Math.pow(x[1],2))-0.48*x[0]*x[1];
        return fitness;
    }
}
