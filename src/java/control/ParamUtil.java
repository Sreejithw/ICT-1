/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author hy
 */
public class ParamUtil {

    public static double getDouble(HttpServletRequest request, String paramName, double defaultValue) {
        try {
            return Double.parseDouble(request.getParameter(paramName));
        } catch (Exception e) {
            return defaultValue;
        }

    }
    
    public static int getInteger(HttpServletRequest request, String paramName, int defaultValue) {
        try {
            return Integer.parseInt(request.getParameter(paramName));
        } catch (Exception e) {
            return defaultValue;
        }

    }

    public static String getString(HttpServletRequest request, String paramName, String defaultValue) {
        if (request.getParameter(paramName) != null) {
            return request.getParameter(paramName);
        } else {
            return defaultValue;
        }
    }
    
    
    public static String getString(HttpServletRequest request, String paramName) {
        return getString(request,paramName,"");
    }
}
