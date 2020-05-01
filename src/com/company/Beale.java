package com.company;

public class Beale extends Problem {
    public Beale(int d, int maxFES) {
        super(d, maxFES);
        for(int i = 0; i < d; i++) {
            upper[i] = 4.5;
            lower[i] = -4.5;
        }
    }

    @Override
    public double evaluate(double[] x) {
        double fitness = 0.0;
        fitness = Math.pow(1.5-x[0]+x[0]*x[1],2)+Math.pow(2.25-x[0]+x[0]*Math.pow(x[1],2),2)+Math.pow(2.625-x[0]+x[0]*Math.pow(x[1],3),2);
        return fitness;
    }
}
