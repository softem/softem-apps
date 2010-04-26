package jp.co.softem.apps.model.master;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class EmployeeViewTest extends AppEngineTestCase {

    private EmployeeView model = new EmployeeView();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
