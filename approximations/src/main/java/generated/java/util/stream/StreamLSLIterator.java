// Generated by the LibSL translator.  DO NOT EDIT!
// source: ?
//
package generated.java.util.stream;

import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.SuppressWarnings;
import java.lang.UnsupportedOperationException;
import java.lang.Void;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;

/**
 * StreamIteratorAutomaton for StreamLSLIterator ~> java.util.stream.StreamLSLIterator
 */
@SuppressWarnings({"all", "unchecked"})
@Approximate(stub.java.util.stream.StreamLSLIterator.class)
public class StreamLSLIterator implements LibSLRuntime.Automaton, Iterator {
    static {
        Engine.assume(true);
    }

    public StreamLSL parent;

    public int cursor;

    @LibSLRuntime.AutomatonConstructor
    public StreamLSLIterator(Void __$lsl_token, final byte p0, final StreamLSL p1, final int p2) {
        this.parent = p1;
        this.cursor = p2;
    }

    @LibSLRuntime.AutomatonConstructor
    public StreamLSLIterator(final Void __$lsl_token) {
        this(__$lsl_token, __$lsl_States.Initialized, null, 0);
    }

    /**
     * [FUNCTION] StreamIteratorAutomaton::hasNext(StreamLSLIterator) -> boolean
     */
    public boolean hasNext() {
        boolean result = false;
        /* body */ {
            Engine.assume(this.parent != null);
            result = this.cursor != ((StreamLSL) ((Object) this.parent)).length;
        }
        return result;
    }

    /**
     * [FUNCTION] StreamIteratorAutomaton::next(StreamLSLIterator) -> Object
     */
    public Object next() {
        Object result = null;
        /* body */ {
            Engine.assume(this.parent != null);
            final Object[] parentStorage = ((StreamLSL) ((Object) this.parent)).storage;
            final int i = this.cursor;
            if (i >= ((StreamLSL) ((Object) this.parent)).length) {
                throw new NoSuchElementException();
            }
            this.cursor = i + 1;
            result = parentStorage[i];
        }
        return result;
    }

    /**
     * [FUNCTION] StreamIteratorAutomaton::remove(StreamLSLIterator) -> void
     */
    public void remove() {
        /* body */ {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * [FUNCTION] StreamIteratorAutomaton::forEachRemaining(StreamLSLIterator, Consumer) -> void
     */
    public void forEachRemaining(Consumer userAction) {
        /* body */ {
            Engine.assume(this.parent != null);
            if (userAction == null) {
                throw new NullPointerException();
            }
            int i = this.cursor;
            final int size = ((StreamLSL) ((Object) this.parent)).length;
            if (i != size) {
                final Object[] pStorage = ((StreamLSL) ((Object) this.parent)).storage;
                while (i < size) {
                    final Object item = pStorage[i];
                    userAction.accept(item);
                    i += 1;
                }
                ;
                this.cursor = i;
            }
        }
    }

    public static final class __$lsl_States {
        public static final byte Initialized = (byte) 0;
    }

    @Approximate(StreamLSLIterator.class)
    public static final class __hook {
        private __hook(Void o1, Void o2) {
            Engine.assume(false);
        }
    }
}
