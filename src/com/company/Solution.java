package com.company;

public class Solution  {
    protected double[] x;
    protected double fitness;
    protected boolean evaluated;

    public Solution(double[] x, double fitness) {
        this.x = x;
        this.fitness = fitness;
        evaluated = true;
    }

    public Solution(Solution s) {
        this.fitness = s.fitness;
        this.evaluated = s.evaluated;
        this.x = s.x.clone();
    }

    public double[] getX() {
        return x;
    }

    public void setX(double[] x) {
        this.x = x;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
        evaluated = true;
    }

    public boolean isEvaluated() {
        return evaluated;
    }

    public void setEvaluated(boolean evaluated) {
        this.evaluated = evaluated;
    }
}
