package com.fasoo.syn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Writer: 
 * Date: 4/12/12
 */
public class WeakPasswordRequirements {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String id = request.getParameter("id");
            String passwd = request.getParameter("passwd"); /* ALARM */
            // 패스워드 복잡도 없이 가입 승인 처리
        } catch (Exception e) {

        }
    }

    public void doPostSafe(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String id = request.getParameter("id");
            String passwd = request.getParameter("passwd");

            // passwd 에 대한 복잡도 검증
            if (passwd == null || "".equals(passwd)) return;
            if (!passwd.matches("") && passwd.indexOf("@!#") > 4 && passwd.length() > 8) {
                // passwd 복잡도 검증 후, 가입 승인 처리
            }
        } catch (Exception e) {

        }
    }
}
