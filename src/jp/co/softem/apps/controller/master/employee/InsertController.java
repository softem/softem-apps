package jp.co.softem.apps.controller.master.employee;

import jp.co.softem.apps.core.BaseController;
import jp.co.softem.apps.meta.master.EmployeeMeta;
import jp.co.softem.apps.model.master.Employee;
import jp.co.softem.apps.service.master.AuthorityService;
import jp.co.softem.apps.service.master.EmployeeService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.BeanUtil;

public class InsertController extends BaseController {

    private EmployeeService service = new EmployeeService();

    private EmployeeMeta meta = EmployeeMeta.get();

    private AuthorityService authorityService = new AuthorityService();

    @Override
    public Navigation run() throws Exception {
        if (!validate()) {
            requestScope("authorityList", authorityService.getAll());
            return forward("create.jsp");
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
