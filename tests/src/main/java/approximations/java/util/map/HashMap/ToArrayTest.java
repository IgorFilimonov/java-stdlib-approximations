package approximations.java.util.map.HashMap;

import approximations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;

@Test
public class ToArrayTest {
    /*@Test
    public static int test_ToArray (int execution) { // gotta implement Arrays.mismatch
        checkMap(false);
        checkMap(true);
        checkSet(false);
        checkSet(true);
        return execution;
    }

    private static <T extends Comparable<T>> void checkToArray(String message, T[] expected, Collection<T> collection,
                                                               boolean ignoreOrder) {
        if (ignoreOrder) {
            Arrays.sort(expected);
        }
        checkToObjectArray(message, expected, collection, ignoreOrder);
        checkToTypedArray(message, expected, Arrays.copyOf(expected, 0), collection, ignoreOrder);
        checkToTypedArray(message, expected, expected.clone(), collection, ignoreOrder);
        if (expected.length > 0) {
            T[] biggerArray = Arrays.copyOf(expected, expected.length * 2);
            System.arraycopy(expected, 0, biggerArray, expected.length, expected.length);
            checkToTypedArray(message, expected, biggerArray, collection, ignoreOrder);
        }
    }

    private static <T extends Comparable<T>> void checkToTypedArray(String message, T[] expected, T[] inputArray,
                                                                    Collection<T> collection, boolean ignoreOrder) {
        T[] res = collection.toArray(inputArray);
        if (expected.length <= inputArray.length && res != inputArray) {
            throw new AssertionError(message + ": not the same array returned");
        }
        if (res.getClass() != expected.getClass()) {
            throw new AssertionError(message + ": wrong class returned: " + res.getClass());
        }
        if (res.length < expected.length) {
            throw new AssertionError(message + ": length is smaller than expected: " + res.length + " < " + expected.length);
        }
        if (ignoreOrder) {
            Arrays.sort(res, 0, Math.min(res.length, expected.length));
        }
        if (inputArray.length <= expected.length) {
            if (!Arrays.equals(res, expected)) {
                throw new AssertionError(message + ": not equal: " + Arrays.toString(expected) + " != " +
                        Arrays.toString(res));
            }
        } else {
            int mismatch = Arrays.mismatch(expected, res);
            if (mismatch != expected.length) {
                throw new AssertionError(message + ": mismatch at " + mismatch);
            }
            if (res[expected.length] != null) {
                throw new AssertionError(message + ": no null at position " + expected.length);
            }
            // The tail of bigger array after expected.length position must be untouched
            mismatch = Arrays
                    .mismatch(expected, 1, expected.length, res, expected.length + 1, res.length);
            if (mismatch != -1) {
                throw new AssertionError(message + ": mismatch at " + mismatch);
            }
        }
    }

    private static <T extends Comparable<T>> void checkToObjectArray(String message, T[] expected,
                                                                     Collection<T> collection, boolean ignoreOrder) {
        Object[] objects = collection.toArray();
        if (objects.getClass() != Object[].class) {
            throw new AssertionError(message + ": wrong class returned: " + objects.getClass());
        }
        if (ignoreOrder) {
            Arrays.sort(objects);
        }
        int mismatch = Arrays.mismatch(expected, objects);
        if (mismatch != -1) {
            throw new AssertionError(message + ": mismatch at " + mismatch);
        }
    }

    private static void checkMap(boolean ordered) {
        Map<String, String> map = ordered ? new LinkedHashMap<>() : new HashMap<>();
        checkToArray("Empty-keys", new String[0], map.keySet(), !ordered);
        checkToArray("Empty-values", new String[0], map.values(), !ordered);

        List<String> keys = new ArrayList<>();
        List<String> values = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            keys.add(String.valueOf(i));
            values.add(String.valueOf(i * 2));
            map.put(String.valueOf(i), String.valueOf(i * 2));
            checkToArray(i + "-keys", keys.toArray(new String[0]), map.keySet(), !ordered);
            checkToArray(i + "-values", values.toArray(new String[0]), map.values(), !ordered);
        }
        map.clear();
        checkToArray("Empty-keys", new String[0], map.keySet(), !ordered);
        checkToArray("Empty-values", new String[0], map.values(), !ordered);
    }

    private static void checkSet(boolean ordered) {
        Collection<String> set = ordered ? new LinkedHashSet<>() : new HashSet<>();
        checkToArray("Empty", new String[0], set, !ordered);
        set.add("foo");
        checkToArray("One", new String[]{"foo"}, set, !ordered);
        set.add("bar");
        checkToArray("Two", new String[]{"foo", "bar"}, set, !ordered);

        Collection<Long> longSet = ordered ? new LinkedHashSet<>() : new HashSet<>();
        for (int x = 0; x < 100; x++) {
            longSet.add((long) x);
        }
        checkToArray("100", LongStream.range(0, 100).boxed().toArray(Long[]::new), longSet, !ordered);
        longSet.clear();
        checkToArray("After clear", new Long[0], longSet, !ordered);
        for (int x = 0; x < 100; x++) {
            longSet.add(((long) x) | (((long) x) << 32));
        }
        checkToArray("Collisions", LongStream.range(0, 100).mapToObj(x -> x | (x << 32))
                .toArray(Long[]::new), longSet, !ordered);
    }*/
}
