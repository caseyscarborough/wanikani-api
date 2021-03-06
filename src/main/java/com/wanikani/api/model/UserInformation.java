package com.wanikani.api.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wanikani.api.config.Configuration;
import com.wanikani.api.json.LongToDateDeserializer;

import java.util.Date;

public class UserInformation {

  private String username;
  private String gravatar;
  private int level;
  private String title;
  private String about;
  private String website;
  private String twitter;
  private int topicsCount;
  private int postsCount;

  @JsonDeserialize(using = LongToDateDeserializer.class)
  private Date creationDate;

  @JsonDeserialize(using = LongToDateDeserializer.class)
  private Date vacationDate;

  public UserInformation() {
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getGravatar() {
    return gravatar;
  }

  public void setGravatar(String gravatar) {
    this.gravatar = gravatar;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAbout() {
    return about;
  }

  public void setAbout(String about) {
    this.about = about;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public String getTwitter() {
    return twitter;
  }

  public void setTwitter(String twitter) {
    this.twitter = twitter;
  }

  public int getTopicsCount() {
    return topicsCount;
  }

  public void setTopicsCount(int topicsCount) {
    this.topicsCount = topicsCount;
  }

  public int getPostsCount() {
    return postsCount;
  }

  public void setPostsCount(int postsCount) {
    this.postsCount = postsCount;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public Date getVacationDate() {
    return vacationDate;
  }

  public void setVacationDate(Date vacationDate) {
    this.vacationDate = vacationDate;
  }

  public boolean isInVacationMode() {
    return vacationDate != null;
  }

  public String getGravatarUrl() {
    return Configuration.GRAVATAR_BASE_URL + gravatar;
  }

  @Override
  public String toString() {
    return "UserInformation{" +
        "username='" + username + '\'' +
        ", gravatar='" + gravatar + '\'' +
        ", level=" + level +
        ", title='" + title + '\'' +
        ", about='" + about + '\'' +
        ", website='" + website + '\'' +
        ", twitter='" + twitter + '\'' +
        ", topicsCount=" + topicsCount +
        ", postsCount=" + postsCount +
        ", creationDate=" + creationDate +
        ", vacationDate=" + vacationDate +
        '}';
  }
}
