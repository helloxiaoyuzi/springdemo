package com.myspring.framework.context.support;

import com.myspring.framework.beans.BeanDefinition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
//用来对配置文件定位、读取、解析
public class BeanDefinitionReader {

    private Properties config=new Properties();


    private List<String> registyBeanClasses=new ArrayList <String>();

    public BeanDefinitionReader(String ... configeLocations) {
        InputStream is=this.getClass().getResourceAsStream(configeLocations[0].replace("classpath",""));
        try {
            config.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void doScanner(String packageName){
        URL url=this.getClass().getClassLoader().getResource("/"+packageName);
        File classDir=new File(url.getFile());
        for (File file:classDir.listFiles()){
            if(file.isDirectory()){
                doScanner(packageName+"."+file.getName());
            }else {
                registyBeanClasses.add(packageName+"."+file.getName().replace(".class",""));
            }
        }
    }

    public BeanDefinition registerBean(String className){
        return null;
    }

    public Properties getConfig() {
        return config;
    }
}
