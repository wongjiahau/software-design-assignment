package mocks;

import java.util.Collection;
import java.util.HashMap;

public abstract class MockDAO<T> {
    private HashMap<String, T> map;
    private String lastInsertedKey;

    protected MockDAO() {
        this.map = new HashMap<String, T>();
    }

    protected T getById(String id) {
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
        this.lastInsertedKey = id;
        return true;
    }

    protected T getLastInserted() {
        return this.map.get(this.lastInsertedKey);
    }

    protected Collection<T> getAll() {
        return this.map.values();
    }

}
