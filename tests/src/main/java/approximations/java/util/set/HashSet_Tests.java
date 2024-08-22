package approximations.java.util.set;

import approximations.Test;

import java.io.*;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Test
public class HashSet_Tests {
    private static final int NUM_SETS = 10;
    private static final int MAX_CAPACITY = 20;
    private static final float MAX_LOAD_FACTOR = 100.0F;

    private static final Random rnd = new Random();

    private static HashSet<Integer> createHashSet() {
        int capacity = rnd.nextInt(MAX_CAPACITY);
        float loadFactor = Float.MIN_VALUE + rnd.nextFloat()*MAX_LOAD_FACTOR;
        HashSet<Integer> hashSet = new HashSet<>(capacity, loadFactor);
        float multiplier = 2*rnd.nextFloat(); // range [0,2]
        int size = (int)(capacity*loadFactor*multiplier);
        for (int i = 0; i < size; i++) {
            hashSet.add(rnd.nextInt());
        }
        return hashSet;
    }

    private static HashSet<Integer> serDeser(HashSet<Integer> hashSet) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(hashSet);
        oos.flush();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        HashSet<Integer> result = (HashSet<Integer>)ois.readObject();

        oos.close();
        ois.close();

        return result;
    }

    @Test
    public static int test_Serialization (int execution) {
        int failures = 0;

        for (int i = 0; i < NUM_SETS; i++) {
            HashSet<Integer> hashSet = createHashSet();

            HashSet<Integer> result = null;
            try {
                result = serDeser(hashSet);
            } catch (IOException | ClassNotFoundException ioe) {
                failures++;
            }

            if (!hashSet.equals(result)) {
                failures++;
            }
        }

        if (failures != 0) {
            return -1;
        } else {
            return execution;
        }
    }
}
