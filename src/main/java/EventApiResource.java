/**
 * Created by wlee on 12/5/14.
 */
import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.atomic.AtomicLong;

import com.amazonaws.services.rds.AmazonRDS;
import com.amazonaws.services.rds.AmazonRDSClient;


@Path("/rds-events")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EventApiResource {
    private final String masterPassword;
    private final String readOnlyPassword;
    private final String dbSubnet;
    private final String securityGroup;
    private final String databaseIdentifier;
    private final AtomicLong counter;

    public EventApiResource(String masterPassword, String readOnlyPassword, String dbSubnet, String securityGroup,
                            String databaseIdentifier) {
        this.masterPassword = masterPassword;
        this.readOnlyPassword = readOnlyPassword;
        this.dbSubnet = dbSubnet;
        this.securityGroup = securityGroup;
        this.databaseIdentifier = databaseIdentifier;
        this.counter = new AtomicLong();
    }

    @POST
    @Timed
    public Response processAmazonEvent(@HeaderParam("x-amz-sns-message-type") String messageType,
                                       @HeaderParam("x-amz-sns-topic-arn") String topicArn,
                                       @HeaderParam("x-amz-sns-subscription-arn") String subscriptionArn,
                                       SnsNotification notification) {
        switch (messageType) {
            case "Notification":
                handleEvent(topicArn, subscriptionArn, notification);
                break;
            case "SubscriptionConfirmation":
                break;
            case "UnsubscribeConfirmation":
                break;
        }

        return Response.status(Response.Status.OK).entity("OK").build();
    }

    private boolean handleEvent(String topicArn, String subscriptionArn, SnsNotification notification) {
        if (notification != null)
            System.out.println(notification);
        else
            System.out.println("Null notification!");
        return false;
    }

}
