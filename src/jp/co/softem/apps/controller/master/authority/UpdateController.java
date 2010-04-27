package jp.co.softem.apps.controller.master.authority;

import jp.co.softem.apps.core.BaseController;
import jp.co.softem.apps.meta.master.AuthorityMeta;
import jp.co.softem.apps.service.master.AuthorityService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

public class UpdateController extends BaseController {

    private AuthorityService service = new AuthorityService();

    private AuthorityMeta meta = AuthorityMeta.get();

    @Override
    public Navigation run() throws Exception {
        if (!validate()) {
            return forward("edit");
        }
        service.update(asKey(meta.key), asLong(meta.version), new RequestMap(
            request));
        return redirect(basePath);
    }

    private boolean validate() {
        Validators v = new Validators(request);
        v.add(meta.authorityName, v.required());
        return v.validate();
    }

}
