/**
 * Created by wlee on 12/5/14.
 */
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class EventApiApplication extends Application<EventApiConfiguration> {
    public static void main(String[] args) throws Exception {
        new EventApiApplication().run(args);
    }

    @Override
    public String getName() {
        return "OperationsEventApi";
    }

    @Override
    public void initialize(Bootstrap<EventApiConfiguration> bootstrap) {
        // nothing yet
    }

    @Override
    public void run(EventApiConfiguration configuration, Environment environment) {
        final EventApiResource resource = new EventApiResource(
                configuration.getMasterPassword(),
                configuration.getReadOnlyPassword(),
                configuration.getDbSubnet(),
                configuration.getSecurityGroup(),
                configuration.getDatabaseIdentifier()
        );
        environment.jersey().register(resource);
        environment.jersey().register(RewriteAmazonRequestFilter.class);
    }

}
