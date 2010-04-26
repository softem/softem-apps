package jp.co.softem.apps.controller.master.employee;

import jp.co.softem.apps.core.BaseController;
import jp.co.softem.apps.meta.master.EmployeeMeta;
import jp.co.softem.apps.model.master.Employee;
import jp.co.softem.apps.service.master.EmployeeService;

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
        Employee e = new Employee();
        BeanUtil.copy(request, e);
        service.insert(e, asKey("authority"));
        return redirect(basePath);
    }

    protected boolean validate() {
        Validators v = new Validators(request);
        v.add(meta.employeeName, v.required());
        return v.validate();
    }

}
