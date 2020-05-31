package file_net.client;

import java.io.IOException;
import java.io.StringWriter;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.ModelAndView;
import spark.TemplateEngine;

/**
 * <pre>
 * file_net.client 
 * FreeMarkerTemplateEngine.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 5. 31.
 * @author : zkook
 * @version : v1.0
 */
public class FreeMarkerTemplateEngine extends TemplateEngine {

    private Configuration configuration;

    public FreeMarkerTemplateEngine() {
        this.configuration = createFreemarkerConfiguration();
    }

    @Override
    public String render(ModelAndView modelAndView) {
        try {
            StringWriter stringWriter = new StringWriter();

            Template template = configuration.getTemplate(modelAndView.getViewName());
            template.process(modelAndView.getModel(), stringWriter);

            return stringWriter.toString();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        } catch (TemplateException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private Configuration createFreemarkerConfiguration() {
        Configuration retVal = new Configuration();
        retVal.setClassForTemplateLoading(FreeMarkerTemplateEngine.class, "/freemarker/");	//	수정할 것.
        return retVal;
    }
}