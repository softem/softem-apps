package jp.co.softem.apps.service.master;

import java.util.List;

import jp.co.softem.apps.core.BaseService;
import jp.co.softem.apps.meta.master.AuthorityMeta;
import jp.co.softem.apps.model.master.Authority;

import org.slim3.controller.ControllerConstants;
import org.slim3.controller.validator.Validators;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;
import org.slim3.util.ApplicationMessage;

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

    public boolean delete(Key key, Long version, Validators v) {
        GlobalTransaction gtx = Datastore.beginGlobalTransaction();
        Authority entity = gtx.get(baseMeta, key, version);
        if (entity.getEmployeeListRef().getModelList().size() > 0) {
            String ms = ApplicationMessage.get("validator.in.use");
            v.getErrors().put(ControllerConstants.ERRORS_KEY, ms);
            gtx.rollback();
            return false;
        }
        gtx.delete(key);
        gtx.commit();
        return true;
    }

}
