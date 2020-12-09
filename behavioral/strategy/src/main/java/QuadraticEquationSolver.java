public class QuadraticEquationSolver {

    private DiscriminantStrategy strategy;

    public QuadraticEquationSolver(DiscriminantStrategy strategy) {
        System.out.println("DiscriminantStrategy " + strategy.getClass().getSimpleName());
        this.strategy = strategy;
    }

    public Pair<Complex, Complex> solve(double a, double b, double c) {
        System.out.println("Solve with args=" + a + " " + b + " " + c);
        double discriminant = strategy.calculateDiscriminant(a, b, c);
        System.out.println("Discriminant " + discriminant);
        if (Double.isNaN(discriminant)) {
            Complex nan = new Complex(Double.NaN, Double.NaN);
            new Pair<>(nan, nan);
        }

        Complex res1 = new Complex(-b, 0)
                .plus(Complex.sqrt(discriminant))
                .divides(new Complex(2 * a, 0));
        Complex res2 = new Complex(-b, 0)
                .minus(Complex.sqrt(discriminant))
                .divides(new Complex(2 * a, 0));
        return new Pair<>(res1, res2);
    }
}

