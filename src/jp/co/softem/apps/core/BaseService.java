package jp.co.softem.apps.core;

import java.util.List;
import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;
import org.slim3.datastore.ModelMeta;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;

public abstract class BaseService<T> {

    protected ModelMeta<T> baseMeta;

    public BaseService(ModelMeta<T> meta) {
        this.baseMeta = meta;
    }

    public T get(Key key, Long version) {
        return (T) Datastore.get(baseMeta, key, version);
    }

    public List<T> getAll() {
        return Datastore.query(baseMeta).asList();
    }

    public void insert(T entity) {
        GlobalTransaction gtx = Datastore.beginGlobalTransaction();
        gtx.put(entity);
        gtx.commit();
    }

    public T update(Key key, Long version, Map<String, Object> input) {
        GlobalTransaction gtx = Datastore.beginGlobalTransaction();
        T entity = gtx.get(baseMeta, key, version);
        BeanUtil.copy(input, entity);
        gtx.put(entity);
        gtx.commit();
        return entity;
    }

    public void delete(Key key, Long version) {
        GlobalTransaction gtx = Datastore.beginGlobalTransaction();
        gtx.get(baseMeta, key, version);
        gtx.delete(key);
        gtx.commit();
    }

}
