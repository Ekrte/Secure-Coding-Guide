package com.fasoo.syn;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class RELIANCE_ON_UNTRUSTED_INPUTS_IN_A_SECURITY_DECISION_TestCase {
    public void test(HttpServletRequest request) {
        String userRole = null;
        Cookie [] cookies = request.getCookies(); /* TAINTED */
        for (int i = 0; i < cookies.length; i++) {
            Cookie c = cookies[i];
            if (c.getName().equals("role")) { /* BUG */ // Semantic taint analysis
                userRole = c.getValue();
            }
            if (Boolean.TRUE.equals(c.getValue())) { /* BUG */ // Semantic taint analysis

            }
        }
        Cookie authCookie = new Cookie("authenticated", "1"); /* BUG */ // Syntactic pattern analysis
    }
}