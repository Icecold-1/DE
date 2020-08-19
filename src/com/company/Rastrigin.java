package com.company;

public class Rastrigin extends Problem {
    public Rastrigin(int d, int maxFES) {
        super(d, maxFES);
        for(int i = 0; i < d; i++) {
            upper[i] = 5.12;
            lower[i] = -5.12;
        }
    }

    @Override
    public double evaluate(double[] x) {
        double s1 = 0.0;
        for(int i = 0; i < x.length; i++) {
            s1 = s1 + Math.pow(x[i], 2) - 10 * Math.cos(2*Math.PI*x[i]);
        }
        return (10 * x.length + s1);
    }
}
