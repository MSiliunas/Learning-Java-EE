package Entities;

import javax.persistence.*;

@Entity
@Table(name = "POST")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    public int id;

    @Basic
    @Column(name = "SLUG", nullable = false, length = 64)
    private String slug;

    @Version
    @Column(name = "OPTLOCKVERSION")
    private int optLockVersion;

    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.EAGER)
    private UserEntity user;

    @Basic
    @Column(name = "TITLE", nullable = true, length = 64)
    private String title;

    @Basic
    @Column(name = "CONTENT", nullable = true, length = 32700)
    private String content;

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

}
