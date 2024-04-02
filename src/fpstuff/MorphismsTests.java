package fpstuff;

import java.util.function.BiFunction;
import java.util.function.Function;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MorphismsTests {

    @Test
    void curry() {
        Function<Integer, Function<Integer, Integer>> curried = Morphisms.curry(this::add);
        int nine = curried.apply(4).apply(5);
        Assertions.assertEquals(9, nine);
        BiFunction<Integer, Integer, Integer> uncurried = Morphisms.uncurry(curried);
        Assertions.assertEquals(uncurried.apply(4, 5), nine);
    }

    private int add(int x, int y) {
        return x+y;
    }
}
