package com.rabbitmq.cluster.model;

import java.io.Serializable;

public class News implements Serializable {

  private String uuid;
  private String title;
  private String content;

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
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

  @Override
  public String toString() {
    return "News{"
        + "uuid='"
        + uuid
        + '\''
        + ", title='"
        + title
        + '\''
        + ", content='"
        + content
        + '\''
        + '}';
  }
}
