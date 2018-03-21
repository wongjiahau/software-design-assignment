package model;

import java.util.HashMap;

public abstract class Store<T> implements IStore<T> {
    private HashMap<String, T> map;

    protected Store() {
        this.map = new HashMap<String, T>();
    }

    public T searchById(String id) throws Exception {
        T result = (T) (this.map.get(id));
        if (result == null) {
            throw new Exception("Invalid id : " + id);
        }
        return result;
    }

    public void add(String id, T data) throws Exception {
        boolean idExisted = this.map.get(id) != null;
        if(idExisted) {
            throw new Exception("The id :'" + id + "' already exist in this data store.");
        }
        this.map.put(id, data);
    }

}
