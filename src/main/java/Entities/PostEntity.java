package Entities;

import javax.persistence.*;

/**
 * Created by msiliunas on 25/02/16.
 */
@Entity
@Table(name = "POST", schema = "APP", catalog = "")
public class PostEntity {
    private int id;
    private String slug;

    @Version
    @Column(name = "OPTLOCKVERSION")
    private int optLockVersion;

    @ManyToOne
    @Column(name = "USER_ID", nullable = false)
    private UserEntity user;

    private String title;
    private String content;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "SLUG", nullable = false, length = 64)
    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Basic
    @Column(name = "TITLE", nullable = true, length = 64)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "CONTENT", nullable = true, length = 32700)
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
}
