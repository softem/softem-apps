package jp.co.softem.apps.controller.master.employee;

import jp.co.softem.apps.core.BaseController;
import jp.co.softem.apps.service.master.EmployeeService;

import org.slim3.controller.Navigation;

public class IndexController extends BaseController {

    @Override
    public Navigation run() throws Exception {
        requestScope("list", new EmployeeService().getAll());
        return forward("index.jsp");
    }

}
