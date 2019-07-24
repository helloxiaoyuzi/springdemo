package com.myspring.framework.context;

import com.myspring.framework.context.support.BeanDefinitionReader;
import com.myspring.framework.core.BeanFactory;

public class MyApplicationContext implements BeanFactory {

    private String[] configeLocations;

    private BeanDefinitionReader reader;

    public MyApplicationContext(String ... configeLocations) {
        this.configeLocations=configeLocations;
        this.refresh();
    }

    @Override
    public Object getBean(String name) {
        return null;
    }

    public void refresh(){
        //定位
        this.reader=new BeanDefinitionReader(configeLocations);
        //加载

        //注册

        //依赖注入

        return;
    }
}
