package ${package}.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.extern.slf4j.Slf4j;

/**
 * Test Utilities class
 *
 */
@Slf4j
public class TestUtils {

    public TestUtils() {

        throw new IllegalStateException("Utility class");
    }

    /**
     * Creates a header of the test in the Logs
     *
     * @param name the name of the test
     */
    public static void testHeader(String name) {

        log.info("------------------------------------------------------------------------------");
        log.info("--- TEST: {}", name);
        log.info("------------------------------------------------------------------------------");
    }

    /**
     * Creates a success message for the test
     */
    public static void testSuccess() {

        log.info("------------------------------------------------------------------------------");
        log.info("------------------------------------------------------------------ TEST PASSED");
        log.info("------------------------------------------------------------------------------\n\n\n");
    }

    /**
     * Resources for Test classes
     */
    public static class Resources {

        public static final String THREE_PARTS_AUTH_TOKEN = "Bearer eyJraWQiOiItODA3MzUwMTU1IiwieDV0IjoiaFJpMGdsQnJtX09QTVBsYmFwaDhYZjJjRDQwIiwiYWxnIjoiUlMyNTYifQ.eyJqdGkiOiJiNGJlYzEzNy1jMzRmLTQyNmYtOGMyOC00OGNiNGI2ZjUxYWEiLCJkZWxlZ2F0aW9uSWQiOiJkZWZjMDIwZC1iNGY2LTQzMzQtYWViMy1iOWU3YmMzMTY5MmIiLCJleHAiOjE1Njc2ODc1MzAsIm5iZiI6MTU2NzY4NzIzMCwic2NvcGUiOiIiLCJpc3MiOiJodHRwczovL2FwaXN0YWdlLmVudGVyY2FyZC5jb20vfiIsInN1YiI6InVzZXJfbWFuYWdlbWVudF9hZG1pbiIsImF1ZCI6Ijk4YTU0ODFiLTQyMjctNGI0ZS05ZWVhLTE3ZDkzZjdlMTBhNSIsImlhdCI6MTU2NzY4NzIzMCwicHVycG9zZSI6ImFjY2Vzc190b2tlbiJ9.OuoEoyJ6Dlj8A8XyGudYhetgfsn5QpU5Io1veSrdwGlgJf98ZGZAQVy_R1O0IF8EyDyFmok3iUXU-oxgV86ynT9atKyKGV-jMgViHb6Ot3sJ4azH25eoFYPc4IiGTJMdgj-QWL3lsTYLhDutsJsJi7Syb3Rwj9g1-ss2iUIBv6YqWk8TRWkASPVJ803QmUC6K83-toyw9XbbcQ71FmiNkHyVLINJTteIwRICh1WnGVK957ep7UKBKMccVuFADXV1a4J7n_33OTlnvZ9ADCkksS98dNG-Z2X5IZfUU1EiJe3gAJBrSNFJllDyuNGA9TxJHYYG_a47SANr2eHEEiYdrw ";

        public static final String FOUR_PARTS_AUTH_TOKEN = "Bearer eyJraWQiOiItODA3MzUwMTU1IiwieDV0IjoiaFJpMGdsQnJtX09QTVBsYmFwaDhYZjJjRDQwIiwiYWxnIjoiUlMyNTYifQ.eyJqdGkiOiI4YzFmOTc0Ny0zZjc3LTRjNmItYWEyYi0wNGFmNjMxOTFjNzEiLCJkZWxlZ2F0aW9uSWQiOiIwYThiOTJlNi02NjMwLTQ1ZTUtYjVkMS04NGFlM2VhNTJmYjEiLCJleHAiOjE1NjgwMjk4ODcsIm5iZiI6MTU2ODAyOTU4Nywic2NvcGUiOiIiLCJpc3MiOiJodHRwczovL2FwaXN0YWdlLmVudGVyY2FyZC5jb20vfiIsInN1YiI6IkNOXHUwMDNkU01JVEhcXCwgTUlSSUFNLE9cdTAwM2RCYW5rSUQgLSBUZXN0QmFuazEsQ1x1MDAzZE5PLFNFUklBTE5VTUJFUlx1MDAzZDk1NzgtNjAwMC00LTYyNDMyIiwiYXVkIjoiOThhNTQ4MWItNDIyNy00YjRlLTllZWEtMTdkOTNmN2UxMGE1IiwiaWF0IjoxNTY4MDI5NTg3LCJwdXJwb3NlIjoiYWNjZXNzX3Rva2VuIiwicHNkMl9zc24iOiI5OTk0NzYxNzQ5MTciLCAicHNkMl9yb2xlIjoiMGRhc2RmLjBaMCYwUFNQX0FJMGRmYXNkLikvJmdvaS9HRyJ9.eyJqdGkiOiI4YzFmOTc0Ny0zZjc3LTRjNmItYWEyYi0wNGFmNjMxOTFjNzEiLCJkZWxlZ2F0aW9uSWQiOiIwYThiOTJlNi02NjMwLTQ1ZTUtYjVkMS04NGFlM2VhNTJmYjEiLCJleHAiOjE1NjgwMjk4ODcsIm5iZiI6MTU2ODAyOTU4Nywic2NvcGUiOiIiLCJpc3MiOiJodHRwczovL2FwaXN0YWdlLmVudGVyY2FyZC5jb20vfiIsInN1YiI6IkNOXHUwMDNkU01JVEhcXCwgTUlSSUFNLE9cdTAwM2RCYW5rSUQgLSBUZXN0QmFuazEsQ1x1MDAzZE5PLFNFUklBTE5VTUJFUlx1MDAzZDk1NzgtNjAwMC00LTYyNDMyIiwiYXVkIjoiOThhNTQ4MWItNDIyNy00YjRlLTllZWEtMTdkOTNmN2UxMGE1IiwiaWF0IjoxNTY4MDI5NTg3LCJwdXJwb3NlIjoiYWNjZXNzX3Rva2VuIiwicHNkMl9zc24iOiI0NzYxNzQ5MTciLCAicHNkMl9yb2xlIjoiMGRhc2RmLjBaMCYwUFNQX0FJMGRmYXNkLikvJmdvaS9HRyJ9.OuoEoyJ6Dlj8A8XyGudYhetgfsn5QpU5Io1veSrdwGlgJf98ZGZAQVy_R1O0IF8EyDyFmok3iUXU-oxgV86ynT9atKyKGV-jMgViHb6Ot3sJ4azH25eoFYPc4IiGTJMdgj-QWL3lsTYLhDutsJsJi7Syb3Rwj9g1-ss2iUIBv6YqWk8TRWkASPVJ803QmUC6K83-toyw9XbbcQ71FmiNkHyVLINJTteIwRICh1WnGVK957ep7UKBKMccVuFADXV1a4J7n_33OTlnvZ9ADCkksS98dNG-Z2X5IZfUU1EiJe3gAJBrSNFJllDyuNGA9TxJHYYG_a47SANr2eHEEiYdrw";

        public static final String FIVE_PARTS_AUTH_TOKEN = "Bearer eyJraWQiOiItODA3MzUwMTU1IiwieDV0IjoiaFJpMGdsQnJtX09QTVBsYmFwaDhYZjJjRDQwIiwiYWxnIjoiUlMyNTYifQ.eyJqdGkiOiI4YzFmOTc0Ny0zZjc3LTRjNmItYWEyYi0wNGFmNjMxOTFjNzEiLCJkZWxlZ2F0aW9uSWQiOiIwYThiOTJlNi02NjMwLTQ1ZTUtYjVkMS04NGFlM2VhNTJmYjEiLCJleHAiOjE1NjgwMjk4ODcsIm5iZiI6MTU2ODAyOTU4Nywic2NvcGUiOiIiLCJpc3MiOiJodHRwczovL2FwaXN0YWdlLmVudGVyY2FyZC5jb20vfiIsInN1YiI6IkNOXHUwMDNkU01JVEhcXCwgTUlSSUFNLE9cdTAwM2RCYW5rSUQgLSBUZXN0QmFuazEsQ1x1MDAzZE5PLFNFUklBTE5VTUJFUlx1MDAzZDk1NzgtNjAwMC00LTYyNDMyIiwiYXVkIjoiOThhNTQ4MWItNDIyNy00YjRlLTllZWEtMTdkOTNmN2UxMGE1IiwiaWF0IjoxNTY4MDI5NTg3LCJwdXJwb3NlIjoiYWNjZXNzX3Rva2VuIiwicHNkMl9zc24iOiI5OTk0NzYxNzQ5MTciLCAicHNkMl9yb2xlIjoiMGRhc2RmLjBaMCYwUFNQX0FJMGRmYXNkLikvJmdvaS9HRyJ9.eyJqdGkiOiI4YzFmOTc0Ny0zZjc3LTRjNmItYWEyYi0wNGFmNjMxOTFjNzEiLCJkZWxlZ2F0aW9uSWQiOiIwYThiOTJlNi02NjMwLTQ1ZTUtYjVkMS04NGFlM2VhNTJmYjEiLCJleHAiOjE1NjgwMjk4ODcsIm5iZiI6MTU2ODAyOTU4Nywic2NvcGUiOiIiLCJpc3MiOiJodHRwczovL2FwaXN0YWdlLmVudGVyY2FyZC5jb20vfiIsInN1YiI6IkNOXHUwMDNkU01JVEhcXCwgTUlSSUFNLE9cdTAwM2RCYW5rSUQgLSBUZXN0QmFuazEsQ1x1MDAzZE5PLFNFUklBTE5VTUJFUlx1MDAzZDk1NzgtNjAwMC00LTYyNDMyIiwiYXVkIjoiOThhNTQ4MWItNDIyNy00YjRlLTllZWEtMTdkOTNmN2UxMGE1IiwiaWF0IjoxNTY4MDI5NTg3LCJwdXJwb3NlIjoiYWNjZXNzX3Rva2VuIiwicHNkMl9zc24iOiI5OTk0NzYxNzQ5MTciLCAicHNkMl9yb2xlIjoiMGRhc2RmLjBaMCYwUFNQX0FJMGRmYXNkLikvJmdvaS9HRyJ9.eyJqdGkiOiI4YzFmOTc0Ny0zZjc3LTRjNmItYWEyYi0wNGFmNjMxOTFjNzEiLCJkZWxlZ2F0aW9uSWQiOiIwYThiOTJlNi02NjMwLTQ1ZTUtYjVkMS04NGFlM2VhNTJmYjEiLCJleHAiOjE1NjgwMjk4ODcsIm5iZiI6MTU2ODAyOTU4Nywic2NvcGUiOiIiLCJpc3MiOiJodHRwczovL2FwaXN0YWdlLmVudGVyY2FyZC5jb20vfiIsInN1YiI6IkNOXHUwMDNkU01JVEhcXCwgTUlSSUFNLE9cdTAwM2RCYW5rSUQgLSBUZXN0QmFuazEsQ1x1MDAzZE5PLFNFUklBTE5VTUJFUlx1MDAzZDk1NzgtNjAwMC00LTYyNDMyIiwiYXVkIjoiOThhNTQ4MWItNDIyNy00YjRlLTllZWEtMTdkOTNmN2UxMGE1IiwiaWF0IjoxNTY4MDI5NTg3LCJwdXJwb3NlIjoiYWNjZXNzX3Rva2VuIiwicHNkMl9zc24iOiI0NzYxNzQ5MTciLCAicHNkMl9yb2xlIjoiMGRhc2RmLjBaMCYwUFNQX0FJMGRmYXNkLikvJmdvaS9HRyJ9.OuoEoyJ6Dlj8A8XyGudYhetgfsn5QpU5Io1veSrdwGlgJf98ZGZAQVy_R1O0IF8EyDyFmok3iUXU-oxgV86ynT9atKyKGV-jMgViHb6Ot3sJ4azH25eoFYPc4IiGTJMdgj-QWL3lsTYLhDutsJsJi7Syb3Rwj9g1-ss2iUIBv6YqWk8TRWkASPVJ803QmUC6K83-toyw9XbbcQ71FmiNkHyVLINJTteIwRICh1WnGVK957ep7UKBKMccVuFADXV1a4J7n_33OTlnvZ9ADCkksS98dNG-Z2X5IZfUU1EiJe3gAJBrSNFJllDyuNGA9TxJHYYG_a47SANr2eHEEiYdrw";

        // Contains a twelve digits long Psd2Ssn with value '123456123456'
        public static final String TWELVE_DIGITS_SSN_AUTH_TOKEN = "Bearer eyJraWQiOiItODA3MzUwMTU1IiwieDV0IjoiaFJpMGdsQnJtX09QTVBsYmFwaDhYZjJjRDQwIiwiYWxnIjoiUlMyNTYifQ.eyJqdGkiOiI4YzFmOTc0Ny0zZjc3LTRjNmItYWEyYi0wNGFmNjMxOTFjNzEiLCJkZWxlZ2F0aW9uSWQiOiIwYThiOTJlNi02NjMwLTQ1ZTUtYjVkMS04NGFlM2VhNTJmYjEiLCJleHAiOjE1NjgwMjk4ODcsIm5iZiI6MTU2ODAyOTU4Nywic2NvcGUiOiIiLCJpc3MiOiJodHRwczovL2FwaXN0YWdlLmVudGVyY2FyZC5jb20vfiIsInN1YiI6IkNOXHUwMDNkU01JVEhcXCwgTUlSSUFNLE9cdTAwM2RCYW5rSUQgLSBUZXN0QmFuazEsQ1x1MDAzZE5PLFNFUklBTE5VTUJFUlx1MDAzZDk1NzgtNjAwMC00LTYyNDMyIiwiYXVkIjoiOThhNTQ4MWItNDIyNy00YjRlLTllZWEtMTdkOTNmN2UxMGE1IiwiaWF0IjoxNTY4MDI5NTg3LCJwdXJwb3NlIjoiYWNjZXNzX3Rva2VuIiwicHNkMl9zc24iOiIxMjM0NTYxMjM0NTYiLCAicHNkMl9yb2xlIjoiMGRhc2RmLjBaMCYwUFNQX0FJMGRmYXNkLikvJmdvaS9HRyJ9.OuoEoyJ6Dlj8A8XyGudYhetgfsn5QpU5Io1veSrdwGlgJf98ZGZAQVy_R1O0IF8EyDyFmok3iUXU-oxgV86ynT9atKyKGV-jMgViHb6Ot3sJ4azH25eoFYPc4IiGTJMdgj-QWL3lsTYLhDutsJsJi7Syb3Rwj9g1-ss2iUIBv6YqWk8TRWkASPVJ803QmUC6K83-toyw9XbbcQ71FmiNkHyVLINJTteIwRICh1WnGVK957ep7UKBKMccVuFADXV1a4J7n_33OTlnvZ9ADCkksS98dNG-Z2X5IZfUU1EiJe3gAJBrSNFJllDyuNGA9TxJHYYG_a47SANr2eHEEiYdrw ";

        public static final String TEST_SSN = "123456123456";

        // Expected Psd2Ssn value after discarding first 2 digits:
        public static final String SHORTENED_SSN = "3456123456";
        
        public static  final String AUTH_TOKEN = "Bearer eyJraWQiOiItODA3MzUwMTU1IiwieDV0IjoiaFJpMGdsQnJtX09QTVBsYmFwaDhYZjJjRDQwIiwiYWxnIjoiUlMyNTYifQ.eyJqdGkiOiJiNGJlYzEzNy1jMzRmLTQyNmYtOGMyOC00OGNiNGI2ZjUxYWEiLCJkZWxlZ2F0aW9uSWQiOiJkZWZjMDIwZC1iNGY2LTQzMzQtYWViMy1iOWU3YmMzMTY5MmIiLCJleHAiOjE1Njc2ODc1MzAsIm5iZiI6MTU2NzY4NzIzMCwic2NvcGUiOiIiLCJpc3MiOiJodHRwczovL2FwaXN0YWdlLmVudGVyY2FyZC5jb20vfiIsInN1YiI6InVzZXJfbWFuYWdlbWVudF9hZG1pbiIsImF1ZCI6Ijk4YTU0ODFiLTQyMjctNGI0ZS05ZWVhLTE3ZDkzZjdlMTBhNSIsImlhdCI6MTU2NzY4NzIzMCwicHVycG9zZSI6ImFjY2Vzc190b2tlbiJ9.OuoEoyJ6Dlj8A8XyGudYhetgfsn5QpU5Io1veSrdwGlgJf98ZGZAQVy_R1O0IF8EyDyFmok3iUXU-oxgV86ynT9atKyKGV-jMgViHb6Ot3sJ4azH25eoFYPc4IiGTJMdgj-QWL3lsTYLhDutsJsJi7Syb3Rwj9g1-ss2iUIBv6YqWk8TRWkASPVJ803QmUC6K83-toyw9XbbcQ71FmiNkHyVLINJTteIwRICh1WnGVK957ep7UKBKMccVuFADXV1a4J7n_33OTlnvZ9ADCkksS98dNG-Z2X5IZfUU1EiJe3gAJBrSNFJllDyuNGA9TxJHYYG_a47SANr2eHEEiYdrw ";

        public static final String AUTH_TOKEN_NO_VALID = "Bearer eyJraWQiOiItODA3MzUwMTU1IiwieDV0IjoiaFJpMGdsQnJtX09QTVBsYmFwaDhYZjJjRDQwIiwiYWxnIjoiUlMyNTYifQ.eyJqdGkiOiJiNGJlYzEzNy1jMzRmLTQyNmYtOGMyOC00OGNiNGI2ZjUxYWEiLCJkZWxlZ2F0aW9uSWQiOiJkZWZjMDIwZC1iNGY2LTQzMzQtYWViMy1iOWU3YmMzMTY5MmIiLCJleHAiOjE1Njc2ODc1MzAsIm5iZiI6MTU2NzY4NzIzMCwic2NvcGUiOiIiLCJpc3MiOiJodHRwczovL2FwaXN0YWdlLmVudGVyY2FyZC5jb20vfiIsInN1YiI6Im5vX3ZhbGlkX2NsaWVudF9zdWIiLCJhdWQiOiI5OGE1NDgxYi00MjI3LTRiNGUtOWVlYS0xN2Q5M2Y3ZTEwYTUiLCJpYXQiOjE1Njc2ODcyMzAsInB1cnBvc2UiOiJhY2Nlc3NfdG9rZW4ifQ==.OuoEoyJ6Dlj8A8XyGudYhetgfsn5QpU5Io1veSrdwGlgJf98ZGZAQVy_R1O0IF8EyDyFmok3iUXU-oxgV86ynT9atKyKGV-jMgViHb6Ot3sJ4azH25eoFYPc4IiGTJMdgj-QWL3lsTYLhDutsJsJi7Syb3Rwj9g1-ss2iUIBv6YqWk8TRWkASPVJ803QmUC6K83-toyw9XbbcQ71FmiNkHyVLINJTteIwRICh1WnGVK957ep7UKBKMccVuFADXV1a4J7n_33OTlnvZ9ADCkksS98dNG-Z2X5IZfUU1EiJe3gAJBrSNFJllDyuNGA9TxJHYYG_a47SANr2eHEEiYdrw ";

        public static final String INST_ID_1 = "1";

    }

    public static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ").create();

}