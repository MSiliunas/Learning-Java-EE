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
    private int userId;

    @Version
    private int optLockVersion;

    @ManyToOne
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
    @Column(name = "USER_ID", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostEntity that = (PostEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (slug != null ? !slug.equals(that.slug) : that.slug != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (slug != null ? slug.hashCode() : 0);
        result = 31 * result + userId;
        return result;
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
}
