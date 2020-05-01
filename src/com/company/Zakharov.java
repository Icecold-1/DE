package com.company;

public class Zakharov extends Problem {
    public Zakharov(int d, int maxFES) {
        super(d, maxFES);
        for(int i = 0; i < d; i++) {
            upper[i] = 10;
            lower[i] = -5;
        }
    }

    @Override
    public double evaluate(double[] x) {
        double fitness = 0.0;
        for(int i = 0; i < x.length; i++) {
            fitness = fitness + Math.pow(x[i], 2);
        }
        for(int i = 0; i < x.length; i++) {
            fitness = fitness + Math.pow(0.5*i*x[i], 2);
        }
        for(int i = 0; i < x.length; i++) {
            fitness = fitness + Math.pow(0.5*i*x[i], 4);
        }
        return fitness;
    }
}
