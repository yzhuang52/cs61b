/** An Integer tester created by Flik Enterprises. */
public class Flik {
    public static boolean isSameNumber(Integer a, Integer b) {
        return a.equals(b); //integer between -128 and 127 are already cached, no new object created, thus == -> true
    }
}
