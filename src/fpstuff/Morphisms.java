package fpstuff;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 *  The functions in here are pretty useless in most situations.
 *  closure creation overhead means these might be slow enough so that their elegance isnt worth it.
 */
public class Morphisms {

    /** Takes a function that takes two parameters, and returns a curried version of the function,
     * A sequence of two functions each taking one argument.
     *
     * @param f The function to curry
     * @return A curried version of the function.
     */
    public static <A, B, C> Function<A, Function<B, C>> curry(BiFunction<? super A, ? super B, ? extends C> f) {
        return (A a) -> (B b) -> f.apply(a, b);
    }

    /** Uncurries a function.
     * <p>
     * think of it like this:
     * <p>
     * uncurry :: (a -> b -> c) -> (a, b) -> c
     *
     * @param f The function to uncurry
     * @return An uncurried version of this function.
     */
    public static <A, B, C> BiFunction<A, B, C> uncurry(Function<A, Function<B, C>> f) {
        return (a, b) -> f.apply(a).apply(b);
    }
}
