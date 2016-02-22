package Entities;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by msiliunas on 20/02/16.
 */
@Entity
@Table(name = "CHALLENGE", schema = "APP", catalog = "")
public class ChallengeEntity {
    private int id;
    private int topic;
    private int entryLimit;
    private Date createdAt;
    private Date endedAt;
    private int status;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TOPIC")
    public int getTopic() {
        return topic;
    }

    public void setTopic(int topic) {
        this.topic = topic;
    }

    @Basic
    @Column(name = "ENTRY_LIMIT")
    public int getEntryLimit() {
        return entryLimit;
    }

    public void setEntryLimit(int entryLimit) {
        this.entryLimit = entryLimit;
    }

    @Basic
    @Column(name = "CREATED_AT")
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "ENDED_AT")
    public Date getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(Date endedAt) {
        this.endedAt = endedAt;
    }

    @Basic
    @Column(name = "STATUS")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChallengeEntity that = (ChallengeEntity) o;

        if (id != that.id) return false;
        if (topic != that.topic) return false;
        if (entryLimit != that.entryLimit) return false;
        if (status != that.status) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (endedAt != null ? !endedAt.equals(that.endedAt) : that.endedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + topic;
        result = 31 * result + entryLimit;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (endedAt != null ? endedAt.hashCode() : 0);
        result = 31 * result + status;
        return result;
    }
}
