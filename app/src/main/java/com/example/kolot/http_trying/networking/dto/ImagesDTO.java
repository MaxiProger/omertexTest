package com.example.kolot.http_trying.networking.dto;

/**
 * Created by kolot on 21.10.2017.
 */

public class ImagesDTO {
    private String[] current_user_collections;

    private UrlsDTO urls;

    private String width;

    private LinksDTO links;

    private String id;

    private String updated_at;

    private String height;

    private String color;


    private String likes;

    private String created_at;

    private String[] categories;

    private UserDTO user;

    private String liked_by_user;

    public String[] getCurrent_user_collections() {
        return current_user_collections;
    }

    public void setCurrent_user_collections(String[] current_user_collections) {
        this.current_user_collections = current_user_collections;
    }

    public UrlsDTO getUrls() {
        return urls;
    }

    public void setUrls(UrlsDTO urls) {
        this.urls = urls;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public LinksDTO getLinks() {
        return links;
    }

    public void setLinks(LinksDTO links) {
        this.links = links;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getLiked_by_user() {
        return liked_by_user;
    }

    public void setLiked_by_user(String liked_by_user) {
        this.liked_by_user = liked_by_user;
    }

}
