// Generated by the LibSL translator.  DO NOT EDIT!
// sources:
//  - java/util/LinkedHashSet.lsl:20
//  - java/util/LinkedHashSet.main.lsl:25
//
package generated.java.util;

import generated.runtime.LibSLGlobals;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Cloneable;
import java.lang.IllegalArgumentException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.Void;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import runtime.LibSLRuntime;
import stub.java.util.stream.StreamLSL;

/**
 * LinkedHashSetAutomaton for LinkedHashSet ~> java.util.LinkedHashSet
 */
@SuppressWarnings({"all", "unchecked"})
@Approximate(java.util.LinkedHashSet.class)
public class LinkedHashSet implements LibSLRuntime.Automaton, Set, Cloneable, Serializable {
    private static final long serialVersionUID = -2851667679971038690L;

    static {
        Engine.assume(true);
    }

    private byte __$lsl_state = __$lsl_States.Allocated;

    public LibSLRuntime.Map<Object, Object> storage;

    public transient int modCount;

    @LibSLRuntime.AutomatonConstructor
    public LinkedHashSet(Void __$lsl_token, final byte p0,
            final LibSLRuntime.Map<Object, Object> p1, final int p2) {
        this.__$lsl_state = p0;
        this.storage = p1;
        this.modCount = p2;
    }

    @LibSLRuntime.AutomatonConstructor
    public LinkedHashSet(final Void __$lsl_token) {
        this(__$lsl_token, __$lsl_States.Allocated, null, 0);
    }

    /**
     * [CONSTRUCTOR] LinkedHashSetAutomaton::<init>(LinkedHashSet) -> void
     * Source: java/util/LinkedHashSet.main.lsl:156
     */
    public LinkedHashSet() {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            this.storage = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [CONSTRUCTOR] LinkedHashSetAutomaton::<init>(LinkedHashSet, Collection) -> void
     * Source: java/util/LinkedHashSet.main.lsl:162
     */
    public LinkedHashSet(Collection c) {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            this.storage = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
            _addAllElements(c);
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [CONSTRUCTOR] LinkedHashSetAutomaton::<init>(LinkedHashSet, int) -> void
     * Source: java/util/LinkedHashSet.main.lsl:169
     */
    public LinkedHashSet(int initialCapacity) {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            if (initialCapacity < 0) {
                throw new IllegalArgumentException();
            }
            this.storage = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [CONSTRUCTOR] LinkedHashSetAutomaton::<init>(LinkedHashSet, int, float) -> void
     * Source: java/util/LinkedHashSet.main.lsl:181
     */
    public LinkedHashSet(int initialCapacity, float loadFactor) {
        this((Void) null);
        Engine.assume(this.__$lsl_state == __$lsl_States.Allocated);
        /* body */ {
            if (initialCapacity < 0) {
                throw new IllegalArgumentException();
            }
            if ((loadFactor <= 0) || (loadFactor != loadFactor)) {
                throw new IllegalArgumentException();
            }
            this.storage = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
        }
        this.__$lsl_state = __$lsl_States.Initialized;
    }

    /**
     * [SUBROUTINE] LinkedHashSetAutomaton::_checkForComodification(int) -> void
     * Source: java/util/LinkedHashSet.main.lsl:78
     */
    public void _checkForComodification(int expectedModCount) {
        /* body */ {
            if (this.modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /**
     * [SUBROUTINE] LinkedHashSetAutomaton::_addAllElements(Collection) -> boolean
     * Source: java/util/LinkedHashSet.main.lsl:85
     */
    private boolean _addAllElements(Collection c) {
        boolean result = false;
        /* body */ {
            final int lengthBeforeAdd = this.storage.size();
            final Iterator iter = c.iterator();
            while (iter.hasNext()) {
                final Object key = iter.next();
                if (!this.storage.hasKey(key)) {
                    this.storage.set(key, LibSLGlobals.SOMETHING);
                }
            }
            ;
            if (lengthBeforeAdd != this.storage.size()) {
                this.modCount += 1;
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * [SUBROUTINE] LinkedHashSetAutomaton::_makeStream(boolean) -> Stream
     * Source: java/util/LinkedHashSet.main.lsl:122
     */
    private Stream _makeStream(boolean parallel) {
        Stream result = null;
        /* body */ {
            final LibSLRuntime.Map<Object, Object> unseen = this.storage.duplicate();
            final int count = unseen.size();
            final Object[] items = new Object[count];
            int i = 0;
            for (i = 0; i < count; i += 1) {
                final Object key = unseen.anyKey();
                unseen.remove(key);
                items[i] = key;
            }
            ;
            result = (StreamLSL) ((Object) new generated.java.util.stream.StreamLSL((Void) null, 
                /* state = */ generated.java.util.stream.StreamLSL.__$lsl_States.Initialized, 
                /* storage = */ items, 
                /* length = */ count, 
                /* closeHandlers = */ Engine.makeSymbolicList(), 
                /* isParallel = */ parallel, 
                /* linkedOrConsumed = */ false
            ));
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::add(LinkedHashSet, Object) -> boolean
     * Source: java/util/LinkedHashSet.main.lsl:201
     */
    public boolean add(Object obj) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final boolean hasKey = this.storage.hasKey(obj);
            if (hasKey) {
                result = false;
            } else {
                this.storage.set(obj, LibSLGlobals.SOMETHING);
                result = true;
            }
            this.modCount += 1;
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::clear(LinkedHashSet) -> void
     * Source: java/util/LinkedHashSet.main.lsl:219
     */
    public void clear() {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            this.storage = new LibSLRuntime.Map<>(new LibSLRuntime.HashMapContainer<>());
            this.modCount += 1;
        }
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::clone(LinkedHashSet) -> Object
     * Source: java/util/LinkedHashSet.main.lsl:226
     */
    public Object clone() {
        Object result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = (java.util.LinkedHashSet) ((Object) new LinkedHashSet((Void) null, 
                /* state = */ LinkedHashSet.__$lsl_States.Initialized, 
                /* storage = */ this.storage.duplicate(), 
                /* modCount = */ 0
            ));
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::contains(LinkedHashSet, Object) -> boolean
     * Source: java/util/LinkedHashSet.main.lsl:234
     */
    public boolean contains(Object obj) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (this.storage.size() == 0) {
                result = false;
            } else {
                result = this.storage.hasKey(obj);
            }
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::isEmpty(LinkedHashSet) -> boolean
     * Source: java/util/LinkedHashSet.main.lsl:243
     */
    public boolean isEmpty() {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.storage.size() == 0;
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::iterator(LinkedHashSet) -> Iterator
     * Source: java/util/LinkedHashSet.main.lsl:249
     */
    public Iterator iterator() {
        Iterator result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final LibSLRuntime.Map<Object, Object> unseenKeys = this.storage.duplicate();
            result = (stub.java.util.LinkedHashSet_KeyIterator) ((Object) new LinkedHashSet_KeyIterator((Void) null, 
                /* state = */ LinkedHashSet_KeyIterator.__$lsl_States.Initialized, 
                /* expectedModCount = */ this.modCount, 
                /* unseenKeys = */ unseenKeys, 
                /* parent = */ this, 
                /* index = */ 0, 
                /* currentKey = */ 0, 
                /* nextWasCalled = */ false
            ));
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::remove(LinkedHashSet, Object) -> boolean
     * Source: java/util/LinkedHashSet.main.lsl:260
     */
    public boolean remove(Object obj) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (this.storage.hasKey(obj)) {
                this.storage.remove(obj);
                this.modCount += 1;
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::size(LinkedHashSet) -> int
     * Source: java/util/LinkedHashSet.main.lsl:275
     */
    public int size() {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = this.storage.size();
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::spliterator(LinkedHashSet) -> Spliterator
     * Source: java/util/LinkedHashSet.main.lsl:281
     */
    public Spliterator spliterator() {
        Spliterator result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final Object[] keysStorageArray = new Object[this.storage.size()];
            final LibSLRuntime.Map<Object, Object> unseenKeys = this.storage.duplicate();
            int i = 0;
            for (i = 0; i < this.storage.size(); i += 1) {
                final Object key = unseenKeys.anyKey();
                unseenKeys.remove(key);
                keysStorageArray[i] = key;
            }
            ;
            result = (stub.java.util.LinkedHashSet_KeySpliterator) ((Object) new LinkedHashSet_KeySpliterator((Void) null, 
                /* state = */ LinkedHashSet_KeySpliterator.__$lsl_States.Initialized, 
                /* keysStorage = */ keysStorageArray, 
                /* index = */ 0, 
                /* fence = */ -1, 
                /* est = */ 0, 
                /* expectedModCount = */ this.modCount, 
                /* parent = */ this
            ));
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::equals(LinkedHashSet, Object) -> boolean
     * Source: java/util/LinkedHashSet.main.lsl:312
     */
    public boolean equals(Object other) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (other == this) {
                result = true;
            } else {
                if ((other != null && other.getClass() == java.util.LinkedHashSet.class)) {
                    final int expectedModCount = this.modCount;
                    final int otherExpectedModCount = ((LinkedHashSet) ((Object) other)).modCount;
                    final LibSLRuntime.Map<Object, Object> otherStorage = ((LinkedHashSet) ((Object) other)).storage;
                    if (this.storage.size() == otherStorage.size()) {
                        result = LibSLRuntime.equals(this.storage, otherStorage);
                    } else {
                        result = false;
                    }
                    ((LinkedHashSet) ((Object) other))._checkForComodification(otherExpectedModCount);
                    _checkForComodification(expectedModCount);
                } else {
                    result = false;
                }
            }
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::hashCode(LinkedHashSet) -> int
     * Source: java/util/LinkedHashSet.main.lsl:343
     */
    public int hashCode() {
        int result = 0;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = LibSLRuntime.hashCode(this.storage);
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::removeAll(LinkedHashSet, Collection) -> boolean
     * Source: java/util/LinkedHashSet.main.lsl:349
     */
    public boolean removeAll(Collection c) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (c == null) {
                throw new NullPointerException();
            }
            final int expectedModCount = this.modCount;
            final int otherSize = c.size();
            final Iterator iter = c.iterator();
            final int lengthBeforeRemoving = this.storage.size();
            int i = 0;
            if (this.storage.size() > otherSize) {
                while (iter.hasNext()) {
                    final Object key = iter.next();
                    if (this.storage.hasKey(key)) {
                        this.storage.remove(key);
                    }
                }
                ;
            } else {
                final LibSLRuntime.Map<Object, Object> unseenKeys = this.storage.duplicate();
                while (i < lengthBeforeRemoving) {
                    final Object key = unseenKeys.anyKey();
                    unseenKeys.remove(key);
                    if (c.contains(key)) {
                        this.storage.remove(key);
                    }
                    i += 1;
                }
                ;
            }
            _checkForComodification(expectedModCount);
            this.modCount += 1;
            result = lengthBeforeRemoving != this.storage.size();
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::toArray(LinkedHashSet) -> array<Object>
     * Source: java/util/LinkedHashSet.main.lsl:404
     */
    public Object[] toArray() {
        Object[] result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final int len = this.storage.size();
            result = new Object[len];
            final int expectedModCount = this.modCount;
            final LibSLRuntime.Map<Object, Object> unseenKeys = this.storage.duplicate();
            int i = 0;
            for (i = 0; i < len; i += 1) {
                final Object key = unseenKeys.anyKey();
                unseenKeys.remove(key);
                result[i] = key;
            }
            ;
            _checkForComodification(expectedModCount);
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::toArray(LinkedHashSet, array<Object>) -> array<Object>
     * Source: java/util/LinkedHashSet.main.lsl:430
     */
    public Object[] toArray(Object[] a) {
        Object[] result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final int expectedModCount = this.modCount;
            final int aLen = a.length;
            final int len = this.storage.size();
            final LibSLRuntime.Map<Object, Object> unseenKeys = this.storage.duplicate();
            int i = 0;
            if (aLen < len) {
                a = new Object[len];
            }
            result = a;
            for (i = 0; i < len; i += 1) {
                final Object key = unseenKeys.anyKey();
                unseenKeys.remove(key);
                result[i] = key;
            }
            ;
            if (aLen > len) {
                result[len] = null;
            }
            _checkForComodification(expectedModCount);
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::toArray(LinkedHashSet, IntFunction) -> array<Object>
     * Source: java/util/LinkedHashSet.main.lsl:455
     */
    public Object[] toArray(IntFunction generator) {
        Object[] result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (generator == null) {
                throw new NullPointerException();
            }
            final int len = this.storage.size();
            result = ((Object[]) generator.apply(0));
            final int expectedModCount = this.modCount;
            final LibSLRuntime.Map<Object, Object> unseenKeys = this.storage.duplicate();
            int i = 0;
            for (i = 0; i < len; i += 1) {
                final Object key = unseenKeys.anyKey();
                unseenKeys.remove(key);
                result[i] = key;
            }
            ;
            _checkForComodification(expectedModCount);
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::containsAll(LinkedHashSet, Collection) -> boolean
     * Source: java/util/LinkedHashSet.main.lsl:475
     */
    public boolean containsAll(Collection c) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final int otherSize = c.size();
            final Iterator iter = c.iterator();
            boolean isContainsAll = true;
            while (iter.hasNext()) {
                final Object key = iter.next();
                final boolean isKeyExist = this.storage.hasKey(key);
                if (!isKeyExist) {
                    isContainsAll = false;
                    break;
                }
            }
            ;
            result = isContainsAll;
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::addAll(LinkedHashSet, Collection) -> boolean
     * Source: java/util/LinkedHashSet.main.lsl:503
     */
    public boolean addAll(Collection c) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = _addAllElements(c);
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::retainAll(LinkedHashSet, Collection) -> boolean
     * Source: java/util/LinkedHashSet.main.lsl:509
     */
    public boolean retainAll(Collection c) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (c == null) {
                throw new NullPointerException();
            }
            final int lengthBeforeAdd = this.storage.size();
            final LibSLRuntime.Map<Object, Object> unseenKeys = this.storage.duplicate();
            int i = 0;
            while (i < lengthBeforeAdd) {
                final Object key = unseenKeys.anyKey();
                unseenKeys.remove(key);
                if (!c.contains(key)) {
                    this.storage.remove(key);
                }
                i += 1;
            }
            ;
            if (lengthBeforeAdd != this.storage.size()) {
                this.modCount += 1;
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::removeIf(LinkedHashSet, Predicate) -> boolean
     * Source: java/util/LinkedHashSet.main.lsl:547
     */
    public boolean removeIf(Predicate filter) {
        boolean result = false;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (filter == null) {
                throw new NullPointerException();
            }
            final int lengthBeforeAdd = this.storage.size();
            final int expectedModCount = this.modCount;
            int i = 0;
            final LibSLRuntime.Map<Object, Object> unseenKeys = this.storage.duplicate();
            while (i < lengthBeforeAdd) {
                final Object key = unseenKeys.anyKey();
                unseenKeys.remove(key);
                if (filter.test(key)) {
                    this.storage.remove(key);
                }
                i += 1;
            }
            ;
            _checkForComodification(expectedModCount);
            if (lengthBeforeAdd != this.storage.size()) {
                this.modCount += 1;
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::forEach(LinkedHashSet, Consumer) -> void
     * Source: java/util/LinkedHashSet.main.lsl:587
     */
    public void forEach(Consumer userAction) {
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            if (userAction == null) {
                throw new NullPointerException();
            }
            int i = 0;
            final int expectedModCount = this.modCount;
            final LibSLRuntime.Map<Object, Object> unseenKeys = this.storage.duplicate();
            while (i < this.storage.size()) {
                final Object key = unseenKeys.anyKey();
                unseenKeys.remove(key);
                userAction.accept(key);
                i += 1;
            }
            ;
            _checkForComodification(expectedModCount);
        }
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::stream(LinkedHashSet) -> Stream
     * Source: java/util/LinkedHashSet.main.lsl:617
     */
    public Stream stream() {
        Stream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = _makeStream(false);
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::parallelStream(LinkedHashSet) -> Stream
     * Source: java/util/LinkedHashSet.main.lsl:624
     */
    public Stream parallelStream() {
        Stream result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            result = _makeStream(true);
        }
        return result;
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::writeObject(LinkedHashSet, ObjectOutputStream) -> void
     * Source: java/util/LinkedHashSet.main.lsl:632
     */
    private void writeObject(ObjectOutputStream s) throws java.io.IOException {
        /* body */ {
            LibSLRuntime.not_implemented(/* no serialization support yet */);
        }
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::readObject(LinkedHashSet, ObjectInputStream) -> void
     * Source: java/util/LinkedHashSet.main.lsl:639
     */
    private void readObject(ObjectInputStream s) throws java.io.IOException,
            java.lang.ClassNotFoundException {
        /* body */ {
            LibSLRuntime.not_implemented(/* no serialization support yet */);
        }
    }

    /**
     * [FUNCTION] LinkedHashSetAutomaton::toString(LinkedHashSet) -> String
     * Source: java/util/LinkedHashSet.main.lsl:647
     */
    public String toString() {
        String result = null;
        Engine.assume(this.__$lsl_state == __$lsl_States.Initialized);
        /* body */ {
            final LibSLRuntime.Map<Object, Object> items = this.storage;
            int count = items.size();
            if (count == 0) {
                result = "[]";
            } else {
                Engine.assume(count > 0);
                result = "[";
                final LibSLRuntime.Map<Object, Object> unseen = items.duplicate();
                while (count != 0) {
                    final Object key = unseen.anyKey();
                    unseen.remove(key);
                    result = result.concat(LibSLRuntime.toString(key));
                    if (count > 1) {
                        result = result.concat(", ");
                    }
                    count -= 1;
                }
                ;
                result = result.concat("]");
            }
        }
        return result;
    }

    public static final class __$lsl_States {
        public static final byte Allocated = (byte) 0;

        public static final byte Initialized = (byte) 1;
    }

    @Approximate(LinkedHashSet.class)
    public static final class __hook {
        private __hook(Void o1, Void o2) {
            Engine.assume(false);
        }
    }
}
