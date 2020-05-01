package com.company;

public class Sphere extends Problem {
    public Sphere(int d, int maxFES) {
        super(d, maxFES);
        for(int i = 0; i < d; i++) {
            upper[i] = 5.12;
            lower[i] = -5.12;
        }
    }

    @Override
    public double evaluate(double[] x) {
        double fitness = 0.0;
        for(int i = 0; i < x.length; i++) {
            fitness = fitness + Math.pow(x[i], 2);
        }
        return fitness;
    }
}
