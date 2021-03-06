package com.test;

import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.support.config.FastJsonConfig;
import com.alibaba.fastjson2.support.spring.http.converter.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        // 这里如果设置了FieldBased，@JSONField注解就生不效了
         config.setWriterFeatures(JSONWriter.Feature.FieldBased, JSONWriter.Feature.NullAsDefaultValue);
        // 如果去除JSONWriter.Feature.FieldBased，@JSONField注解就生效了
        // config.setWriterFeatures(JSONWriter.Feature.NullAsDefaultValue);
        config.setDateFormat("yyyy-MM-dd HH:mm:ss");
        converter.setFastJsonConfig(config);
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        converter.setSupportedMediaTypes(mediaTypes);
        converters.add(0, converter);
        super.addDefaultHttpMessageConverters(converters);

    }

}
