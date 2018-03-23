package model;

import java.util.HashMap;

public abstract class Store<T> {
    private HashMap<String, T> map;

    protected Store() {
        this.map = new HashMap<String, T>();
    }

    protected T searchById(String id) {
        T result = (T) (this.map.get(id));
        if (result == null) {
            return null;
        }
        return result;
    }

    protected boolean add(String id, T data) {
        boolean idExisted = this.map.get(id) != null;
        if(idExisted) {
            return false;
        }
        this.map.put(id, data);
        return true;
    }

}
