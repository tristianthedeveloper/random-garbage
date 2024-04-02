package fpstuff;

import java.util.Optional;
import java.util.function.BiFunction;

public class OptionalStuff {

    /**
     *
     * @param f The function to lift.
     * @param t First param
     * @param u Second param
     * @return Lift the function and apply it.
     */
    public static <T, U, V> Optional<V> liftA2(BiFunction<? super T, ? super U, ? extends V> f,
                                               Optional<? extends T> t,
                                               Optional<? extends U> u) {
        return t.flatMap(x -> u.map(y -> f.apply(x, y)));
    }

    /** Lift a function into the <code>Optional</code> world
     *
     * @param f The function.
     * @return A lifted function
     */
    public static <T, U, V> BiFunction<Optional<T>, Optional<U>, Optional<V>> liftA2(BiFunction<T, U, ? extends V> f) {
        return (x, y) -> x.flatMap(a -> y.map(b -> f.apply(a, b)));
    }

}


