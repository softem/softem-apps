package jp.co.softem.apps.controller.employee;

import jp.co.softem.apps.core.BaseController;
import jp.co.softem.apps.service.AuthorityService;

import org.slim3.controller.Navigation;

public class CreateController extends BaseController {

    private AuthorityService service = new AuthorityService();

    @Override
    protected Navigation run() throws Exception {
        requestScope("authorityList", service.getAll());
        return forward("create.jsp");
    }

}
