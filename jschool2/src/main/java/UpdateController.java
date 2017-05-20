import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.Instant;
import java.util.Date;

/**
 * Created by Роднуля on 20.05.2017.
 */
@Singleton
@Path(value = "/updated")
public class UpdateController {
    Instant updated = Instant.now();

    public void update() {
        updated = Instant.now();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public long getUpdated() {
        return updated.toEpochMilli();
    }
}
