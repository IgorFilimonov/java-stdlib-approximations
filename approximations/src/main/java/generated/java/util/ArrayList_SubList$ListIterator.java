// Generated by the LibSL translator.  DO NOT EDIT!
// source: ?
//
package generated.java.util;

import java.lang.IllegalStateException;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.SuppressWarnings;
import java.lang.Void;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import org.jacodb.approximation.annotation.Approximate;
import org.usvm.api.Engine;
import org.usvm.api.SymbolicList;
import runtime.LibSLRuntime;

/**
 * ArrayList_SubList_ListIteratorAutomaton for ArrayList_SubList_ListIterator ~> java.util.ArrayList_SubList$ListIterator
 */
@SuppressWarnings({"all", "unchecked"})
@Approximate(stub.java.util.ArrayList_SubList$ListIterator.class)
public final class ArrayList_SubList$ListIterator implements LibSLRuntime.Automaton, ListIterator {
    static {
        Engine.assume(true);
    }

    public ArrayList root;

    public ArrayList_SubList sublist;

    public int cursor;

    public int expectedModCount;

    public int offset;

    public int size;

    public int lastRet;

    @LibSLRuntime.AutomatonConstructor
    public ArrayList_SubList$ListIterator(Void __$lsl_token, final byte p0, final ArrayList p1,
            final ArrayList_SubList p2, final int p3, final int p4, final int p5, final int p6,
            final int p7) {
        this.root = p1;
        this.sublist = p2;
        this.cursor = p3;
        this.expectedModCount = p4;
        this.offset = p5;
        this.size = p6;
        this.lastRet = p7;
    }

    @LibSLRuntime.AutomatonConstructor
    public ArrayList_SubList$ListIterator(final Void __$lsl_token) {
        this(__$lsl_token, __$lsl_States.Initialized, null, null, 0, 0, 0, 0, -1);
    }

    /**
     * [SUBROUTINE] ArrayList_SubList_ListIteratorAutomaton::_checkForComodification() -> void
     */
    private void _checkForComodification() {
        /* body */ {
            final int modCount = ((ArrayList) ((Object) this.root)).modCount;
            if (modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /**
     * [FUNCTION] ArrayList_SubList_ListIteratorAutomaton::hasPrevious(ArrayList_SubList_ListIterator) -> boolean
     */
    public boolean hasPrevious() {
        boolean result = false;
        /* body */ {
            result = this.cursor != 0;
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayList_SubList_ListIteratorAutomaton::nextIndex(ArrayList_SubList_ListIterator) -> int
     */
    public int nextIndex() {
        int result = 0;
        /* body */ {
            result = this.cursor;
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayList_SubList_ListIteratorAutomaton::previousIndex(ArrayList_SubList_ListIterator) -> int
     */
    public int previousIndex() {
        int result = 0;
        /* body */ {
            result = this.cursor - 1;
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayList_SubList_ListIteratorAutomaton::hasNext(ArrayList_SubList_ListIterator) -> boolean
     */
    public boolean hasNext() {
        boolean result = false;
        /* body */ {
            result = this.cursor != this.size;
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayList_SubList_ListIteratorAutomaton::next(ArrayList_SubList_ListIterator) -> Object
     */
    public Object next() {
        Object result = null;
        /* body */ {
            Engine.assume(this.root != null);
            _checkForComodification();
            final SymbolicList<Object> rootStorage = ((ArrayList) ((Object) this.root)).storage;
            final int i = this.offset + this.cursor;
            if (i >= rootStorage.size()) {
                throw new NoSuchElementException();
            }
            this.lastRet = this.cursor;
            this.cursor += 1;
            result = rootStorage.get(i);
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayList_SubList_ListIteratorAutomaton::previous(ArrayList_SubList_ListIterator) -> Object
     */
    public Object previous() {
        Object result = null;
        /* body */ {
            Engine.assume(this.root != null);
            _checkForComodification();
            final int i = (this.offset + this.cursor) - 1;
            if (i < this.offset) {
                throw new NoSuchElementException();
            }
            final SymbolicList<Object> rootStorage = ((ArrayList) ((Object) this.root)).storage;
            if (i >= rootStorage.size()) {
                throw new ConcurrentModificationException();
            }
            this.cursor -= 1;
            this.lastRet = this.cursor;
            result = rootStorage.get(i);
        }
        return result;
    }

    /**
     * [FUNCTION] ArrayList_SubList_ListIteratorAutomaton::remove(ArrayList_SubList_ListIterator) -> void
     */
    public void remove() {
        /* body */ {
            Engine.assume(this.root != null);
            if (this.lastRet < 0) {
                throw new IllegalStateException();
            }
            _checkForComodification();
            if (this.lastRet >= this.size) {
                throw new ConcurrentModificationException();
            } else {
                ((ArrayList) ((Object) this.root))._deleteElement(this.offset + this.lastRet);
                ((ArrayList_SubList) ((Object) this.sublist))._updateSizeAndModCount(-1);
                this.expectedModCount = ((ArrayList) ((Object) this.root)).modCount;
                this.size -= 1;
            }
            this.cursor = this.lastRet;
            this.lastRet = -1;
        }
    }

    /**
     * [FUNCTION] ArrayList_SubList_ListIteratorAutomaton::set(ArrayList_SubList_ListIterator, Object) -> void
     */
    public void set(Object e) {
        /* body */ {
            Engine.assume(this.root != null);
            if (this.lastRet < 0) {
                throw new IllegalStateException();
            }
            _checkForComodification();
            final SymbolicList<Object> rootStorage = ((ArrayList) ((Object) this.root)).storage;
            final int index = this.offset + this.lastRet;
            if (index >= rootStorage.size()) {
                throw new ConcurrentModificationException();
            } else {
                rootStorage.set(index, e);
            }
        }
    }

    /**
     * [FUNCTION] ArrayList_SubList_ListIteratorAutomaton::add(ArrayList_SubList_ListIterator, Object) -> void
     */
    public void add(Object e) {
        /* body */ {
            Engine.assume(this.root != null);
            _checkForComodification();
            final int i = this.offset + this.cursor;
            if ((this.offset + this.lastRet) > ((ArrayList) ((Object) this.root)).storage.size()) {
                throw new ConcurrentModificationException();
            } else {
                ((ArrayList) ((Object) this.root))._addElement(i, e);
                ((ArrayList_SubList) ((Object) this.sublist))._updateSizeAndModCount(1);
                this.expectedModCount = ((ArrayList) ((Object) this.root)).modCount;
                this.size += 1;
            }
            this.cursor += 1;
            this.lastRet = -1;
        }
    }

    /**
     * [FUNCTION] ArrayList_SubList_ListIteratorAutomaton::forEachRemaining(ArrayList_SubList_ListIterator, Consumer) -> void
     */
    public void forEachRemaining(Consumer userAction) {
        /* body */ {
            Engine.assume(this.root != null);
            if (userAction == null) {
                throw new NullPointerException();
            }
            int i = this.cursor;
            if (i < this.size) {
                i += this.offset;
                final SymbolicList<Object> es = ((ArrayList) ((Object) this.root)).storage;
                if (i >= es.size()) {
                    throw new ConcurrentModificationException();
                }
                final int end = this.offset + this.size;
                for (i = i; i < end; i += 1) {
                    final Object item = es.get(i);
                    userAction.accept(item);
                }
                ;
                this.cursor = i - this.offset;
                this.lastRet = this.cursor - 1;
                _checkForComodification();
            }
        }
    }

    public static final class __$lsl_States {
        public static final byte Initialized = (byte) 0;
    }

    @Approximate(ArrayList_SubList$ListIterator.class)
    public static final class __hook {
        private __hook(Void o1, Void o2) {
            Engine.assume(false);
        }
    }
}
