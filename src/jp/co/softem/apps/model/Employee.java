package jp.co.softem.apps.model;

import java.io.Serializable;

import jp.co.softem.apps.meta.ProjectCompleteReportMeta;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Key;

@Model(schemaVersion = 1)
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    private String employeeName;

    private String authorityKey;

    private ModelRef<Authority> authorityRef =
        new ModelRef<Authority>(Authority.class);

    @Attribute(persistent = false)
    private InverseModelListRef<ProjectCompleteReport, Employee> projectCompleteReportRef =
        new InverseModelListRef<ProjectCompleteReport, Employee>(
            ProjectCompleteReport.class,
            ProjectCompleteReportMeta.get().employeeRef,
            this);

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getAuthorityKey() {
        return authorityKey;
    }

    public void setAuthorityKey(String authorityKey) {
        this.authorityKey = authorityKey;
    }

    public ModelRef<Authority> getAuthorityRef() {
        return authorityRef;
    }

    public InverseModelListRef<ProjectCompleteReport, Employee> getProjectCompleteReportRef() {
        return projectCompleteReportRef;
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
        Employee other = (Employee) obj;
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
