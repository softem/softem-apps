package jp.co.softem.apps.controller.employee;

import jp.co.softem.apps.core.BaseController;
import jp.co.softem.apps.meta.EmployeeMeta;
import jp.co.softem.apps.service.EmployeeService;

import org.slim3.controller.Navigation;

public class DeleteController extends BaseController {

    private EmployeeService service = new EmployeeService();

    private EmployeeMeta meta = EmployeeMeta.get();

    @Override
    public Navigation run() throws Exception {
        service.delete(asKey(meta.key), asLong(meta.version));
        return redirect(basePath);
    }
}
