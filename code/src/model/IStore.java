package model;

public interface IStore<T> {
    T searchById(String id);
    boolean add(String id, T data);
}
