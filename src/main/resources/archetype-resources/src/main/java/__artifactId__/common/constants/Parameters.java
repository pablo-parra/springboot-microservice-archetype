package ${package}.${artifactId}.common.constants;

import java.util.Arrays;
import java.util.List;

/**
 * Parameters class
 */
public final class Parameters {

    /**
     * API V1
     */
    public static final String API_V1 = "/api/v1";

    /**
     * ${appName} endpoint
     */
    public static final String ${appName}_ENDPOINT = "/";

    /**
     * Authorization
     */
    public static final String AUTHORIZATION = "authorization";

    /**
     * key user
     */
    public static final String USER_MANAGEMENT_ADMIN = "user_management_admin";

    /**
     * Constructor
     */
    private Parameters() {

        throw new IllegalStateException("Parameters class");
    }

}
