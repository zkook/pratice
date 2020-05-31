package file_net.client;

import static spark.Spark.get;
import static spark.Spark.modelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import corona.mask.FreeMarkerTemplateEngine;

/**
 * <pre>
 * file_net.client 
 * Expaa.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 5. 31.
 * @author : zkook
 * @version : v1.0
 */
public class Expaa {

    public static void main(String args[]) throws IOException {

        get("/hello", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello FreeMarker World");

            // The hello.ftl file is located in directory:
            // src/test/resources/spark/examples/templateview/freemarker
            return modelAndView(attributes, "hello.ftl");
        }, new FreeMarkerTemplateEngine());
    }
}