package lab7;

import java.util.*;

public class CarCollection<T extends Car> implements List<T> {
    private final LinkedList<T> carList;

    public CarCollection() {
        carList = new LinkedList<>();
    }

    public CarCollection(T car) {
        carList = new LinkedList<>();
        carList.add(car);
    }

    public CarCollection(Collection<? extends T> c) {
        carList = new LinkedList<>(c);
    }

    //  Реалізація методів List
    @Override
    public int size() {
        return carList.size();
    }

    @Override
    public boolean isEmpty() {
        return carList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return carList.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return carList.iterator();
    }

    @Override
    public Object[] toArray() {
        return carList.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return carList.toArray(a);
    }

    @Override
    public boolean add(T t) {
        return carList.add(t);
    }

    @Override
    public boolean remove(Object o) {
        return carList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return carList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return carList.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return carList.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return carList.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return carList.retainAll(c);
    }

    @Override
    public void clear() {
        carList.clear();
    }

    @Override
    public T get(int index) {
        return carList.get(index);
    }

    @Override
    public T set(int index, T element) {
        return carList.set(index, element);
    }

    @Override
    public void add(int index, T element) {
        carList.add(index, element);
    }

    @Override
    public T remove(int index) {
        return carList.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return carList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return carList.lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator() {
        return carList.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return carList.listIterator(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return carList.subList(fromIndex, toIndex);
    }

}