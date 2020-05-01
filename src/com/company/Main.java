package com.company;

public class Main {

    public static void main(String[] args) {
	    int d = Integer.parseInt(args[0]);
	    int maxFES = Integer.parseInt(args[1]);
	    int pop_size = Integer.parseInt(args[2]);
	    double CR = Double.parseDouble(args[3]);
	    double F = Double.parseDouble(args[4]);
	    double min = Double.MAX_VALUE;

	    Problem[] problems = new Problem[] {
	            new Ackley(d, maxFES),
                new Beale(d, maxFES),
                new Booth(d, maxFES),
                new DixonPrice(d, maxFES),
                new GoldensteinPrice(d, maxFES),
                new Matyas(d, maxFES),
                new Powell(d, maxFES),
                new Rastrigin(d, maxFES),
                new Rosenbrock(d, maxFES),
                new Schwefel(d, maxFES),
                new Sphere(d, maxFES),
                new SumSquare(d, maxFES),
                new Zakharov(d, maxFES)
        };

        DifferentialEvolution de = new DifferentialEvolution(pop_size, CR, F);

        double avg = 0.0;
        for(int p = 0; p < problems.length; p++) {
            for (int i = 0; i < 50; i++) {
                min = Double.MAX_VALUE;
                problems[p].resetFESCount();
                Solution best = de.exec(problems[p]);
                min = best.getFitness();
                avg += min;
            }
            System.out.println(problems.getClass().getCanonicalName() + " " + avg/50);
        }
    }
}
