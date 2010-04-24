package jp.co.softem.apps.service.master;

import jp.co.softem.apps.meta.master.EmployeeMeta;
import jp.co.softem.apps.model.master.Employee;

public class EmployeeService extends BaseService<Employee> {

    private static final long serialVersionUID = 1L;

    public EmployeeService() {
        super(EmployeeMeta.get());
    }

}
