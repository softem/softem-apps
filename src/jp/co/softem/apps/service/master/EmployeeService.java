package jp.co.softem.apps.service.master;

import jp.co.softem.apps.core.BaseService;
import jp.co.softem.apps.meta.master.EmployeeMeta;
import jp.co.softem.apps.model.master.Employee;

public class EmployeeService extends BaseService<Employee> {

    public EmployeeService() {
        super(EmployeeMeta.get());
    }

}
