package com.company;

public class Ackley extends Problem {
    public Ackley(int d, int maxFES) {
        super(d, maxFES);
        for(int i = 0; i < d; i++) {
            upper[i] = 30;
            lower[i] = -15;
        }
    }

    @Override
    public double evaluate(double[] x) {
        double fitness = 0.0;

        double s1 = 0, s2 = 0;
        for(int i = 0; i < x.length; i++) {
            s1 = s1+Math.pow(x[i],2);
            s2 = s2+Math.cos(2*Math.PI*x[i]);
            fitness = fitness-20*Math.exp(-0.2*Math.sqrt(1/x.length*s1))-Math.exp(1/x.length*s2)+20+Math.exp(1);
        }

        return fitness;
    }
}
