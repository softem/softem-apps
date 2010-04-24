package jp.co.softem.apps.service.master;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.ModelMeta;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

public abstract class BaseService<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private ModelMeta<T> meta;

    public BaseService(ModelMeta<T> meta) {
        this.meta = meta;
    }

    public T get(Key key, Long version) {
        return (T) Datastore.get(meta, key, version);
    }

    public List<T> getAll() {
        return Datastore.query(meta).asList();
    }

    public void insert(T entity) {
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(tx, entity);
        Datastore.commit(tx);
    }

    public T update(Key key, Long version, Map<String, Object> input) {
        Transaction tx = Datastore.beginTransaction();
        T entity = (T) Datastore.get(tx, meta, key, version);
        BeanUtil.copy(input, entity);
        Datastore.put(tx, entity);
        Datastore.commit(tx);
        return entity;
    }

    public void delete(Key key, Long version) {
        Transaction tx = Datastore.beginTransaction();
        Datastore.get(tx, meta, key, version);
        Datastore.delete(tx, key);
        Datastore.commit(tx);
    }

}
