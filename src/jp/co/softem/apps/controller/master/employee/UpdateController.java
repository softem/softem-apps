package jp.co.softem.apps.controller.master.employee;

import jp.co.softem.apps.core.BaseController;
import jp.co.softem.apps.meta.master.EmployeeMeta;
import jp.co.softem.apps.service.master.EmployeeService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

public class UpdateController extends BaseController {

    private EmployeeService service = new EmployeeService();

    private EmployeeMeta meta = EmployeeMeta.get();

    @Override
    public Navigation run() throws Exception {
        if (!validate()) {
            return forward("edit.jsp");
        }
        service.update(asKey(meta.key), asLong(meta.version), new RequestMap(
            request));
        return redirect(basePath);
    }

    private boolean validate() {
        Validators v = new Validators(request);
        v.add(meta.employeeName, v.required());
        return v.validate();
    }

}
