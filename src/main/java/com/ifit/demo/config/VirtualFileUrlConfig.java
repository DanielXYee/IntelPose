package com.ifit.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: WinstonDeng
 * @Description: 虚拟路径配置
 * @Date: Created in 8:45 2019/1/23
 * @Modified by:
 */
@Configuration
public class VirtualFileUrlConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //文件磁盘url 映射
        //配置server虚拟路径，handler为前台访问的目录，locations为files相对应的本地路径
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/video/**").addResourceLocations("/resources/video/");
        registry.addResourceHandler("/pose/**").addResourceLocations("/resources/pose/");
    }

}