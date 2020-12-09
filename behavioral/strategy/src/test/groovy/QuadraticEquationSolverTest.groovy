import spock.lang.Specification

class QuadraticEquationSolverTest extends Specification {
    def "Solve quadratic expression"() {
        given:
        def solver = new QuadraticEquationSolver(new RealDiscriminantStrategy())
        when:
        def result = solver.solve(1, 10, 16)
        then:
        result.first == new Complex(-2, 0)
        result.second == new Complex(-8, 0)
    }
}
