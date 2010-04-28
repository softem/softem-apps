package jp.co.softem.apps.controller.authority;

import jp.co.softem.apps.core.BaseController;
import jp.co.softem.apps.meta.AuthorityMeta;
import jp.co.softem.apps.model.Authority;
import jp.co.softem.apps.service.AuthorityService;

import org.slim3.controller.Navigation;
import org.slim3.util.BeanUtil;

public class EditController extends BaseController {

    private AuthorityService service = new AuthorityService();

    private AuthorityMeta meta = AuthorityMeta.get();

    @Override
    protected Navigation run() throws Exception {
        if (errors.isEmpty()) {
            Authority entity =
                service.get(asKey(meta.key), asLong(meta.version));
            BeanUtil.copy(entity, request);
        }
        return forward("edit.jsp");
    }

}
