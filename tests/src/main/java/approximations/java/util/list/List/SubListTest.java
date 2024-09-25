package approximations.java.util.list.List;

import approximations.Test;

import java.util.*;

@Test
public class SubListTest {
    static final Random rnd = new Random();

    @Test//(executionMax = 1)
    public static int test_Add(int execution) {
        //List<Integer> list = new ArrayList<>();
        //list.add(42);
        /*List<Integer> list = modifiable[execution].list;
        Integer from = modifiable[execution].from;
        Integer to = modifiable[execution].to;*/
        List<Integer> c1 = new ArrayList<>();
        c1.add(42);
        TestCase testCase = new TestCase(new LinkedList<>(c1), 0, 1);
        List<Integer> list = testCase.list;
        Integer from = testCase.from;
        Integer to = testCase.to;
        /*if (execution == 0) {
            list = modifiable[0].list;
            from = modifiable[0].from;
            to = modifiable[0].to;
        } else {
            list = modifiable[1].list;
            from = modifiable[1].from;
            to = modifiable[1].to;
        }*/
        //int from = 0;
        //int to = 1;
        List<Integer> subList = list.subList(from, to);
        //Integer e = rnd.nextInt();
        Integer e = 43;
        subList.add(e);
        /*if (!Objects.equals(list.get(to), e)) {
            return -1;
        }*/
        if (!list.get(to).equals(e)) {
            return -1;
        }
        if (subList.size() != to - from + 1) {
            return -1;
        }
        return execution;
    }

    @Test//(executionMax = 7)
    public static int test_ModAdd(int execution) {
        /*List<Integer> list = (List<Integer>) modifiable[0][0];
        Integer from = (Integer) modifiable[0][1];
        Integer to = (Integer) modifiable[0][2];*/
        List<Integer> list = new ArrayList<>();
        list.add(42);
        int from = 0;
        int to = 1;
        try {
            List<Integer> subList = list.subList(from, to);
            list.add(42);
            subList.add(42);
        } catch (ConcurrentModificationException e)  {
            return execution;
        }
        return -1;
    }

    @Test(executionMax = 9)
    public static int test_UnmodAdd(int execution) {
        List<Integer> list = unresizable[execution].list;
        Integer from = unresizable[execution].from;
        Integer to = unresizable[execution].to;
        try {
            List<Integer> subList = list.subList(from, to);
            subList.add(42);
        } catch (UnsupportedOperationException e) {
            return execution;
        }
        return -1;
    }

    @Test(executionMax = 7)
    public static int test_AddAtPos(int execution) {
        List<Integer> list = modifiable[execution].list;
        Integer from = modifiable[execution].from;
        Integer to = modifiable[execution].to;
        List<Integer> subList = list.subList(from, to);
        int i = rnd.nextInt(1 + to - from);
        Integer e = rnd.nextInt();
        subList.add(i, e);
        if (!Objects.equals(list.get(from + i), e)) {
            return -1;
        }
        if (subList.size() != to - from + 1) {
            return -1;
        }
        return execution;
    }

    @Test(executionMax = 7)
    public static int test_ModAddAtPos(int execution) {
        List<Integer> list = modifiable[execution].list;
        Integer from = modifiable[execution].from;
        Integer to = modifiable[execution].to;
        try {
            List<Integer> subList = list.subList(from, to);
            list.add(42);
            int i = rnd.nextInt(1 + to - from);
            subList.add(i, 42);
        } catch (ConcurrentModificationException e) {
            return execution;
        }
        return -1;
    }

    @Test(executionMax = 9)
    public static int test_UnmodAddAtPos(int execution) {
        List<Integer> list = unresizable[execution].list;
        Integer from = unresizable[execution].from;
        Integer to = unresizable[execution].to;
        try {
            List<Integer> subList = list.subList(from, to);
            int i = rnd.nextInt(1 + to - from);
            subList.add(i, 42);
        } catch (UnsupportedOperationException e) {
            return execution;
        }
        return -1;
    }

    @Test(executionMax = 7)
    public static int test_Clear(int execution) {
        List<Integer> list = modifiable[execution].list;
        Integer from = modifiable[execution].from;
        Integer to = modifiable[execution].to;
        List<Integer> subList = list.subList(from, to);
        subList.clear();
        if (!subList.isEmpty()) {
            return -1;
        }
        if (subList.size() != 0) {
            return -1;
        }
        return execution;
    }

    @Test(executionMax = 7)
    public static int test_ModClear(int execution) {
        List<Integer> list = modifiable[execution].list;
        Integer from = modifiable[execution].from;
        Integer to = modifiable[execution].to;
        try {
            List<Integer> subList = list.subList(from, to);
            list.add(42);
            subList.clear();
        } catch (ConcurrentModificationException e) {
            return execution;
        }
        return -1;
    }

    @Test(executionMax = 9)
    public static int test_UnmodClear(int execution) {
        List<Integer> list = unresizable[execution].list;
        Integer from = unresizable[execution].from;
        Integer to = unresizable[execution].to;
        try {
            List<Integer> subList = list.subList(from, to);
            subList.clear();
        } catch (UnsupportedOperationException e) {
            return execution;
        }
        return -1;
    }

    @Test(executionMax = 17)
    public static int test_Equals(int execution) {
        List<Integer> list = all[execution].list;
        Integer from = all[execution].from;
        Integer to = all[execution].to;
        List<Integer> subList1 = list.subList(from, to);
        List<Integer> subList2 = list.subList(from, to);
        if (!subList1.equals(subList2)) {
            return -1;
        }
        for (int i = 0; i != 16; ++i) {
            int from3 = rnd.nextInt(1 + list.size());
            int to3 = from3 + rnd.nextInt(1 + list.size() - from3);
            boolean equal = (to - from) == (to3 - from3);
            for (int j = 0; j < to - from && j < to3 - from3; ++j)
                equal &= Objects.equals(list.get(from + j), list.get(from3 + j));
            List<Integer> subList3 = list.subList(from3, to3);
            if (subList1.equals(subList3) != equal) {
                return -1;
            }
        }
        return execution;
    }

//    @Test(dataProvider = "modifiable",
//          expectedExceptions = ConcurrentModificationException.class)
//    public void testModEquals(List<Integer> list, int from, int to) {
//        List<Integer> subList = list.subList(from, to);
//        list.add(42);
//        subList.equals(subList);
//    }

    @Test(executionMax = 7)
    public static int test_ModHashCode(int execution) {
        List<Integer> list = modifiable[execution].list;
        Integer from = modifiable[execution].from;
        Integer to = modifiable[execution].to;
        try {
            List<Integer> subList = list.subList(from, to);
            list.add(42);
            subList.hashCode();
        } catch (ConcurrentModificationException e) {
            return execution;
        }
        return -1;
    }

    @Test(executionMax = 17)
    public static int test_Get(int execution) {
        List<Integer> list = all[execution].list;
        Integer from = all[execution].from;
        Integer to = all[execution].to;
        List<Integer> subList = list.subList(from, to);
        for (int i = 0; i < to - from; ++i) {
            if (!Objects.equals(list.get(from + i), subList.get(i))) {
                return -1;
            }
        }
        return execution;
    }

    @Test(executionMax = 7)
    public static int test_ModGet(int execution) {
        List<Integer> list = modifiable[execution].list;
        Integer from = modifiable[execution].from;
        Integer to = modifiable[execution].to;
        try {
            List<Integer> subList = list.subList(from, to);
            list.add(42);
            subList.get(from);
        } catch (ConcurrentModificationException e) {
            return execution;
        }
        return -1;
    }

    @Test(executionMax = 17)
    public static int test_IndexOf(int execution) {
        List<Integer> list = all[execution].list;
        Integer from = all[execution].from;
        Integer to = all[execution].to;
        List<Integer> subList = list.subList(from, to);
        if (from < to) {
            Integer e = list.get(from);
            int j = subList.indexOf(e);
            if (j != 0) {
                return -1;
            }
        }
        for (int i = 0; i < list.size(); ++i) {
            Integer e = list.get(i);
            int j = subList.indexOf(e);
            if (i < from || i >= to) {
                if (!(j == -1 || Objects.equals(subList.get(j), e))) {
                    return -1;
                }
            } else {
                if (j < 0) {
                    return -1;
                }
                if (j > i - from) {
                    return -1;
                }
                if (!Objects.equals(subList.get(j), e)) {
                    return -1;
                }
            }
        }
        for (int i = 0; i < 16; ++i) {
            Integer r = rnd.nextInt();
            if (list.contains(r)) continue;
            int j = subList.indexOf(r);
            if (j != -1) {
                return -1;
            }
        }
        return execution;
    }

    @Test(executionMax = 7)
    public static int test_ModIndexOf(int execution) {
        List<Integer> list = modifiable[execution].list;
        Integer from = modifiable[execution].from;
        Integer to = modifiable[execution].to;
        try {
            List<Integer> subList = list.subList(from, to);
            list.add(42);
            subList.indexOf(from);
        } catch (ConcurrentModificationException e) {
            return execution;
        }
        return -1;
    }

    @Test(executionMax = 17)
    public static int test_Iterator(int execution) {
        List<Integer> list = all[execution].list;
        Integer from = all[execution].from;
        Integer to = all[execution].to;
        List<Integer> subList = list.subList(from, to);
        Iterator<Integer> it = subList.iterator();
        for (int i = from; i < to; ++i) {
            if (!it.hasNext()) {
                return -1;
            }
            if (!Objects.equals(list.get(i), it.next())) {
                return -1;
            }
        }
        if (it.hasNext()) {
            return -1;
        }
        return execution;
    }

    @Test(executionMax = 7)
    public static int test_ModIteratorNext(int execution) {
        List<Integer> list = modifiable[execution].list;
        Integer from = modifiable[execution].from;
        Integer to = modifiable[execution].to;
        try {
            List<Integer> subList = list.subList(from, to);
            Iterator<Integer> it = subList.iterator();
            list.add(42);
            it.next();
        } catch (ConcurrentModificationException e) {
            return execution;
        }
        return -1;
    }

    @Test(executionMax = 7)
    public static int test_IteratorRemove(int execution) {
        List<Integer> list = modifiable[execution].list;
        Integer from = modifiable[execution].from;
        Integer to = modifiable[execution].to;
        List<Integer> subList = list.subList(from, to);
        Iterator<Integer> it = subList.iterator();
        for (int i = from; i < to; ++i) {
            if (!it.hasNext()) {
                return -1;
            }
            if (!Objects.equals(list.get(from), it.next())) {
                return -1;
            }
            it.remove();
        }
        if (it.hasNext()) {
            return -1;
        }
        if (subList.isEmpty()) {
            return -1;
        }
        return execution;
    }

    @Test(executionMax = 7)
    public static int test_ModIteratorRemove(int execution) {
        List<Integer> list = modifiable[execution].list;
        Integer from = modifiable[execution].from;
        Integer to = modifiable[execution].to;
        try {
            List<Integer> subList = list.subList(from, to);
            Iterator<Integer> it = subList.iterator();
            it.next();
            list.add(42);
            it.remove();
        } catch (ConcurrentModificationException e) {
            return execution;
        }
        return -1;
    }

    @Test(executionMax = 9)
    public static int test_UnmodIteratorRemove(int execution) {
        List<Integer> list = unresizable[execution].list;
        Integer from = unresizable[execution].from;
        Integer to = unresizable[execution].to;
        try {
            List<Integer> subList = list.subList(from, to);
            Iterator<Integer> it = subList.iterator();
            it.next();
            it.remove();
        } catch (UnsupportedOperationException e) {
            return execution;
        }
        return -1;
    }

    @Test(executionMax = 17)
    public static int test_IteratorForEachRemaining(int execution) {
        List<Integer> list = all[execution].list;
        Integer from = all[execution].from;
        Integer to = all[execution].to;
        List<Integer> subList = list.subList(from, to);
        for (int k = 0; k < 16; ++k) {
            int r = from + rnd.nextInt(1 + to - from);
            Iterator<Integer> it = subList.iterator();
            for (int i = from; i < to; ++i) {
                if (!it.hasNext()) {
                    return -1;
                }
                if (i == r) {
                    Iterator<Integer> jt = list.listIterator(r);
                    while (it.hasNext()) {
                        if (!(jt.hasNext() && Objects.equals(it.next(), jt.next()))) {
                            return -1;
                        }
                    }
                    break;
                }
                if (!Objects.equals(list.get(i), it.next())) {
                    return -1;
                }
            }
            if (it.hasNext()) {
                return -1;
            }
        }
        return execution;
    }

    @Test(executionMax = 17)
    public static int test_LastIndexOf(int execution) {
        List<Integer> list = all[execution].list;
        Integer from = all[execution].from;
        Integer to = all[execution].to;
        List<Integer> subList = list.subList(from, to);
        if (from < to) {
            Integer e = list.get(to - 1);
            int j = subList.lastIndexOf(e);
            if (j != to - from - 1) {
                return -1;
            }
        }
        for (int i = 0; i < list.size(); ++i) {
            Integer e = list.get(i);
            int j = subList.lastIndexOf(e);
            if (i < from || i >= to) {
                if (!(j == -1 || Objects.equals(subList.get(j), e))) {
                    return -1;
                }
            } else {
                if (!(j >= 0 && j >= i - from)) {
                    return -1;
                }
                if (!Objects.equals(subList.get(j), e)) {
                    return -1;
                }
            }
        }
        for (int i = 0; i < 16; ++i) {
            Integer r = rnd.nextInt();
            if (list.contains(r)) continue;
            int j = subList.lastIndexOf(r);
            if (j != -1) {
                return -1;
            }
        }
        return execution;
    }

    @Test(executionMax = 7)
    public static int test_ModLastIndexOf(int execution) {
        List<Integer> list = modifiable[execution].list;
        Integer from = modifiable[execution].from;
        Integer to = modifiable[execution].to;
        try {
            List<Integer> subList = list.subList(from, to);
            list.add(42);
            subList.lastIndexOf(42);
        } catch (ConcurrentModificationException e) {
            return execution;
        }
        return -1;
    }

    @Test(executionMax = 9)
    public static int test_ListIterator(int execution) {
        List<Integer> list = unresizable[execution].list;
        Integer from = unresizable[execution].from;
        Integer to = unresizable[execution].to;
        List<Integer> subList = list.subList(from, to);
        ListIterator<Integer> it = subList.listIterator();
        for (int i = from; i < to; ++i) {
            if (!it.hasNext()) {
                return -1;
            }
            if (it.nextIndex() != i - from) {
                return -1;
            }
            if (!Objects.equals(list.get(i), it.next())) {
                return -1;
            }
        }
        if (it.hasNext()) {
            return -1;
        }
        return execution;
    }

    @Test(executionMax = 7)
    public static int test_ModListIteratorNext(int execution) {
        List<Integer> list = modifiable[execution].list;
        Integer from = modifiable[execution].from;
        Integer to = modifiable[execution].to;
        try {
            List<Integer> subList = list.subList(from, to);
            ListIterator<Integer> it = subList.listIterator();
            list.add(42);
            it.next();
        } catch (ConcurrentModificationException e) {
            return execution;
        }
        return -1;
    }

    @Test(executionMax = 7)
    public static int test_ListIteratorSet(int execution) {
        List<Integer> list = modifiable[execution].list;
        Integer from = modifiable[execution].from;
        Integer to = modifiable[execution].to;
        List<Integer> subList = list.subList(from, to);
        ListIterator<Integer> it = subList.listIterator();
        for (int i = from; i < to; ++i) {
            if (!it.hasNext()) {
                return -1;
            }
            if (it.nextIndex() != i - from) {
                return -1;
            }
            if (!Objects.equals(list.get(i), it.next())) {
                return -1;
            }
            Integer e = rnd.nextInt();
            it.set(e);
            if (!Objects.equals(list.get(i), e)) {
                return -1;
            }
        }
        if (it.hasNext()) {
            return -1;
        }
        return execution;
    }

    @Test(executionMax = 7)
    public static int test_ModListIteratorSet(int execution) {
        List<Integer> list = modifiable[execution].list;
        Integer from = modifiable[execution].from;
        Integer to = modifiable[execution].to;
        try {
            List<Integer> subList = list.subList(from, to);
            ListIterator<Integer> it = subList.listIterator();
            it.next();
            list.add(42);
            it.set(42);
        } catch (ConcurrentModificationException e) {
            return execution;
        }
        return -1;
    }

    @Test(executionMax = 3)
    public static int test_UnmodListIteratorSet(int execution) {
        List<Integer> list = unsettable[execution].list;
        Integer from = unsettable[execution].from;
        Integer to = unsettable[execution].to;
        try {
            List<Integer> subList = list.subList(from, to);
            ListIterator<Integer> it = subList.listIterator();
            it.next();
            it.set(42);
        } catch (UnsupportedOperationException e) {
            return execution;
        }
        return -1;
    }

    @Test(executionMax = 9)
    public static int test_ListIteratorPrevious(int execution) {
        List<Integer> list = unresizable[execution].list;
        Integer from = unresizable[execution].from;
        Integer to = unresizable[execution].to;
        List<Integer> subList = list.subList(from, to);
        ListIterator<Integer> it = subList.listIterator(subList.size());
        for (int i = to - 1; i >= from; --i) {
            if (!it.hasPrevious()) {
                return -1;
            }
            if (it.previousIndex() != i - from) {
                return -1;
            }
            if (!Objects.equals(list.get(i), it.previous())) {
                return -1;
            }
        }
        if (it.hasPrevious()) {
            return -1;
        }
        return execution;
    }

    @Test(executionMax = 7)
    public static int test_ModListIteratorPrevious(int execution) {
        List<Integer> list = modifiable[execution].list;
        Integer from = modifiable[execution].from;
        Integer to = modifiable[execution].to;
        try {
            List<Integer> subList = list.subList(from, to);
            ListIterator<Integer> it = subList.listIterator(to - from);
            list.add(42);
            it.previous();
        } catch (ConcurrentModificationException e) {
            return execution;
        }
        return -1;
    }

    @Test(executionMax = 7)
    public static int test_ListIteratorSetPrevious(int execution) {
        List<Integer> list = modifiable[execution].list;
        Integer from = modifiable[execution].from;
        Integer to = modifiable[execution].to;
        List<Integer> subList = list.subList(from, to);
        ListIterator<Integer> it = subList.listIterator(subList.size());
        for (int i = to - 1; i >= from; --i) {
            if (!it.hasPrevious()) {
                return -1;
            }
            if (it.previousIndex() != i - from) {
                return -1;
            }
            if (!Objects.equals(list.get(i), it.previous())) {
                return -1;
            }
            Integer e = rnd.nextInt();
            it.set(e);
            if (!Objects.equals(list.get(i), e)) {
                return -1;
            }
        }
        if (it.hasPrevious()) {
            return -1;
        }
        return execution;
    }

    @Test(executionMax = 3)
    public static int test_UnmodListIteratorSetPrevious(int execution) {
        List<Integer> list = unsettable[execution].list;
        Integer from = unsettable[execution].from;
        Integer to = unsettable[execution].to;
        try {
            List<Integer> subList = list.subList(from, to);
            ListIterator<Integer> it = subList.listIterator(to - from);
            it.previous();
            it.set(42);
        } catch (UnsupportedOperationException e) {
            return execution;
        }
        return -1;
    }

    @Test(executionMax = 7)
    public static int test_ListIteratorAdd(int execution) {
        List<Integer> list = modifiable[execution].list;
        Integer from = modifiable[execution].from;
        Integer to = modifiable[execution].to;
        List<Integer> subList = list.subList(from, to);
        for (int i = 0; i < 16; ++i) {
            int r = rnd.nextInt(1 + subList.size());
            ListIterator<Integer> it = subList.listIterator(r);
            Integer e = rnd.nextInt();
            it.add(e);
            if (!Objects.equals(it.previous(), e)) {
                return -1;
            }
            if (!Objects.equals(list.get(from + r), e)) {
                return -1;
            }
        }
        return execution;
    }

    @Test(executionMax = 9)
    public static int test_UnmodListIteratorAdd(int execution) {
        List<Integer> list = unresizable[execution].list;
        Integer from = unresizable[execution].from;
        Integer to = unresizable[execution].to;
        try {
            List<Integer> subList = list.subList(from, to);
            int r = rnd.nextInt(1 + subList.size());
            ListIterator<Integer> it = subList.listIterator(r);
            it.add(42);
        } catch (UnsupportedOperationException e) {
            return execution;
        }
        return -1;
    }

    @Test(executionMax = 7)
    public static int test_ModListIteratorAdd(int execution) {
        List<Integer> list = modifiable[execution].list;
        Integer from = modifiable[execution].from;
        Integer to = modifiable[execution].to;
        try {
            List<Integer> subList = list.subList(from, to);
            ListIterator<Integer> it = subList.listIterator();
            it.next();
            list.add(42);
            it.add(42);
        } catch (ConcurrentModificationException e) {
            return execution;
        }
        return -1;
    }

    @Test(executionMax = 7)
    public static int test_ListIteratorRemoveNext(int execution) {
        List<Integer> list = modifiable[execution].list;
        Integer from = modifiable[execution].from;
        Integer to = modifiable[execution].to;
        List<Integer> subList = list.subList(from, to);
        ListIterator<Integer> it = subList.listIterator();
        for (int i = from; i < to; ++i) {
            if (!it.hasNext()) {
                return -1;
            }
            if (it.nextIndex() != 0) {
                return -1;
            }
            if (!Objects.equals(list.get(from), it.next())) {
                return -1;
            }
            it.remove();
        }
        if (it.hasNext()) {
            return -1;
        }
        if (!subList.isEmpty()) {
            return -1;
        }
        return execution;
    }

    @Test(executionMax = 9)
    public static int test_UnmodListIteratorRemoveNext(int execution) {
        List<Integer> list = unresizable[execution].list;
        Integer from = unresizable[execution].from;
        Integer to = unresizable[execution].to;
        try {
            List<Integer> subList = list.subList(from, to);
            ListIterator<Integer> it = subList.listIterator();
            it.next();
            it.remove();
        } catch (UnsupportedOperationException e) {
            return execution;
        }
        return -1;
    }

    @Test(executionMax = 7)
    public static int test_ModListIteratorRemove(int execution) {
        List<Integer> list = modifiable[execution].list;
        Integer from = modifiable[execution].from;
        Integer to = modifiable[execution].to;
        try {
            List<Integer> subList = list.subList(from, to);
            ListIterator<Integer> it = subList.listIterator();
            it.next();
            list.add(42);
            it.remove();
        } catch (ConcurrentModificationException e) {
            return execution;
        }
        return -1;
    }

    @Test(executionMax = 7)
    public static int test_ListIteratorRemovePrevious(int execution) {
        List<Integer> list = modifiable[execution].list;
        Integer from = modifiable[execution].from;
        Integer to = modifiable[execution].to;
        List<Integer> subList = list.subList(from, to);
        ListIterator<Integer> it = subList.listIterator(subList.size());
        for (int i = to - 1; i >= from; --i) {
            if (!it.hasPrevious()) {
                return -1;
            }
            if (it.previousIndex() != i - from) {
                return -1;
            }
            if (!Objects.equals(list.get(i), it.previous())) {
                return -1;
            }
            it.remove();
        }
        if (it.hasPrevious()) {
            return -1;
        }
        if (!subList.isEmpty()) {
            return -1;
        }
        return execution;
    }

    @Test(executionMax = 9)
    public static int test_UnmodListIteratorRemovePrevious(int execution) {
        List<Integer> list = unresizable[execution].list;
        Integer from = unresizable[execution].from;
        Integer to = unresizable[execution].to;
        try {
            List<Integer> subList = list.subList(from, to);
            ListIterator<Integer> it = subList.listIterator(subList.size());
            it.previous();
            it.remove();
        } catch (UnsupportedOperationException e) {
            return execution;
        }
        return -1;
    }

    @Test(executionMax = 7)
    public static int test_Remove(int execution) {
        List<Integer> list = modifiable[execution].list;
        Integer from = modifiable[execution].from;
        Integer to = modifiable[execution].to;
        List<Integer> subList = list.subList(from, to);
        for (int i = 0; i < 16; ++i) {
            if (subList.isEmpty()) break;
            int r = rnd.nextInt(subList.size());
            Integer e = list.get(from + r);
            if (!Objects.equals(subList.remove(r), e)) {
                return -1;
            }
        }
        return execution;
    }

    @Test(executionMax = 9)
    public static int test_UnmodRemove(int execution) {
        List<Integer> list = unresizable[execution].list;
        Integer from = unresizable[execution].from;
        Integer to = unresizable[execution].to;
        try {
            List<Integer> subList = list.subList(from, to);
            int r = rnd.nextInt(subList.size());
            subList.remove(r);
        } catch (UnsupportedOperationException e) {
            return execution;
        }
        return -1;
    }

    @Test(executionMax = 7)
    public static int test_ModRemove(int execution) {
        List<Integer> list = modifiable[execution].list;
        Integer from = modifiable[execution].from;
        Integer to = modifiable[execution].to;
        try {
            List<Integer> subList = list.subList(from, to);
            list.add(42);
            subList.remove(0);
        } catch (ConcurrentModificationException e) {
            return execution;
        }
        return -1;
    }

    @Test(executionMax = 7)
    public static int test_Set(int execution) {
        List<Integer> list = modifiable[execution].list;
        Integer from = modifiable[execution].from;
        Integer to = modifiable[execution].to;
        List<Integer> subList = list.subList(from, to);
        for (int i = 0; i < to - from; ++i) {
            Integer e0 = list.get(from + i);
            Integer e1 = rnd.nextInt();
            if (!Objects.equals(subList.set(i, e1), e0)) {
                return -1;
            }
            if (!Objects.equals(list.get(from + i), e1)) {
                return -1;
            }
        }
        return execution;
    }

    @Test(executionMax = 7)
    public static int test_ModSet(int execution) {
        List<Integer> list = modifiable[execution].list;
        Integer from = modifiable[execution].from;
        Integer to = modifiable[execution].to;
        try {
            List<Integer> subList = list.subList(from, to);
            list.add(42);
            subList.set(0, 42);
        } catch (ConcurrentModificationException e) {
            return execution;
        }
        return -1;
    }

    @Test(executionMax = 17)
    public static int test_SubList(int execution) {
        List<Integer> list = all[execution].list;
        Integer from = all[execution].from;
        Integer to = all[execution].to;
        List<Integer> subList = list.subList(from, to);
        for (int i = 0; i < 16 && from < to; ++i) {
            int from1 = rnd.nextInt(to - from);
            int to1 = from1 + 1 + rnd.nextInt(to - from - from1);
            List<Integer> subSubList = subList.subList(from1, to1);
            for (int j = 0; j < to1 - from1; ++j) {
                if (!Objects.equals(list.get(from + from1 + j), subSubList.get(j))) {
                    return -1;
                }
            }
        }
        return execution;
    }

    /**
     * All kinds of lists
     */

    static class TestCase {
        List<Integer> list;
        Integer from, to;
        TestCase(List<Integer> _list, Integer _from, Integer _to) {
            list = _list;
            from = _from;
            to = _to;
        }
    }

    public static TestCase[] getAll() {
        TestCase[] l1 = getModifiable();
        TestCase[] l2 = getUnresizable();
        TestCase[] res = Arrays.copyOf(l1, l1.length + l2.length);
        System.arraycopy(l2, 0, res, l1.length, l2.length);
        return res;
    }
    static final TestCase[] all = getAll();

    /**
     * Lists that allow any modifications: resizing and setting values
     */
    public static TestCase[] getModifiable() {
        Integer[] c9_copy = new Integer[] { 40, 41, 42, 43, 44, 45, -1,
                Integer.MIN_VALUE, 1000500 };
        List<Integer> c1 = new ArrayList<>();
        c1.add(42);
        List<Integer> c9 = new ArrayList<>();
        for (Integer it : c9_copy) {
            c9.add(it);
        }

        return new TestCase[] {
                new TestCase(new ArrayList<>(c1), 0, 1),
                new TestCase(new LinkedList<>(c1), 0, 1),
                new TestCase(new ArrayList<>(c1).subList(0, 1), 0, 1),
                new TestCase(new LinkedList<>(c1).subList(0, 1), 0, 1),
                new TestCase(new ArrayList<>(c9), 2, 5),
                new TestCase(new LinkedList<>(c9), 2, 5),
                new TestCase(new ArrayList<>(c9).subList(1, 8), 1, 4),
                new TestCase(new LinkedList<>(c9).subList(1, 8), 1, 4)
        };
    }
    static final TestCase[] modifiable = getModifiable();

    /**
     * Lists that don't allow resizing, but allow setting values
     */
    public static TestCase[] getUnresizable() {
        Integer[] c9_copy = new Integer[] { 40, 41, 42, 43, 44, 45, -1,
                Integer.MIN_VALUE, 1000500 };
        List<Integer> c1 = new ArrayList<>();
        c1.add(42);
        List<Integer> c9 = new ArrayList<>();
        for (Integer it : c9_copy) {
            c9.add(it);
        }

        TestCase[] l1 = getUnsettable();
        TestCase[] l2 = {
                new TestCase(c1, 0, 1),
                new TestCase(c1.subList(0, 1), 0, 1),
                new TestCase(c9, 0, 4),
                new TestCase(c9, 4, 6),
                new TestCase(c9.subList(1, 8), 1, 4),
                new TestCase(c9.subList(1, 8), 0, 7),
        };
        TestCase[] res = Arrays.copyOf(l1, l1.length + l2.length);
        System.arraycopy(l2, 0, res, l1.length, l2.length);
        return res;
    }
    static final TestCase[] unresizable = getUnresizable();

    /**
     * Lists that don't allow either resizing or setting values
     */
    public static TestCase[] getUnsettable() {
        return new TestCase[] {
                new TestCase(new MyList(1), 0, 1),
                new TestCase(new MyList(1).subList(0, 1), 0, 1),
                new TestCase(new MyList(9), 3, 6),
                new TestCase(new MyList(9).subList(2, 8), 3, 6)
        };
    }
    static final TestCase[] unsettable = getUnsettable();

    static class MyList extends AbstractList<Integer> {
        private final int size;
        MyList(int s) { size = s; }
        public Integer get(int index) { return 42; }
        public int size() { return size; }
    }
}
