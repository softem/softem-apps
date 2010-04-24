package jp.co.softem.apps.core;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public abstract class BaseController extends Controller {

    @Override
    public Navigation runBare() throws Throwable {
        Navigation navi = super.runBare();
        requestScope("page", basePath + navi.getPath());
        return new Navigation("/template.jsp", navi.isRedirect());
    }

}
