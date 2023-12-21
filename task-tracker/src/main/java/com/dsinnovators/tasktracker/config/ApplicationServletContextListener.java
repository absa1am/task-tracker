package com.dsinnovators.tasktracker.config;

import com.dsinnovators.tasktracker.dao.TableCreateDAO;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ApplicationServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        new TableCreateDAO().seed();
    }

}
