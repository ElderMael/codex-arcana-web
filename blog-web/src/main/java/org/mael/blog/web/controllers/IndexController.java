package org.mael.blog.web.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.mael.blog.model.NewsEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    protected static final Logger log = LoggerFactory
            .getLogger(IndexController.class);

    @RequestMapping(method = GET, value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(method = GET, value = "/news")
    @ResponseBody
    public Map<String, Object> loadNews() {

        Map<String, Object> json = new HashMap<>();

        LinkedList<NewsEntry> entries = new LinkedList<NewsEntry>();

        entries.add(new NewsEntry("Hello, World!", new Date(),
                "This is Miguel!"));
        entries.add(new NewsEntry("Requesting", new Date(), "Mark II"));

        log.debug("Sending {} news entries.", entries.size());

        json.put("entries", entries);

        return json;
    }
}