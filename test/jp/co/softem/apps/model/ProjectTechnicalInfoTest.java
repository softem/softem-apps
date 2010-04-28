package jp.co.softem.apps.model;

import jp.co.softem.apps.model.ProjectTechnicalInfo;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ProjectTechnicalInfoTest extends AppEngineTestCase {

    private ProjectTechnicalInfo model = new ProjectTechnicalInfo();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
