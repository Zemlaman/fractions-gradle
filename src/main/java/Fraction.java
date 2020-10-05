public class Fraction implements IFraction {

    private final Integer numerator;
    private final Integer denominator;

    public Fraction(Integer numerator, Integer denominator) {
        this.numerator = numerator;
        this.denominator = denominator;

        if (denominator == 0) throw new ArithmeticException("Kde jsi viděl dělit nulou šašku??");
    }

    @Override
    public Integer getNumerator() {
        return numerator;
    }

    @Override
    public Integer getDenominator() {
        return denominator;
    }

    @Override
    public IFraction plus(IFraction other) {
        var sameNum = getDenominator() * other.getDenominator();
        var newUp = (getNumerator() * other.getDenominator()) + (other.getNumerator() * getDenominator());
        return createNormalised(newUp, sameNum);
    }

    @Override
    public IFraction minus(IFraction other) {
        var sameNum = getDenominator() * other.getDenominator();
        var newUp = (getNumerator() * other.getDenominator()) - (other.getNumerator() * getDenominator());
        return createNormalised(newUp, sameNum);
    }

    @Override
    public IFraction times(IFraction other) {
        var newUp = getNumerator() * other.getNumerator();
        var newDown = getDenominator() * other.getDenominator();
        return createNormalised(newUp, newDown);
    }

    @Override
    public IFraction dividedBy(IFraction other) {
        var newUp = getNumerator() * other.getDenominator();
        var newDown = getDenominator() * other.getNumerator();
        return createNormalised(newUp, newDown);
    }

    public static Fraction createNormalised(Integer numerator, Integer denominator) {
        var gcd = gcdByEuclidsAlgorithm(numerator, denominator);
        return new Fraction(numerator / gcd, denominator / gcd);
    }

    private static int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }


    @Override
    public String toString() {
        return "Fraction " + numerator + "|" + denominator;
    }
}