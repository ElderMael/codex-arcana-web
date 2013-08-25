package org.mael.blog.web.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.mael.blog.dao.NewsDao;
import org.mael.blog.model.NewsEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    protected static final Logger log = LoggerFactory
            .getLogger(IndexController.class);

    @Autowired
    private NewsDao newsDao;

    public IndexController() {
    }

    @RequestMapping(method = GET, value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(method = GET, value = "/news")
    @ResponseBody
    public Map<String, Object> loadNews() {

        Map<String, Object> json = new HashMap<>();

        List<NewsEntry> entries = this.newsDao.loadNews();

        log.debug("Loaded {} news entries.", entries.size());

        json.put("entries", entries);

        return json;
    }

    public NewsDao getNewsDao() {
        return newsDao;
    }

    public void setNewsDao(NewsDao newsDao) {
        this.newsDao = newsDao;
    }
}