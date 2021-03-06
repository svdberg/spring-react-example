package com.winterbe.react;

import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.MessageFormat;
import java.util.Map;

@AllArgsConstructor
public class JsxView extends AbstractView {

    private React renderer;
    private String viewName;
    private MessageFormat indexTemplate;
//    private NodeContentRenderer renderer;

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {

        String content = renderer.renderToString("./" + viewName, model);

        IOUtils.write(indexTemplate.format(new String[]{content}), response.getOutputStream());
    }
}
