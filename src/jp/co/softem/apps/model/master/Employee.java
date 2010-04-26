package jp.co.softem.apps.model.master;

import java.io.Serializable;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

@Model(schemaVersion = 1)
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key employeeKey;

    @Attribute(version = true)
    private Long version;

    private String employeeName;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * Returns the key.
     * 
     * @return the key
     */
    public Key getEmployeeKey() {
        return employeeKey;
    }

    /**
     * Sets the key.
     * 
     * @param key
     *            the key
     */
    public void setEmployeeKey(Key key) {
        this.employeeKey = key;
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
        result =
            prime
                * result
                + ((employeeKey == null) ? 0 : employeeKey.hashCode());
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
        if (employeeKey == null) {
            if (other.employeeKey != null) {
                return false;
            }
        } else if (!employeeKey.equals(other.employeeKey)) {
            return false;
        }
        return true;
    }
}
