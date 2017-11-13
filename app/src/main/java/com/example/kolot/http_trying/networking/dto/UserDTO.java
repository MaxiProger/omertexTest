package com.example.kolot.http_trying.networking.dto;

/**
 * Created by kolot on 21.10.2017.
 */

public class UserDTO {
    private String location;

    private Profile_imageDTO profile_image;

    private String portfolio_url;

    private LinksDTO links;

    private String total_photos;

    private String total_likes;

    private String id;

    private String first_name;

    private String username;

    private String updated_at;

    private String bio;

    private String name;

    private String total_collections;

    private String last_name;

    private String twitter_username;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Profile_imageDTO getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(Profile_imageDTO profile_image) {
        this.profile_image = profile_image;
    }

    public String getPortfolio_url() {
        return portfolio_url;
    }

    public void setPortfolio_url(String portfolio_url) {
        this.portfolio_url = portfolio_url;
    }

    public LinksDTO getLinks() {
        return links;
    }

    public void setLinks(LinksDTO links) {
        this.links = links;
    }

    public String getTotal_photos() {
        return total_photos;
    }

    public void setTotal_photos(String total_photos) {
        this.total_photos = total_photos;
    }

    public String getTotal_likes() {
        return total_likes;
    }

    public void setTotal_likes(String total_likes) {
        this.total_likes = total_likes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotal_collections() {
        return total_collections;
    }

    public void setTotal_collections(String total_collections) {
        this.total_collections = total_collections;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTwitter_username() {
        return twitter_username;
    }

    public void setTwitter_username(String twitter_username) {
        this.twitter_username = twitter_username;
    }
}
