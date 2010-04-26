package jp.co.softem.apps.controller.master.authority;

import jp.co.softem.apps.core.BaseController;

import org.slim3.controller.Navigation;

public class CreateController extends BaseController {

    @Override
    protected Navigation run() throws Exception {
        return forward("create.jsp");
    }

}
