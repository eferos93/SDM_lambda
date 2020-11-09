import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@FunctionalInterface
interface ArrayFunction {
    int apply(int[] a);
}

public class Lambda {

    static ArrayList<Integer> select(ArrayList<Integer> list,
                                     Predicate<Integer> pred,
                                     Function<Integer, Integer> func) {
        /*ArrayList<Integer> result = new ArrayList<>();
        for (Integer elem : list) {
            if(pred.test(elem)) {
                result.add(func.apply(elem));
            }
        }
        return result;*/
        return list.stream()
                .filter(pred)
                .map(func)
                .collect(Collectors.toCollection(ArrayList::new));

    }

    public static void main(String[] args) {
        Function<Integer, Integer> const2 = x -> 2;
        Function<Integer, Integer> half = x -> x/2;
        Predicate<Integer> isEven = x -> x%2 == 0;
        Function<Integer, Integer> quarter = half.compose(half);

        ArrayFunction size = a -> a.length;

        ArrayFunction positive = a -> {
            int posNumbers = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] > 0) {
                    posNumbers++;
                }
            }
            return posNumbers;
        };

        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,8,5,2,3,4,15,20));
        ArrayList<Integer> list2 = select(list1, isEven, half);
        for (Integer x : list2)
            System.out.println(x);

        BiFunction<Integer, Integer, Integer> f1 = (x, y) -> x + y;
        Function<Integer, Function<Integer, Integer>> f2 = x -> y -> f1.apply(x, y);
        System.out.println(f1.apply(2, 3));
        System.out.println(f2.apply(2).apply(3));
    }
}