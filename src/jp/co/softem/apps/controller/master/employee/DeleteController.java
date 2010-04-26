package jp.co.softem.apps.controller.master.employee;

import jp.co.softem.apps.meta.master.EmployeeMeta;
import jp.co.softem.apps.service.master.EmployeeService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class DeleteController extends Controller {

    private EmployeeService service = new EmployeeService();

    private EmployeeMeta meta = EmployeeMeta.get();

    @Override
    public Navigation run() throws Exception {
        service.delete(asKey(meta.key), asLong(meta.version));
        return redirect(basePath);
    }   
}
