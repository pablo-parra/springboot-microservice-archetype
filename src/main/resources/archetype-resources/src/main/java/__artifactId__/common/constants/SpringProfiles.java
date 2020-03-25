package ${package}.${artifactId}.common.constants;

/**
 * This class provides {@code String} constants which allow to distinguish several bean definition profiles. The
 * constants should be used in {@code @Profile} annotations to avoid multiple points of failure (e.g., through typos
 * within annotations).<br/>
 */
public final class SpringProfiles {

  /**
   * This constant applies to all tests.
   */
  public static final String TEST = "test";

  /**
   * This constant applies to the external services tests.
   */
  public static final String SERVICES_TEST = "servicestest";

  /**
   * This constant applies to local environment (development)
   */
  public static final String LOCAL = "local";

  /**
   * This constant applies to production remote environment.
   */
  public static final String REMOTE = "remote";

  private SpringProfiles() {
    throw new IllegalStateException("Constants class");
  }
}
