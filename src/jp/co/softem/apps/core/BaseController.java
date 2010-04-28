package jp.co.softem.apps.core;

import java.util.ConcurrentModificationException;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.datastore.EntityNotFoundRuntimeException;
import org.slim3.util.ApplicationMessage;

public abstract class BaseController extends Controller {

    public static String MESSAGE = "message";

    public static String ENCODE = "UTF-8";

    protected String onErrorPath;

    @Override
    public Navigation runBare() throws Throwable {
        String ms = "";
        try {
            return perform();
        } catch (EntityNotFoundRuntimeException e) {
            ms = ApplicationMessage.get("validator.not.found");
        } catch (ConcurrentModificationException e) {
            ms = ApplicationMessage.get("validator.modification");
        } catch (Exception e) {
            Throwable c = e.getCause();
            String params = (c == null) ? e.getMessage() : c.getMessage();
            ms = ApplicationMessage.get("validator.exception", params);
        }
        Validators v = new Validators(request);
        v.getErrors().put(MESSAGE, ms);
        return forward((onErrorPath == null) ? basePath : onErrorPath);
    }

    private Navigation perform() throws Throwable {
        Navigation navi = super.runBare();
        String path = navi.getPath();
        boolean isRedirect = navi.isRedirect();
        if (isRedirect) {
            sessionScope("page", path + "index.jsp");
            return new Navigation(path, isRedirect);
        } else {
            if (path.endsWith(".jsp")) {
                sessionScope("page", basePath + path);
                return new Navigation("/template.jsp", isRedirect);
            } else {
                return navi;
            }
        }
    }

}
