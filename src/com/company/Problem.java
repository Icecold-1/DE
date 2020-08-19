package com.company;

import java.util.Random;

public abstract class Problem {
    protected double[] upper;
    protected double[] lower;
    protected int d;
    protected int maxFES;
    protected int FESCount;

    protected Random r = new Random();

    public Problem(int d, int maxFES) {
        this.d = d;
        this.maxFES = maxFES;
        this.upper = new double[d];
        this.lower = new double[d];
    }

    public double[] getUpper() {
        return upper;
    }

    public void setUpper(double[] upper) {
        this.upper = upper;
    }

    public double[] getLower() {
        return lower;
    }

    public void setLower(double[] lower) {
        this.lower = lower;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getMaxFES() {
        return maxFES;
    }

    public void setMaxFES(int maxFES) {
        this.maxFES = maxFES;
    }

    public int getFESCount() {
        return FESCount;
    }

    public void resetFESCount() {
        this.FESCount = 0;
    }

    public abstract double evaluate(double[] x);

    public void evaluate(Solution s) {
        s.setFitness(evaluate(s.getX()));
        FESCount++;
    }

    public Solution generateRandomSolution() {
        double[] randomSol = new double[d];
        for(int i = 0; i < d; i++) {
            randomSol[i] = lower[i] + (upper[i] - lower[i])*r.nextDouble();
        }

        return new Solution(randomSol, evaluate(randomSol));
    }

    public void setFeasible(double[] x) {
        for(int i = 0; i < d; i++) {
            if(x[i] > upper[i])
                x[i] = upper[i]-(x[i]-upper[i]);
            if(x[i] < lower[i])
                x[i] = lower[i]+(lower[i]-x[i]);
        }
    }

    public boolean isFeasible(double[] x) {
        for(int i = 0; i < d; i++)
            if(x[i] > upper[i] || x[i] < lower[i])
                return false;

            return true;
    }
}
