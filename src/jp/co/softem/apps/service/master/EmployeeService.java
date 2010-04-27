package jp.co.softem.apps.service.master;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.softem.apps.core.BaseService;
import jp.co.softem.apps.meta.master.AuthorityMeta;
import jp.co.softem.apps.meta.master.EmployeeMeta;
import jp.co.softem.apps.model.master.Authority;
import jp.co.softem.apps.model.master.Employee;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.GlobalTransaction;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class EmployeeService extends BaseService<Employee> {

    public EmployeeService() {
        super(EmployeeMeta.get());
    }

    public List<Employee> getByEmployeeName(String words) {
        EmployeeMeta meta = EmployeeMeta.get();
        return Datastore.query(meta).filterInMemory(
            meta.employeeName.contains(words)).asList();
    }

    public List<Employee> getByAuthorityName(String words) {
        List<Employee> list = new ArrayList<Employee>();
        AuthorityMeta meta = AuthorityMeta.get();
        List<Authority> authorityList =
            Datastore.query(meta).filterInMemory(
                meta.authorityName.contains(words)).asList();
        for (Authority authority : authorityList) {
            list.addAll(authority.getEmployeeListRef().getModelList());
        }
        return list;
    }

    public void insert(Employee employee) {
        GlobalTransaction gtx = Datastore.beginGlobalTransaction();
        Key authKey = KeyFactory.stringToKey(employee.getAuthority());
        Authority authority = gtx.get(AuthorityMeta.get(), authKey);
        employee.getAuthorityRef().setModel(authority);
        gtx.put(employee);
        gtx.commit();
    }

    public Employee update(Key key, Long version, Map<String, Object> input) {
        GlobalTransaction gtx = Datastore.beginGlobalTransaction();
        Employee employee = gtx.get(baseMeta, key, version);
        BeanUtil.copy(input, employee);
        Key authKey = KeyFactory.stringToKey(employee.getAuthority());
        Authority authority = gtx.get(AuthorityMeta.get(), authKey);
        employee.getAuthorityRef().setModel(authority);
        gtx.put(employee);
        gtx.commit();
        return employee;
    }

    public void delete(Key key, Long version) {
        GlobalTransaction gtx = Datastore.beginGlobalTransaction();
        Employee employee = gtx.get(baseMeta, key, version);
        gtx.delete(employee.getKey(), employee.getKey());
        gtx.commit();
    }

}
