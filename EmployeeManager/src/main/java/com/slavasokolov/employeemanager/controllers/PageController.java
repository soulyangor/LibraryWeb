package com.slavasokolov.employeemanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    public static final String EMPLOYEES_PAGE_PATH = "/employees_page";
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

    @RequestMapping(EMPLOYEES_PAGE_PATH)
    public String getEmployeesPage() {
        return "employees_page";
    }

    @RequestMapping(POSTS_PAGE_PATH)
    public String getPostsPage() {
        return "posts_page";
    }

    @RequestMapping(DEPARTMENTS_PAGE_PATH)
    public String getDepartmentsPage() {
        return "departments_page";
    }

    @RequestMapping("/calendar_periods_page")
    public String getCalendarPeriodsPage() {
        return "calendar_periods_page";
    }

}
