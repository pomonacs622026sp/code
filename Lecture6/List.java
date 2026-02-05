interface List<E> {
    void add(E element);

    void add(int index, E element);

    void clear();

    E get(int index);

    boolean isEmpty();

    E remove();

    E remove(int index);

    E set(int index, E element);

    int size();
}
