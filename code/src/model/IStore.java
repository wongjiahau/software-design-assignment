package model;

public interface IStore<T> {
    public T searchById(String id) throws Exception;
    public void add(String id, T data) throws Exception;
}
