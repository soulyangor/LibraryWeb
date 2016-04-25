package com.ivc.libraryweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    public static final String BOOK_TYPES_PAGE_PATH = "/book_types_page";
    public static final String POSTS_PAGE_PATH = "/posts_page";
    public static final String DEPARTMENTS_PAGE_PATH = "/departments_page";

    @RequestMapping("/")
    public String getStartPage() {
        return "start";
    }

    @RequestMapping("/test")
    public String getTestPage() {
        return "test";
    }

    @RequestMapping(BOOK_TYPES_PAGE_PATH)
    public String getBookTypePage() {
        return "book_types_page";
    }

}
