package stub.java.util;

import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class HeapFloatBuffer {
    HeapFloatBuffer(int cap, int lim) {
        throw new LinkageError();
    }

    HeapFloatBuffer(float[] buf, int off, int len) {
        throw new LinkageError();
    }

    protected HeapFloatBuffer(float[] buf, int mark, int pos, int lim, int cap, int off) {
        throw new LinkageError();
    }

    public FloatBuffer slice() {
        throw new LinkageError();
    }

    public FloatBuffer slice(int index, int length) {
        throw new LinkageError();
    }

    public FloatBuffer duplicate() {
        throw new LinkageError();
    }

    public FloatBuffer asReadOnlyBuffer() {
        throw new LinkageError();
    }

    public float get() {
        throw new LinkageError();
    }

    public float get(int i) {
        throw new LinkageError();
    }

    public FloatBuffer get(float[] dst, int offset, int length) {
        throw new LinkageError();
    }

    public FloatBuffer get(int index, float[] dst, int offset, int length) {
        throw new LinkageError();
    }

    public boolean isDirect() {
        throw new LinkageError();
    }

    public boolean isReadOnly() {
        throw new LinkageError();
    }

    public FloatBuffer put(float x) {
        throw new LinkageError();
    }

    public FloatBuffer put(int i, float x) {
        throw new LinkageError();
    }

    public FloatBuffer put(float[] src, int offset, int length) {
        throw new LinkageError();
    }

    public FloatBuffer put(FloatBuffer src) {
        throw new LinkageError();
    }

    public FloatBuffer put(int index, FloatBuffer src, int offset, int length) {
        throw new LinkageError();
    }

    public FloatBuffer put(int index, float[] src, int offset, int length) {
        throw new LinkageError();
    }

    public FloatBuffer compact() {
        throw new LinkageError();
    }

    public ByteOrder order() {
        throw new LinkageError();
    }
}
