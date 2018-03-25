package mocks;

public interface IMockDAO<T> {
    T searchById(String id);
    boolean add(String id, T data);
}
