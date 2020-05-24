package file_net.client;

import static spark.Spark.get;
import static spark.Spark.modelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import corona.mask.FreeMarkerTemplateEngine;

public class expaa {

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