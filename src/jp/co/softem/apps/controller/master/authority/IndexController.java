package jp.co.softem.apps.controller.master.authority;

import jp.co.softem.apps.core.BaseController;
import jp.co.softem.apps.service.master.AuthorityService;

import org.slim3.controller.Navigation;

public class IndexController extends BaseController {

    @Override
    protected Navigation run() throws Exception {
        requestScope("list", new AuthorityService().getAll());
        return forward("index.jsp");
    }

}
