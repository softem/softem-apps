package jp.co.softem.apps.service.master;

import java.util.List;

import jp.co.softem.apps.meta.master.EmployeeViewMeta;
import jp.co.softem.apps.model.master.Authority;
import jp.co.softem.apps.model.master.Employee;
import jp.co.softem.apps.model.master.EmployeeView;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;

public class EmployeeService {

    EmployeeViewMeta meta = EmployeeViewMeta.get();

    public List<EmployeeView> getAll() {
        return Datastore.query(meta).asList();
    }

    public List<EmployeeView> getByName(String words) {
        return Datastore.query(meta).filterInMemory(
            meta.employeeName.contains(words)).asList();
    }

    public List<EmployeeView> getByAuthorityName(String words) {
        return Datastore.query(meta).filterInMemory(
            meta.authorityName.contains(words)).asList();
    }

    public void insert(Employee employee, Key authorityKey) {
        GlobalTransaction gtx = Datastore.beginGlobalTransaction();
        Key employeeKey = gtx.put(employee);
        EmployeeView view = new EmployeeView();
        view.setEmployeeKey(employeeKey);
        BeanUtil.copy(employee, view);
        Authority authority = gtx.get(Authority.class, authorityKey);
        BeanUtil.copy(authority, view);
        gtx.put(view);
        gtx.commit();
    }

    public void delete(Key key, Long version) {
        GlobalTransaction gtx = Datastore.beginGlobalTransaction();
        EmployeeView ev = gtx.get(EmployeeViewMeta.get(), key, version);
        gtx.delete(ev.getKey(), ev.getEmployeeKey());
        gtx.commit();
    }

}
