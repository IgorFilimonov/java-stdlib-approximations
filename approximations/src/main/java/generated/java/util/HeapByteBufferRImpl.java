package generated.java.util;

import jdk.internal.access.foreign.MemorySegmentProxy;
import org.jacodb.approximation.annotation.Approximate;

import java.nio.*;
import java.util.Objects;

@Approximate(stub.java.util.HeapByteBufferR.class)
public class HeapByteBufferRImpl extends HeapByteBufferImpl {
    HeapByteBufferRImpl(int cap, int lim) {
        super(cap, lim);
        this.isReadOnly = true;
    }

    HeapByteBufferRImpl(byte[] buf, int off, int len) {
        super(buf, off, len);
        this.isReadOnly = true;
    }

    protected HeapByteBufferRImpl(byte[] buf, int mark, int pos, int lim, int cap, int off) {
        super(buf, mark, pos, lim, cap, off);
        this.isReadOnly = true;
    }

    public ByteBufferImpl slice() {
        int pos = this.position();
        int lim = this.limit();
        int rem = (pos <= lim ? lim - pos : 0);
        return new HeapByteBufferRImpl(storage, -1, 0, rem, rem, pos + offset);
    }

    @Override
    public ByteBufferImpl slice(int index, int length) {
        checkFromIndexSize(index, length, limit());
        return new HeapByteBufferRImpl(storage, -1, 0, length, length, index + offset);
    }

    public ByteBufferImpl duplicate() {
        return new HeapByteBufferRImpl(storage, this.markValue(), this.position(), this.limit(), this.capacity(),
                offset);
    }

    public ByteBufferImpl asReadOnlyBuffer() {
        return duplicate();
    }

    public boolean isReadOnly() {
        return true;
    }

    public ByteBufferImpl put(byte x) {
        throw new ReadOnlyBufferException();
    }

    public ByteBufferImpl put(int i, byte x) {
        throw new ReadOnlyBufferException();
    }

    public ByteBufferImpl put(byte[] src, int offset, int length) {
        throw new ReadOnlyBufferException();
    }

    public ByteBufferImpl put(ByteBufferImpl src) {
        throw new ReadOnlyBufferException();
    }

    public ByteBufferImpl put(int index, ByteBufferImpl src, int offset, int length) {
        throw new ReadOnlyBufferException();
    }

    public ByteBufferImpl put(int index, byte[] src, int offset, int length) {
        throw new ReadOnlyBufferException();
    }

    public ByteBufferImpl compact() {
        throw new ReadOnlyBufferException();
    }

    void _put(int i, byte b) {
        throw new ReadOnlyBufferException();
    }

    public ByteBufferImpl putChar(char x) {
        throw new ReadOnlyBufferException();
    }

    public ByteBufferImpl putChar(int i, char x) {
        throw new ReadOnlyBufferException();
    }

    public CharBuffer asCharBuffer() {
       throw new UnsupportedOperationException("Not implemented yet");
    }

    public ByteBufferImpl putShort(short x) {
        throw new ReadOnlyBufferException();
    }

    public ByteBufferImpl putShort(int i, short x) {
        throw new ReadOnlyBufferException();
    }

    public ShortBuffer asShortBuffer() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public ByteBufferImpl putInt(int x) {
        throw new ReadOnlyBufferException();
    }

    public ByteBufferImpl putInt(int i, int x) {
        throw new ReadOnlyBufferException();
    }

    public IntBuffer asIntBuffer() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public ByteBufferImpl putLong(long x) {
        throw new ReadOnlyBufferException();
    }

    public ByteBufferImpl putLong(int i, long x) {
        throw new ReadOnlyBufferException();
    }

    public LongBuffer asLongBuffer() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public ByteBufferImpl putFloat(float x) {
        throw new ReadOnlyBufferException();
    }

    public ByteBufferImpl putFloat(int i, float x) {
        throw new ReadOnlyBufferException();
    }

    public FloatBuffer asFloatBuffer() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public ByteBufferImpl putDouble(double x) {
        throw new ReadOnlyBufferException();
    }

    public ByteBufferImpl putDouble(int i, double x) {
        throw new ReadOnlyBufferException();
    }

    public DoubleBuffer asDoubleBuffer() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
