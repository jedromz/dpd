package com.dpdgroup.api.filters;

import com.dpdgroup.api.model.RequestLog;
import com.dpdgroup.api.model.RequestLogRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class RequestLoggingFilter implements Filter {

    private final RequestLogRepository requestLogRepository;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        String requestUri = httpRequest.getRequestURI();
        if (requestUri.startsWith("/orders")) {
            RequestLog requestLog = RequestLog.builder()
                    .uri(requestUri)
                    .method(httpRequest.getMethod())
                    .timestamp(LocalDateTime.now())
                    .build();

            requestLogRepository.save(requestLog);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
