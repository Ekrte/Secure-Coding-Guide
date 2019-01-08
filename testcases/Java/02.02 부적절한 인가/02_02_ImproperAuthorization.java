package com.fasoo.syn;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;

/**
 * Writer: 
 * Date: 4/24/12
 */
public class ImproperAuthorization {

    public Map<String, String> getEnv() {
        Map<String, String> envMap = new HashMap<String, String>();
        // Do someething ...
        return envMap;
    }

    public void authorize(String sSingleId, int iFlag, String sServiceProvider, String sUid, String sPwd) {
        Map<String, String> env = System.getenv();
        Map env2 = getEnv();
        String noneString = "none";
        String authentication = Context.SECURITY_AUTHENTICATION;
        // do something
        env.put(Context.INITIAL_CONTEXT_FACTORY, "an_factory");
        env.put(Context.PROVIDER_URL, sServiceProvider);
        // 익명으로 LDAP 인증을 사용
        env.put(javax.naming.Context.SECURITY_AUTHENTICATION, "none"); /* alarm */
        env2.put(Context.SECURITY_AUTHENTICATION, noneString); /* alarm */
        env.put(authentication, "none"); /* alarm */
        System.getenv().put(authentication, "none"); /* alarm */
        env2.put(Context.SECURITY_AUTHENTICATION, "safe");
        env.put(Context.SECURITY_PRINCIPAL, sUid);
        env.put(Context.SECURITY_CREDENTIALS, sPwd);
        // ...
    }
}
