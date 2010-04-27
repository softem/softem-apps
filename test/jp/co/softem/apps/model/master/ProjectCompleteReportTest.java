package jp.co.softem.apps.model.master;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ProjectCompleteReportTest extends AppEngineTestCase {

    private ProjectCompleteReport model = new ProjectCompleteReport();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
