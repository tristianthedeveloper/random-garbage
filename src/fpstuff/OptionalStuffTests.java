package fpstuff;

import java.util.Optional;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OptionalStuffTests {


    @Test
    void liftA2() {
        BiFunction<Integer, Integer, Integer> add = Integer::sum;
        Assertions.assertEquals(Optional.empty(), OptionalStuff.liftA2(add, Optional.of(4), Optional.empty()));
        Assertions.assertEquals(Optional.of(9), OptionalStuff.liftA2(add, Optional.of(4), Optional.of(5)));
    }
}
