package jp.co.softem.apps.controller.employee;

import jp.co.softem.apps.core.BaseController;
import jp.co.softem.apps.meta.EmployeeMeta;
import jp.co.softem.apps.model.Employee;
import jp.co.softem.apps.service.AuthorityService;
import jp.co.softem.apps.service.EmployeeService;

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
