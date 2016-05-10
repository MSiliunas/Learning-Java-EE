package Entities;

import javax.persistence.*;

@Entity
@Table(name = "USER_ROLE")
public class UserRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    public int id;

    @Basic
    @Column(name = "ROLE_NAME", nullable = false, length = 64)
    private String roleName;

    @Version
    @Column(name = "OPTLOCKVERSION")
    private int optLockVersion;

    public UserRoleEntity() {
    }

    public UserRoleEntity(String roleName) {
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return getRoleName();
    }
}
