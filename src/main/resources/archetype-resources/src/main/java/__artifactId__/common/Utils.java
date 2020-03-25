package ${package}.${artifactId}.common;

import ${package}.${artifactId}.common.constants.Messages;
import ${package}.${artifactId}.common.constants.Parameters;
import ${package}.${artifactId}.common.dtos.ErrorDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Utilities class
 */
@Slf4j
public final class Utils {

    private Utils() {

        throw new IllegalStateException(Messages.UTILITY_CLASS);
    }

    /**
     * Returns if a string is member of an Enum class
     * @param term the string
     * @param c the Enum class
     * @return the result of the evaluation
     */
    public static boolean isIn(String term, Class c){
        try{
            if(null == term){
                log.info("term is null");
                return false;
            }
            Enum.valueOf(c, term.toUpperCase(Locale.ENGLISH));
            return true;
        }catch(IllegalArgumentException ex){
            log.info("No '{}' in {} options", term, c.getName());
            log.info(String.valueOf(ex));
            return false;
        }
    }

    /**
     * Http utils
     */
    public static final class Http{

        private Http() {
            throw new IllegalStateException("Utility class");
        }

        /**
         * Unauthorized response
         * @return unauthorized response
         */
        public static ResponseEntity<Object> unauthorized(){
            UUID uuid = UUID.randomUUID();
            String uuidStr = uuid.toString();
            log.error("{} | {}", uuidStr, Messages.TOKEN_ERROR);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorDetail(Messages.TOKEN_ERROR, uuid));
        }

        /**
         * Bad Request
         * @param messageDetail the error message
         * @return bad request response
         */
        public static ResponseEntity<Object> badRequest(String messageDetail){
            UUID uuid = UUID.randomUUID();
            log.error(uuid.toString().concat(" | ").concat(messageDetail));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorDetail(Messages.INVALID_INPUT_DATA.concat(" | ").concat(messageDetail), uuid));
        }

        /**
         * Internal Error
         * @param messageDetail the error message
         * @return internal error response
         */
        public static ResponseEntity<Object> internalError(String messageDetail){
            UUID uuid = UUID.randomUUID();
            log.error(uuid.toString().concat(" | ").concat(messageDetail));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorDetail(Messages.INTERNAL_SERVICE_ERROR.concat(" | ").concat(messageDetail), uuid));
        }

    }
}
