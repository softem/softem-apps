package jp.co.softem.apps.controller.master.authority;

import jp.co.softem.apps.core.BaseController;
import jp.co.softem.apps.meta.master.AuthorityMeta;
import jp.co.softem.apps.service.master.AuthorityService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;

public class DeleteController extends BaseController {

    private AuthorityService service = new AuthorityService();

    private AuthorityMeta meta = AuthorityMeta.get();

    @Override
    public Navigation run() throws Exception {
        Validators v = new Validators(request);
        if (!service.delete(asKey(meta.key), asLong(meta.version), v)) {
            return forward(basePath);
        }
        return redirect(basePath);
    }
}
