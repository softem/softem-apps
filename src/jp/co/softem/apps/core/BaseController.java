package jp.co.softem.apps.core;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public abstract class BaseController extends Controller {

    @Override
    public Navigation runBare() throws Throwable {
        Navigation navi = super.runBare();
        String path = navi.getPath();
        boolean isRedirect = navi.isRedirect();
        if (isRedirect) {
            sessionScope("page", path + "index.jsp");
            return new Navigation(path, isRedirect);
        } else {
            sessionScope("page", basePath + path);
            return new Navigation("/template.jsp", isRedirect);
        }
    }

}
