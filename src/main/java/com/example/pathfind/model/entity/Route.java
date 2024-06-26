package com.example.pathfind.model.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity{

    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT")
    private String gpxCoordinates;
    @Enumerated(EnumType.STRING)
    private LevelEnum level;
    @Column(nullable = false)
    private String name;
    @Column(columnDefinition = "LONGTEXT")
    private String description;
    @Column(name = "video_url")
    private String videoUrl;
    @ManyToOne(optional = false)
    private User author;
    @OneToMany(targetEntity = Comment.class,mappedBy = "route")
    private Set<Comment> comments;
    @OneToMany(targetEntity = Picture.class,mappedBy = "route",fetch = FetchType.EAGER)
    private Set<Picture> pictures;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Category> categories;

    public Route() {
        this.pictures=new HashSet<>();
        this.comments=new HashSet<>();
        this.categories=new HashSet<>();
    }



    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public void setLevel(LevelEnum level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
