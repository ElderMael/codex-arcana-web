package org.mael.blog.model;

import java.util.Date;

public class NewsEntry {

    private String title;
    private Date date;
    private String content;

    public NewsEntry() {
    }

    public NewsEntry(String title, Date date, String content) {
        this.title = title;
        this.date = date;
        this.content = content;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
