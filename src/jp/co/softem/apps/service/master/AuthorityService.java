package jp.co.softem.apps.service.master;

import java.util.List;

import jp.co.softem.apps.core.BaseService;
import jp.co.softem.apps.meta.master.AuthorityMeta;
import jp.co.softem.apps.model.master.Authority;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;

public class AuthorityService extends BaseService<Authority> {

    public AuthorityService() {
        super(AuthorityMeta.get());
    }

    public List<Authority> findByName(String words) {
        AuthorityMeta e = AuthorityMeta.get();
        return Datastore.query(e).filterInMemory(
            e.authorityName.contains(words)).asList();
    }

    public List<Key> getKeysByName(String words) {
        AuthorityMeta e = AuthorityMeta.get();
        return Datastore.query(e).filterInMemory(
            e.authorityName.contains(words)).asKeyList();
    }

}
