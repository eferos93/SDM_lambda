import java.awt.*;
import java.util.function.Function;
import java.util.stream.Stream;

@FunctionalInterface
interface ArrayFunction {
    int apply(int[] a);
}

public class Lambda {



    public static void main(String[] args) {
        Function<Integer, Integer> const2 = x -> 2;
        Function<Integer, Integer> half = x -> x/2;
        Function<Integer, Boolean> isEven = x -> x%2 == 0;
        Function<Integer, Integer> quarter = half.compose(half);

        ArrayFunction size = a -> a.length;

        ArrayFunction positive;
    }
}
