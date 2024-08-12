package approximations.java.util.optional;

import approximations.Test;

import java.util.NoSuchElementException;
import java.util.OptionalInt;
import java.util.concurrent.atomic.AtomicBoolean;

@Test
public class BasicIntTest {
    static final int INTVAL = 33_550_336;
    static final int UNEXPECTED = 0xCAFEBABE;

    /**
     * Checks a block of assertions over an empty OptionalInt.
     */
    int checkEmpty (OptionalInt empty, int execution) {
        if (!empty.equals(OptionalInt.empty())) {
            return -1;
        }
        if (!OptionalInt.empty().equals(empty)) {
            return -1;
        }
        if (empty.equals(OptionalInt.of(UNEXPECTED))) {
            return -1;
        }
        if (OptionalInt.of(UNEXPECTED).equals(empty)) {
            return -1;
        }
        if (empty.equals("unexpected")) {
            return -1;
        }

        if (empty.isPresent()) {
            return -1;
        }
        //if (!empty.isEmpty());
        if (empty.hashCode() != 0) {
            return -1;
        }
        if (empty.orElse(UNEXPECTED) != UNEXPECTED) {
            return -1;
        }
        if (empty.orElseGet(() -> UNEXPECTED) != UNEXPECTED) {
            return -1;
        }

        try {
            empty.getAsInt();
            return -1;
        } catch (NoSuchElementException e) {
        }
        //assertThrows(NoSuchElementException.class, () -> empty.orElseThrow());
        //assertThrows(ObscureException.class,       () -> empty.orElseThrow(ObscureException::new));

        AtomicBoolean b = new AtomicBoolean();
        empty.ifPresent(s -> b.set(true));
        if (b.get()) {
            return -1;
        }

        AtomicBoolean b1 = new AtomicBoolean(false);
        AtomicBoolean b2 = new AtomicBoolean(false);
        empty.ifPresent(s -> b1.set(true));
        if (!b1.get()) {
            b2.set(true);
        }
        if (b1.get()) {
            return -1;
        }
        if (!b2.get()) {
            return -1;
        }

        if (empty.toString() != "OptionalInt.empty") {
            return -1;
        }
        return execution;
    }

    /**
     * Checks a block of assertions over an OptionalInt that is expected to
     * have a particular value present.
     */
    int checkPresent(OptionalInt opt, int expected, int execution) {
        if (opt.equals(OptionalInt.empty())) {
            return -1;
        }
        if (OptionalInt.empty().equals(opt)) {
            return -1;
        }
        if (!opt.equals(OptionalInt.of(expected))) {
            return -1;
        }
        if (!OptionalInt.of(expected).equals(opt)) {
            return -1;
        }
        if (opt.equals(OptionalInt.of(UNEXPECTED))) {
            return -1;
        }
        if (OptionalInt.of(UNEXPECTED).equals(opt)) {
            return -1;
        }
        if (opt.equals("unexpected")) {
            return -1;
        }

        if (!opt.isPresent()) {
            return -1;
        }
        //assertFalse(opt.isEmpty());
        if (opt.hashCode() != Integer.hashCode(expected)) {
            return -1;
        }
        if (opt.orElse(UNEXPECTED) != expected) {
            return -1;
        }
        if (opt.orElseGet(() -> UNEXPECTED) != expected) {
            return -1;
        }

        if (opt.getAsInt() != expected) {
            return -1;
        }
        //assertEquals(opt.orElseThrow(), expected);
        //assertEquals(opt.orElseThrow(ObscureException::new), expected);

        AtomicBoolean b = new AtomicBoolean(false);
        opt.ifPresent(s -> b.set(true));
        if (!b.get()) {
            return -1;
        }

        AtomicBoolean b1 = new AtomicBoolean(false);
        AtomicBoolean b2 = new AtomicBoolean(false);
        opt.ifPresent(s -> b1.set(true));
        if (!b1.get()) {
            b2.set(true);
        }
        if (!b1.get()) {
            return -1;
        }
        if (b2.get()) {
            return -1;
        }

        if (opt.toString() != "OptionalInt[" + expected + "]") {
            return -1;
        }
        return execution;
    }

    @Test
    public int test_Empty (int execution) {
        return checkEmpty(OptionalInt.empty(), execution);
    }

    @Test
    public int test_Present (int execution) {
        return checkPresent(OptionalInt.of(INTVAL), INTVAL, execution);
    }

    @Test(disabled = true)
    public int test_StreamEmpty (int execution) {
        //assertEquals(OptionalInt.empty().stream().toArray(), new int[] { });
        return execution;
    }

    @Test(disabled = true)
    public int test_StreamPresent (int execution) {
        //assertEquals(OptionalInt.of(INTVAL).stream().toArray(), new int[] { INTVAL });
        return execution;
    }
}
