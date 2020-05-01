package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DifferentialEvolution {
    Problem problem;
    Solution best;

    int NP;
    double CR, F;

    Random r = new Random();

    List<Solution> population = new ArrayList<Solution>();

    public DifferentialEvolution(int NP, double CR, double F) {
        this.NP = NP;
        this.CR = CR;
        this.F = F;
    }

    public Solution exec(Problem problem) {
        this.problem = problem;
        init();

        while (problem.FESCount < problem.getMaxFES()) {
            for(Solution x: population) {
                Solution a, b, c;
                a = population.get(r.nextInt(NP));
                b = population.get(r.nextInt(NP));
                c = population.get(r.nextInt(NP));

                while (a.equals(x)) {
                    a = population.get(r.nextInt(NP));
                }
                while (b.equals(x) || b.equals(a)) {
                    b = population.get(r.nextInt(NP));
                }
                while (c.equals(x) || c.equals(a) || c.equals(b)) {
                    c = population.get(r.nextInt(NP));
                }

                int R = r.nextInt(problem.getD());

                Solution y = new Solution(x);

                for(int i = 0; i < problem.getD(); i++) {
                    double ri = r.nextDouble();
                    if(ri < CR || i == R)
                        y.x[i] = a.x[i] + F * (b.x[i] - c.x[i]);
                }

                if(!problem.isFeasible(y.x))
                    problem.setFeasible(y.x);

                problem.evaluate(y);
                problem.FESCount++;

                if(y.getFitness() <= x.getFitness()) {
                    population.set(population.indexOf(x), y);
                    if(best.getFitness() >= y.getFitness())
                        best = y;
                }
            }
            if(problem.FESCount > problem.maxFES)
                break;
        }

        return best;
    }

    /**
     * Generating random solutions and adding them to the population
     */

    private void init() {
        best = problem.generateRandomSolution();
        population.add(new Solution(best));
        for (int i = 0; i < NP - 1; i++) {
            Solution newSolution = problem.generateRandomSolution();
            population.add(newSolution);
        }
    }
}
