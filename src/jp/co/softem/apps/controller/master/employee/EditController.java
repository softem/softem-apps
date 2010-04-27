package jp.co.softem.apps.controller.master.employee;

import jp.co.softem.apps.core.BaseController;
import jp.co.softem.apps.meta.master.EmployeeMeta;
import jp.co.softem.apps.model.master.Employee;
import jp.co.softem.apps.service.master.AuthorityService;
import jp.co.softem.apps.service.master.EmployeeService;

import org.slim3.controller.Navigation;
import org.slim3.util.BeanUtil;

public class EditController extends BaseController {

    private EmployeeService service = new EmployeeService();

    private EmployeeMeta meta = EmployeeMeta.get();

    @Override
    protected Navigation run() throws Exception {
        if (errors.isEmpty()) {
            Employee e = service.get(asKey(meta.key), asLong(meta.version));
            BeanUtil.copy(e, request);
        }
        requestScope("authorityList", new AuthorityService().getAll());
        return forward("edit.jsp");
    }

}
