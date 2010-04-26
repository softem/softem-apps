package jp.co.softem.apps.service.master;

import java.util.ArrayList;
import java.util.List;

import jp.co.softem.apps.core.BaseService;
import jp.co.softem.apps.meta.master.AuthorityMeta;
import jp.co.softem.apps.meta.master.EmployeeMeta;
import jp.co.softem.apps.model.master.Authority;
import jp.co.softem.apps.model.master.Employee;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;

import com.google.appengine.api.datastore.Key;

public class EmployeeService extends BaseService<Employee> {

    public EmployeeService() {
        super(EmployeeMeta.get());
    }

    public List<Employee> findByName(String words) {
        EmployeeMeta e = EmployeeMeta.get();
        return Datastore
            .query(e)
            .filterInMemory(e.employeeName.contains(words))
            .asList();
    }

    public List<Employee> findByAuthorityName(String words) {
        AuthorityMeta authorityMeta = AuthorityMeta.get();
        List<Authority> authorityList =
            Datastore.query(authorityMeta).filterInMemory(
                authorityMeta.authorityName.contains(words)).asList();
        List<Employee> list = new ArrayList<Employee>();
        for (Authority auth : authorityList) {
            list.addAll(auth.getEmployeeListRef().getModelList());
        }
        return list;
    }

    public void insert(Employee employee, Key authorityKey) {
        GlobalTransaction gtx = Datastore.beginGlobalTransaction();
        Authority authority = gtx.get(Authority.class, authorityKey);
        employee.getAuthorityRef().setModel(authority);
        gtx.put(employee);
        gtx.commit();
    }

}
