package stub.java.util;

import java.nio.ByteOrder;
import java.nio.IntBuffer;

public class HeapIntBuffer {
    HeapIntBuffer(int cap, int lim) {
        throw new LinkageError();
    }

    HeapIntBuffer(int[] buf, int off, int len) {
        throw new LinkageError();
    }

    protected HeapIntBuffer(int[] buf, int mark, int pos, int lim, int cap, int off) {
        throw new LinkageError();
    }

    public IntBuffer slice() {
        throw new LinkageError();
    }

    public IntBuffer slice(int index, int length) {
        throw new LinkageError();
    }

    public IntBuffer duplicate() {
        throw new LinkageError();
    }

    public IntBuffer asReadOnlyBuffer() {
        throw new LinkageError();
    }

    public int get() {
        throw new LinkageError();
    }

    public int get(int i) {
        throw new LinkageError();
    }

    public IntBuffer get(int[] dst, int offset, int length) {
        throw new LinkageError();
    }

    public IntBuffer get(int index, int[] dst, int offset, int length) {
        throw new LinkageError();
    }

    public boolean isDirect() {
        throw new LinkageError();
    }

    public boolean isReadOnly() {
        throw new LinkageError();
    }

    public IntBuffer put(int x) {
        throw new LinkageError();
    }

    public IntBuffer put(int i, int x) {
        throw new LinkageError();
    }

    public IntBuffer put(int[] src, int offset, int length) {
        throw new LinkageError();
    }

    public IntBuffer put(IntBuffer src) {
        throw new LinkageError();
    }

    public IntBuffer put(int index, IntBuffer src, int offset, int length) {
        throw new LinkageError();
    }

    public IntBuffer put(int index, int[] src, int offset, int length) {
        throw new LinkageError();
    }

    public IntBuffer compact() {
        throw new LinkageError();
    }

    public ByteOrder order() {
        throw new LinkageError();
    }
}
