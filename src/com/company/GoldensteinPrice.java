package com.company;

public class GoldensteinPrice extends Problem {
    public GoldensteinPrice(int d, int maxFES) {
        super(d, maxFES);
        for(int i = 0; i < d; i++) {
            upper[i] = 2;
            lower[i] = -2;
        }
    }

    @Override
    public double evaluate(double[] x) {
        double first = (1+Math.pow(x[0]+x[1]+1, 2)*(19-14*x[0]+3*Math.pow(x[0],2)-14*x[1]+6*x[0]*x[1]+3*Math.pow(x[1],2)));
        double second = (30+Math.pow(2*x[0]-3*x[1],2)*(18-32*x[0]+12*Math.pow(x[0],2)+48*x[1]-36*x[0]*x[1]+27*Math.pow(x[1],2)));
        return first*second;
    }
}
