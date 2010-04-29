package jp.co.softem.apps.controller.authority;

import java.util.List;

import jp.co.softem.apps.core.BaseController;
import jp.co.softem.apps.model.Authority;
import jp.co.softem.apps.service.AuthorityService;

import org.slim3.controller.Navigation;

public class IndexController extends BaseController {

    private AuthorityService service = new AuthorityService();

    @Override
    protected Navigation run() throws Exception {
        List<Authority> list = service.list(offset(), LIMIT);
        int total = service.count();
        int count = list.size();
        requestScope("pagenator", createPagenator(total, count));
        requestScope("list", list);
        return forward("index.jsp");
    }

}
