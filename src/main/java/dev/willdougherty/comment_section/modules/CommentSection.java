package dev.willdougherty.comment_section.modules;

import java.util.ArrayList;
import java.util.Date;

public class CommentSection {
  // comment class; accessable within package scope
  class Comment {
    // class attributes
    public String userID, username, comment, parent;
    public Date date;

    // constructor
    public Comment(String userID, String username, String comment, Date date, String parent) {
      this.userID = userID;
      this.username = username;
      this.comment = comment;
      this.date = date;
      this.parent = parent;
    }
  }

  // class attributes
  public String postID;
  private ArrayList<Comment> comments;

  // class methods
  public CommentSection(String postID) {
    this.postID = postID;
    this.comments = new ArrayList<Comment>();
  }

  // getters
  public ArrayList<Comment> getComments() {
    return comments;
  }
}
