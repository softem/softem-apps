package jp.co.softem.apps.model.master;

import java.io.Serializable;

import jp.co.softem.apps.meta.master.ProjectTechnicalInfoMeta;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Key;

@Model(schemaVersion = 1)
public class ProjectCompleteReport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    private String projectCompleteName;

    public String getProjectCompleteName() {
        return projectCompleteName;
    }

    public void setProjectCompleteName(String projectCompleteName) {
        this.projectCompleteName = projectCompleteName;
    }

    private ModelRef<Employee> employeeRef =
        new ModelRef<Employee>(Employee.class);

    public ModelRef<Employee> getEmployeeRef() {
        return employeeRef;
    }

    @Attribute(persistent = false)
    private InverseModelListRef<ProjectTechnicalInfo, ProjectCompleteReport> projectTechnicalInfoListRef =
        new InverseModelListRef<ProjectTechnicalInfo, ProjectCompleteReport>(
            ProjectTechnicalInfo.class,
            ProjectTechnicalInfoMeta.get().projectCompleteReportRef,
            this);

    public InverseModelListRef<ProjectTechnicalInfo, ProjectCompleteReport> getProjectTechnicalInfoListRef() {
        return projectTechnicalInfoListRef;
    }

    /**
     * Returns the key.
     * 
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     * 
     * @param key
     *            the key
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     * 
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     * 
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ProjectCompleteReport other = (ProjectCompleteReport) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }
}
