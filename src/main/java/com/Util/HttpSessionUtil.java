package com.Util;

import org.hibernate.Session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class HttpSessionUtil {

    public boolean getHttpSession(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        return true;
    }
}
