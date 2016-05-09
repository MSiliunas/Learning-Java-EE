package Entities;

import javax.persistence.*;

/**
 * Created by msiliunas on 25/02/16.
 */
@Entity
@Table(name = "POST", schema = "APP", catalog = "")
public class PostEntity {

    @Id
    @Column(name = "ID", nullable = false)
    private int id;

    @Basic
    @Column(name = "SLUG", nullable = false, length = 64)
    private String slug;

    @Version
    @Column(name = "OPTLOCKVERSION", insertable = false, updatable = false)
    private int optLockVersion;

    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.EAGER)
    private UserEntity user;

    @Basic
    @Column(name = "TITLE", nullable = true, length = 64)
    private String title;

    @Basic
    @Column(name = "CONTENT", nullable = true, length = 32700)
    private String content;

    @Basic
    @Column(name = "USER_ID", nullable = false)
    private int userId;

    @Basic
    @Column(name = "OPTLOCKVERSION", nullable = true)
    private Integer optlockversion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getOptLockVersion() {
        return optLockVersion;
    }

    public void setOptLockVersion(int optLockVersion) {
        this.optLockVersion = optLockVersion;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostEntity that = (PostEntity) o;

        return slug.equals(that.slug);

    }

    @Override
    public int hashCode() {
        return slug.hashCode();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getOptlockversion() {
        return optlockversion;
    }

    public void setOptlockversion(Integer optlockversion) {
        this.optlockversion = optlockversion;
    }
}
