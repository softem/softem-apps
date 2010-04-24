package jp.co.softem.apps.service.master;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class EmployeeServiceTest extends AppEngineTestCase {

    private EmployeeService service = new EmployeeService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
