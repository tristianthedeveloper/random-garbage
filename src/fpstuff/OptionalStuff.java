package fpstuff;

import java.util.Optional;
import java.util.function.BiFunction;

public class OptionalStuff {

    public static <T, U, V> Optional<V> liftA2(BiFunction<? super T, ? super U, ? extends V> f,
                                               Optional<? extends T> t,
                                               Optional<? extends U> u) {
        return t.flatMap(x -> u.map(y -> f.apply(x, y)));
    }

}


