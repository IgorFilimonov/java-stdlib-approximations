package encoders.util;

import org.usvm.api.encoder.EncoderFor;
import org.usvm.api.encoder.ObjectEncoder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@EncoderFor(HashSet.class)
public class HashSet_Encoder implements ObjectEncoder {

    @Override
    public Object encode(Object object) {
        generated.java.util.HashSet result = new generated.java.util.HashSet();
        result.addAll(Arrays.asList(((Set<?>) object).toArray()));
        return result;
    }
}
