package com.lsz.cloud.filter;

import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Slf4j
@Component
public class LogFilter extends OncePerRequestFilter {
    public static final Set<String> STATIC = Sets.newHashSet(
            "htm", "html", "js", "map", "css", "jpg", "png", "gif", "ico", "bmp",
            "otf", "eot", "svg", "ttf", "woff", "woff2", "swf", "wav", "ogg", "mp3"
    );
    private static final Set<String> SKIPS = Sets.newHashSet(
            "/health", "/metrics"
    );

    public static boolean isStatic(String uri) {
        String[] ext = uri.split("\\.");
        return STATIC.contains(ext[ext.length - 1]);
    }

    protected static boolean needProcess(HttpServletRequest request) {
        String uri = request.getRequestURI();
        return !isStatic(uri) && !SKIPS.contains(uri);
    }

    protected void process(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String threadName = request.getHeader("SZ-threadName");
        if (!StringUtils.isEmpty(threadName)) {
            Thread.currentThread().setName(threadName);
        }

        long beg = System.currentTimeMillis();
        try {
            filterChain.doFilter(request, response);
        } finally {
            long end = System.currentTimeMillis();
            log.info("##### Request [{}] Cost[{}ms]", uri, end - beg);
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (needProcess(request)) {
            process(request, response, filterChain);
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
