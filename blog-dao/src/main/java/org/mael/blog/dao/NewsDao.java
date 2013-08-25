package org.mael.blog.dao;

import java.util.List;

import org.mael.blog.model.NewsEntry;

public interface NewsDao {

    List<NewsEntry> loadNews();

    void createNew(NewsEntry entry);
}
