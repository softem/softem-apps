package jp.co.softem.apps.model;

import jp.co.softem.apps.model.Authority;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class AuthorityTest extends AppEngineTestCase {

    private Authority model = new Authority();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
