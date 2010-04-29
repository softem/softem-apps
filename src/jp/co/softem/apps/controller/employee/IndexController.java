package jp.co.softem.apps.controller.employee;

import jp.co.softem.apps.core.BaseController;
import jp.co.softem.apps.service.EmployeeService;

import org.slim3.controller.Navigation;

public class IndexController extends BaseController {

    private EmployeeService service = new EmployeeService();

    @Override
    public Navigation run() throws Exception {
        requestScope("list", service.getAll());
        return forward("index.jsp");
    }

}
