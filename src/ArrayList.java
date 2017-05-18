import java.util.Collection;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayList implements Collection<Integer>{

    private Integer[] integ;
    private int coll = 0;

    public ArrayList() {
        integ = new Integer[10];
    }

    public Integer sumElement(){
        if (isEmpty()) return null;
        if (coll == 1) return integ[0];
        int result = 0;
        for (int i = 0; i < coll; i++) {
            result += integ[i];
        }
        result = result/coll;
        return result;
    }

    public Integer maxElement(){
        if (isEmpty()) return null;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < coll; i++) {
            Integer integer = integ[i];
            if (integer > max) max = integer;
        }
        return max;
    }

    public Integer minElement(){
        if (isEmpty()) return null;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coll; i++) {
            Integer integer = integ[i];
            if (integer < min) min = integer;
        }
        return min;
    }

    public Integer removeElement(int index){
        rangeCheck(index);
        return integ[index];
    }

    public Integer removeIndex(int index) {
        rangeCheck(index);
        int value = integ[index];
        System.arraycopy(integ, index + 1, integ, index, coll - index + 1);
        coll--;
        for (int i = 0; i < size(); i++) {
            integ[i] -= value;
        }
        return value;
    }

    private void rangeCheck(int index) {
        if (index >= coll) throw new IndexOutOfBoundsException(outOfBoundsMessage(index));
    }

    private String outOfBoundsMessage(int index) {
        return "Индекс " + index + " размер " + coll;
    }

    public int indexOf(Object o) {
        if (isCorrectType(o)){
            for (int i = 0; i < size(); i++) {
                if (integ[i].equals(o)) return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "Коллекция: \nДобавить null:";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < coll; i++) {
            sb.append(integ[i]);
            if (i + 1 != coll) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    private boolean isCorrectType(Object o) {
        return o instanceof Integer;
    }

    @Override
    public int size() {
        return coll;
    }

    @Override
    public boolean isEmpty() {
        return coll == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (isEmpty() || !isCorrectType(o)) return false;
        for (int i = 0; i < coll; i++) {
            if (integ[i].equals(o)) return true;
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int count = 0;
            @Override
            public boolean hasNext() {
                return coll > count;
            }

            @Override
            public Integer next() {
                return integ[count++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(integ, coll);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Integer integer) {
        if (integer == null) return false;
        if (integ.length == coll) {
            //integers = Arrays.copyOf(integers, integers.length * 2);
        }
        for (int i = 0; i < coll; i++) {
            integ[i] += integer;
        }
        coll++;
        integ[coll - 1] = integer;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index;
        if (isEmpty() || !isCorrectType(o) || (index = indexOf(o)) == -1) return false;
        removeIndex(index);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        coll = 0;
    }
}