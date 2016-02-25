package Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by msiliunas on 25/02/16.
 */
@Entity
@Table(name = "USER", schema = "APP", catalog = "")
public class UserEntity {
    private int id;
    private String email;

    @Version
    @Column(name = "OPTLOCKVERSION")
    private int optLockVersion;

    @ManyToMany
    @JoinTable(name = "USER_USER_ROLE")
    private List<UserRoleEntity> roles = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<PostEntity> posts = new ArrayList<>();

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "EMAIL", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getOptLockVersion() {
        return optLockVersion;
    }

    public void setOptLockVersion(int optLockVersion) {
        this.optLockVersion = optLockVersion;
    }

    public List<UserRoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRoleEntity> roles) {
        this.roles = roles;
    }

    public List<PostEntity> getPosts() {
        return posts;
    }

    public void setPosts(List<PostEntity> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        return email.equals(that.email);

    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}
