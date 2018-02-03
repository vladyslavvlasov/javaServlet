package com.slava;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

/**
 * Created by Vladyslav Vlasov on 27.01.2018.
 */
public class GzipUtility {
    public static boolean isGzipSupported(HttpServletRequest request) {
        String encoding = request.getHeader("Accept-Encoding");
        return (encoding != null) && (encoding.contains("gzip"));
    }

    public static boolean isGzipDisabled(HttpServletRequest request) {
        String flag = request.getParameter("disableGzip");
        return ((flag != null) && (!flag.equalsIgnoreCase("false")));
    }

    public static PrintWriter getGzipWriter(HttpServletResponse response) throws IOException {
        return (new PrintWriter(new GZIPOutputStream(response.getOutputStream())));
    }
}
