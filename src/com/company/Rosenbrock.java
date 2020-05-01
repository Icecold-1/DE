package com.company;

public class Rosenbrock extends Problem {
    public Rosenbrock(int d, int maxFES) {
        super(d, maxFES);
        for(int i = 0; i < d; i++) {
            upper[i] = 5;
            lower[i] = -4;
        }
    }

    @Override
    public double evaluate(double[] x) {
        double fitness = 0.0;
        for(int i = 0; i < x.length-1; i++) {
            fitness = fitness + 100*Math.pow(x[i+1]-Math.pow(x[i],2),2)+Math.pow(x[i]-1,2);
        }
        return fitness;
    }
}
