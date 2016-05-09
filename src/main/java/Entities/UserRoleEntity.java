package Entities;

import javax.persistence.*;

/**
 * Created by msiliunas on 25/02/16.
 */
@Entity
@Table(name = "USER_ROLE", schema = "APP", catalog = "")
public class UserRoleEntity {
    private int id;
    private String roleName;

    @Version
    @Column(name = "OPTLOCKVERSION")
    private int optLockVersion;
    private Integer optlockversion;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ROLE_NAME", nullable = false, length = 64)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getOptLockVersion() {
        return optLockVersion;
    }

    public void setOptLockVersion(int optLockVersion) {
        this.optLockVersion = optLockVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRoleEntity that = (UserRoleEntity) o;

        return roleName.equals(that.roleName);

    }

    @Override
    public int hashCode() {
        return roleName.hashCode();
    }

    @Basic
    @Column(name = "OPTLOCKVERSION", nullable = true)
    public Integer getOptlockversion() {
        return optlockversion;
    }

    public void setOptlockversion(Integer optlockversion) {
        this.optlockversion = optlockversion;
    }
}
