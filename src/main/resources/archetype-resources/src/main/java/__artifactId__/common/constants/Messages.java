package ${package}.${artifactId}.common.constants;

/**
 * Constants class to manage the service messages
 */
public final class Messages {

  /**
   * Error message for incorrect parameter
   */
  public static final String INVALID_INPUT_DATA = "Invalid input data.";

  /**
   * Error message for internal service error
   */
  public static final String INTERNAL_SERVICE_ERROR = "Internal service error.";

  /**
   * Message for token error
   */
  public static final String TOKEN_ERROR = "Unspecified error with supplied token.";

  /**
   * Error message missing required field
   */
  public static final String MISSING_REQUIRED_FIELD = "Missing required field or some field is invalid.";

  /**
   * Utility Class
   */
  public static final String UTILITY_CLASS = "Utility class";

  /**
   * The constructor.
   */
  private Messages() {
    throw new IllegalStateException(UTILITY_CLASS);
  }

  /**
   * Request messages
   */
  public static final class Request{

    /**
     * New Request
     */
    public static final String NEW = "Requested {} with PARAMS: {} | AUTH: {}";

    /**
     * Request Authorized and Valid
     */
    public static final String AUTHORIZED_AND_VALID = "Request authorized and valid, calling service...";

    /**
     * Request NOT valid
     */
    public static final String NOT_VALID = "Request NOT valid.";

    /**
     * Request NOT authorized
     */
    public static final String NOT_AUTHORIZED = "Request NOT authorized.";

    private Request() {
      throw new IllegalStateException(UTILITY_CLASS);
    }
  }

}
