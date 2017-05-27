package com.minwoo.kang.xml.serialize;

import java.io.Serializable;

/**
 * Created on 2017. 5. 27..
 */
class Sample implements Serializable {

  private static final long serialVersionUID = -8504165710426544560L;

  private String name;
  private String email;
  private String content;

  static Sample of(String name, String email, String content) {
    Sample sample = new Sample();
    sample.name = name;
    sample.email = email;
    sample.content = content;
    return sample;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getContent() {
    return content;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Sample)) {
      return false;
    }

    Sample sample = (Sample) o;

    if (!name.equals(sample.name)) {
      return false;
    }
    if (!email.equals(sample.email)) {
      return false;
    }
    return content.equals(sample.content);
  }

  @Override
  public int hashCode() {
    int result = name.hashCode();
    result = 31 * result + email.hashCode();
    result = 31 * result + content.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "Sample{" +
        "name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", content='" + content + '\'' +
        '}';
  }
}
