import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

@PreMatching
@Provider
public class RewriteAmazonRequestFilter implements ContainerRequestFilter {
    @Override
    public void filter (ContainerRequestContext request) {
        MultivaluedMap<String, String> headers = request.getHeaders();
        if (headers.getFirst("x-amz-sns-message-type") != null) {
            // rewrite the content-type
            headers.putSingle("Content-Type", "application/json");
        }
    }
}
