package generated.java.util.map;

import org.jacodb.approximation.annotation.Approximate;
import org.jetbrains.annotations.NotNull;
import stub.java.util.map.Map_ContentsSet;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Approximate(Map_ContentsSet.class)
public abstract class Map_ContentsSetImpl<K, V, Content> extends Map_ContentsImpl<K, V, Content> implements Set<Content> {

    public Map_ContentsSetImpl(AbstractMapImpl<K, V> map) {
        super(map);
    }

    public boolean add(Content e) {
        return super.add(e);
    }

    public boolean addAll(@NotNull Collection<? extends Content> c) {
        return super.addAll(c);
    }

    public void clear() {
        super.clear();
    }

    public boolean contains(Object obj) {
        return super.contains(obj);
    }

    public boolean containsAll(@NotNull Collection<?> c) {
        return super.containsAll(c);
    }

    Set<?> _equalsTypeCheck(Object other) {
        if (other instanceof Set<?>)
            return (Set<?>) other;

        return null;
    }

    public boolean equals(Object other) {
        return super.equals(other);
    }

    public void forEach(Consumer<? super Content> userAction) {
        super.forEach(userAction);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    @NotNull
    public Iterator<Content> iterator() {
        return super.iterator();
    }

    public Stream<Content> parallelStream() {
        return super.parallelStream();
    }

    public boolean removeAll(@NotNull Collection<?> c) {
        return super.removeAll(c);
    }

    public boolean removeIf(Predicate<? super Content> filter) {
        return super.removeIf(filter);
    }

    public boolean retainAll(@NotNull Collection<?> c) {
        return super.retainAll(c);
    }

    public int _size() {
        return super._size();
    }

    public Spliterator<Content> spliterator() {
        return new Map_ContentsSet_SpliteratorImpl<>(this);
    }

    public Stream<Content> stream() {
        return super.stream();
    }

    @NotNull
    public Object[] _toArray() {
        return super._toArray();
    }

    public <T> T[] _toArray(IntFunction<T[]> generator) {
        return super._toArray(generator);
    }

    @NotNull
    public <T> T[] _toArray(@NotNull T[] array) {
        return super._toArray(array);
    }

    public String _toString() {
        return super._toString();
    }
}
