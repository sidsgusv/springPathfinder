package com.example.pathfind.model.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity{

    @Column(nullable = false)
    private boolean approved;

    @Column(nullable = false)
    private Instant created;
    @Column(columnDefinition = "TEXT",name = "text_content")
    private String content;
    @ManyToOne(optional = false)
    private User author;
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Route route;

    public Comment() {
    }




    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
