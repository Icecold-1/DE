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
        population.clear();
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

                /// Mutacija
                for(int i = 0; i < problem.getD(); i++) {
                    double ri = r.nextDouble();
                    if(ri < CR || i == R)
                        y.x[i] = a.x[i] + F * (b.x[i] - c.x[i]);
                }



                int rand_j = r.nextInt() % problem.d;

                Solution k = new Solution(problem.d);

                // Krizanje
                for(int j = 0; j < problem.d; j++) {
                        double rand_ij = r.nextDouble();
                        if(rand_ij < CR || rand_j == j) {
                            k.x[j] = y.x[j];
                        } else {
                            k.x[j] = x.x[j];
                        }
                }

                if(!problem.isFeasible(k.x))
                    problem.setFeasible(k.x);

                double fitness_old = x.fitness;
                double fitness_new = problem.evaluate(k.x);

                k.fitness = fitness_new;



                if(fitness_new < fitness_old) {
                    population.set(population.indexOf(x), k);
                    if(best.getFitness() >= k.getFitness())
                        best = k;
                }

                problem.FESCount++;
            }
            //problem.FESCount++;
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
            newSolution.fitness = problem.evaluate(newSolution.x);
            population.add(newSolution);
        }
    }
}
