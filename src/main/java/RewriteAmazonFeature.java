import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

/**
 * Created by wlee on 12/18/14.
 */
@PreMatching
@Provider
public class RewriteAmazonFeature implements DynamicFeature {
    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext context) {
        System.out.println("Registering filter");
        context.register(RewriteAmazonRequestFilter.class);
    }
}
