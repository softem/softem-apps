package jp.co.softem.apps.controller.master.authority;

import jp.co.softem.apps.core.BaseController;
import jp.co.softem.apps.meta.master.AuthorityMeta;
import jp.co.softem.apps.model.master.Authority;
import jp.co.softem.apps.service.master.AuthorityService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.BeanUtil;

public class InsertController extends BaseController {

    private AuthorityService service = new AuthorityService();

    private AuthorityMeta meta = AuthorityMeta.get();

    @Override
    public Navigation run() throws Exception {
        if (!validate()) {
            return forward("create");
        }
        Authority e = new Authority();
        BeanUtil.copy(request, e);
        service.insert(e);
        return redirect(basePath);
    }

    protected boolean validate() {
        Validators v = new Validators(request);
        v.add(meta.authorityName, v.required());
        return v.validate();
    }

}
