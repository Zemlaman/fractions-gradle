import org.junit.Assert;
import org.junit.Test;


public class TestDivision {

    @Test
    public void testSimple() {
        var fraction = TestUtils.createFraction(15, 5);
        var result = fraction.dividedBy(new NotImplementedFraction(3, 5));

        System.out.println(fraction);
        System.out.println(result);

        Assert.assertEquals((Integer) 5, result.getNumerator());
        Assert.assertEquals((Integer) 1, result.getDenominator());
    }

    @Test
    public void testNormalisation() {
        var fraction = TestUtils.createFraction(3, 5);
        var result = fraction.dividedBy(new NotImplementedFraction(3, 5));

        System.out.println(fraction);
        System.out.println(result);

        Assert.assertEquals((Integer) 1, result.getNumerator());
        Assert.assertEquals((Integer) 1, result.getDenominator());
    }
}