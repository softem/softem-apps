package jp.co.softem.apps.controller.authority;

import jp.co.softem.apps.core.BaseController;
import jp.co.softem.apps.service.AuthorityService;

import org.slim3.controller.Navigation;

public class IndexController extends BaseController {

    private AuthorityService service = new AuthorityService();

    @Override
    protected Navigation run() throws Exception {
        requestScope("list", new AuthorityService().getAll());
        String words = asString("words");
        if (words == null || words.length() == 0) {
            requestScope("list", service.getAll());
        } else {
            requestScope("list", service.getByAuthorityName(words));
        }
        return forward("index.jsp");
    }

}
