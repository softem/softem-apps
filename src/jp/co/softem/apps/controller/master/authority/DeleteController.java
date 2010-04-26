package jp.co.softem.apps.controller.master.authority;

import jp.co.softem.apps.meta.master.AuthorityMeta;
import jp.co.softem.apps.service.master.AuthorityService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class DeleteController extends Controller {

    private AuthorityService service = new AuthorityService();

    private AuthorityMeta meta = AuthorityMeta.get();

    @Override
    public Navigation run() throws Exception {
        service.delete(asKey(meta.key), asLong(meta.version));
        return redirect(basePath);
    }   
}
