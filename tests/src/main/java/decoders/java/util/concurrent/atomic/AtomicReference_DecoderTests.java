package decoders.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

@SuppressWarnings({"unused", "UnnecessaryUnboxing"})
public final class AtomicReference_DecoderTests {

    public static int test_0(final AtomicReference<?> obj) {
        final Object value = obj.get();

        if (value == null)
            return 0;

        if (value instanceof Integer && ((Integer) value).intValue() == 73)
            return 1;

        if ("XYZ".equals(value))
            return 2;

        return 3;
    }

}
