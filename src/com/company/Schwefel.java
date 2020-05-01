package com.company;

public class Schwefel extends Problem {
    public Schwefel(int d, int maxFES) {
        super(d, maxFES);
        for(int i = 0; i < d; i++) {
            upper[i] = 500;
            lower[i] = -500;
        }
    }

    @Override
    public double evaluate(double[] x) {
        double fitness = 418.9829*x.length;
        for(int i = 0; i < x.length; i++) {
            fitness = fitness - x[i]*Math.sin(Math.sqrt(Math.abs(x[i])));
        }
        return fitness;
    }
}
