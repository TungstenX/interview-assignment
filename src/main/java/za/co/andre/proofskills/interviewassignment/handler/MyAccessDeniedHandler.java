package za.co.andre.proofskills.interviewassignment.handler;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

/**
 * The good old 403 handler...
 *
 * @author Andr&eacute; Labuschagn&eacute; <andre@ParanoidAndroid.co.za>
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    private final static Logger LOG = Logger.getLogger(MyAccessDeniedHandler.class.getName());

    /**
     * Dang! sucks to be you?
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void handle(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, AccessDeniedException e)
            throws IOException, ServletException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            LOG.log(Level.WARNING, "User '{0}' attempted to access the protected URL: {1}", new Object[]{auth.getName(), httpServletRequest.getRequestURI()});
        }
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/403");
    }
}
