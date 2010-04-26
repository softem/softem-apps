package jp.co.softem.apps.controller.master.employee;

import jp.co.softem.apps.core.BaseController;
import jp.co.softem.apps.service.master.AuthorityService;

import org.slim3.controller.Navigation;

public class CreateController extends BaseController {

    AuthorityService service = new AuthorityService();

    @Override
    protected Navigation run() throws Exception {
        requestScope("authorityList", service.getAll());
        return forward("create.jsp");
    }

}
