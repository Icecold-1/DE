package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    int d = Integer.parseInt(args[0]);
	    int maxFES = Integer.parseInt(args[1]);
	    int pop_size = Integer.parseInt(args[2]);
	    double CR = Double.parseDouble(args[3]);
	    double F = Double.parseDouble(args[4]);

        Problem[] problems;

	    if(d < 10) {
	        problems = new Problem[] {
	                new Booth(d, maxFES),
                    new GoldensteinPrice(d, maxFES),
                    new Matyas(d, maxFES),
                    new Beale(d, maxFES)
            };
        } else {
            problems = new Problem[] {
                    new Ackley(d, maxFES),
                    new DixonPrice(d, maxFES),
                    new Powell(d, maxFES),
                    new Rastrigin(d, maxFES),
                    new Rosenbrock(d, maxFES),
                    new Schwefel(d, maxFES),
                    new Sphere(d, maxFES),
                    new SumSquare(d, maxFES),
                    new Zakharov(d, maxFES)
            };
        }

        DifferentialEvolution de = new DifferentialEvolution(pop_size, CR, F);
        for(int p = 0; p < problems.length; p++) {
            System.out.println(problems[p].getClass().getCanonicalName());
            double avg = 0.0;
            List<Solution> std = new ArrayList<>();
            for (int i = 0; i < 50; i++) {
                problems[p].resetFESCount();
                Solution best = de.exec(problems[p]);
                std.add(best);
                avg += best.getFitness();
                if(i==49)
                    System.out.println("best: "+best.fitness);
            }
            System.out.println("StdDev: "+stdDeviation(std, avg/50));
            System.out.println("avg: "+ avg/50);
        }
    }

    public static double stdDeviation(List<Solution> std, double avg) {
        double stdDev = 0;
        for(Solution s:std) {
            stdDev = stdDev + Math.pow(s.fitness-avg,2);
        }
        return Math.sqrt(stdDev/std.size());
    }
}
