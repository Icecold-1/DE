package com.company;

public class Powell extends Problem {
    public Powell(int d, int maxFES) {
        super(d, maxFES);
        for(int i = 0; i < d; i++) {
            upper[i] = 5;
            lower[i] = -4;
        }
    }

    @Override
    public double evaluate(double[] x) {
        double fitness = Math.pow(x[0]+10*x[1],2)+5*Math.pow(x[2]-x[3],2)+Math.pow(x[1]-2*x[2],4)+10*Math.pow(x[0]-x[3],4);
        for(int i = 1; i < x.length/4-1; i++) {
            fitness = fitness + Math.pow(x[4*i-3]+10*x[4*i-2],2)+5*Math.pow(x[4*i-1]-x[4*i],2)+Math.pow(x[4*i-2]-2*x[4*i-1],4)+10*Math.pow(x[4*i-3]-x[4*i],4);
        }
        return fitness;
    }
}
