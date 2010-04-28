package jp.co.softem.apps.controller.employee;

import jp.co.softem.apps.core.BaseController;
import jp.co.softem.apps.meta.EmployeeMeta;
import jp.co.softem.apps.model.Employee;
import jp.co.softem.apps.service.EmployeeService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.BeanUtil;

public class InsertController extends BaseController {

    private EmployeeService service = new EmployeeService();

    private EmployeeMeta meta = EmployeeMeta.get();

    @Override
    public Navigation run() throws Exception {
        if (!validate()) {
            return forward("create");
        }
        Employee employee = new Employee();
        BeanUtil.copy(request, employee);
        service.insert(employee);
        return redirect(basePath);
    }

    protected boolean validate() {
        Validators v = new Validators(request);
        v.add(meta.employeeName, v.required());
        return v.validate();
    }

}
