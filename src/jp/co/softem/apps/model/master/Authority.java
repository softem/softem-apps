package jp.co.softem.apps.model.master;

import java.io.Serializable;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

@Model(schemaVersion = 1)
public class Authority implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key authorityKey;

    @Attribute(version = true)
    private Long version;

    private String authorityName;

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    /**
     * Returns the key.
     * 
     * @return the key
     */
    public Key getAuthorityKey() {
        return authorityKey;
    }

    /**
     * Sets the key.
     * 
     * @param key
     *            the key
     */
    public void setAuthorityKey(Key key) {
        this.authorityKey = key;
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
                + ((authorityKey == null) ? 0 : authorityKey.hashCode());
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
        Authority other = (Authority) obj;
        if (authorityKey == null) {
            if (other.authorityKey != null) {
                return false;
            }
        } else if (!authorityKey.equals(other.authorityKey)) {
            return false;
        }
        return true;
    }
}
