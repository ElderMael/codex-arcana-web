package org.mael.blog.model;

import static javax.persistence.GenerationType.*;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "news")
public class NewsEntry {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "entry_id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Lob
    @Column(name = "content")
    private String content;

    public NewsEntry() {
    }

    public NewsEntry(Integer id, String title, Date date, String content) {
        super();
        this.id = id;
        this.title = title;
        this.date = date;
        this.content = content;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
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
