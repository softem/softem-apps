package jp.co.softem.apps.controller.employee;

import java.util.List;

import jp.co.softem.apps.core.BaseController;
import jp.co.softem.apps.model.Employee;
import jp.co.softem.apps.service.EmployeeService;

import org.slim3.controller.Navigation;

public class IndexController extends BaseController {

    private EmployeeService service = new EmployeeService();

    @Override
    public Navigation run() throws Exception {
        List<Employee> list = service.list(offset(), LIMIT);
        int total = service.count();
        int count = list.size();
        requestScope("pagenator", createPagenator(total, count));
        requestScope("list", service.getAll());
        return forward("index.jsp");
    }

}
