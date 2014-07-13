package org.daniels.examples.notification.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class CrossOriginFilter implements Filter {

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain filterChain) throws IOException, ServletException {
        if (response instanceof HttpServletResponse) {
            final HttpServletResponse alteredResponse = ((HttpServletResponse) response);
            addHeadersFor200Response(alteredResponse, request);
        }
        filterChain.doFilter(request, response);
    }

	private void addHeadersFor200Response(final HttpServletResponse response, final ServletRequest request) {
		if (request instanceof HttpServletRequest) {
			final String reqHead = ((HttpServletRequest) request)
					.getHeader("Access-Control-Request-Headers");
			if (reqHead != null && !reqHead.isEmpty()) {
				response.addHeader("Access-Control-Allow-Headers", reqHead);
			} else {
				response.addHeader(
						"Access-Control-Allow-Headers",
						"Origin, Accept, Accept-Version, Content-Length, Content-MD5, Content-Type, Date, X-Api-Version, X-Response-Time, X-PINGOTHER, X-CSRF-Token");
			}
		} else {
			response.addHeader(
					"Access-Control-Allow-Headers",
					"Origin, Accept, Accept-Version, Content-Length, Content-MD5, Content-Type, Date, X-Api-Version, X-Response-Time, X-PINGOTHER, X-CSRF-Token");
		}
		response.addHeader("Access-Control-Allow-Origin", ((HttpServletRequest) request).getHeader("origin"));
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		response.addHeader("Access-Control-Allow-Credentials", "true");
		response.addHeader("Access-Control-Max-Age", "1728000");
	}

    @Override
    public void destroy() {
    }

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
    }

}