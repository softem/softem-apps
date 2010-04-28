package jp.co.softem.apps.controller.master;

import jp.co.softem.apps.core.BaseController;

import org.slim3.controller.Navigation;

public class IndexController extends BaseController {

    @Override
    public Navigation run() throws Exception {
        return forward("index.jsp");
    }
}
