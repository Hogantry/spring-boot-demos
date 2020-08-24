package com.dfz.boot.circle1;

import com.dfz.boot.CircleApplication;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @ClassName TestImport
 * @Description ConfigurationClassPostProcessor 在processConfigBeanDefinitions方法中解析时，是按照
 * MemberClasses(recursively) ---> PropertySources/PropertySource ---> ComponentScans/ComponentScan(recursively) --->
 * @Import(recursively) ---> @ImportResource(recursively) ---> @Bean ---> superclass，其中在@Import阶段如果解析出的类实现了DeferredImportSelector接口，则会保存
 * 到配置类的importBeanDefinitionRegistrars属性中，在最后才会去处理他的逻辑，@SpringBootApplication注解默认导入EnableAutoConfigurationImportSelector，
 * 这个类刚好实现了DeferredImportSelector接口，因此会在最后被被执行因此@EnableAutoConfiguration自动配置导入的类的时机是最晚的，此时用户自定义的配置类以及被导入了。
 *
 * 顺序解析的，解析完一个bean的时候，会将beanDefinition加入到beanDefinitionMap中，将beanName加入到beanDefinitionNames，而该beanDefinitionNames
 * 属性是ArrayList类型，在AbstractApplicationContext#finishBeanFactoryInitialization()方法调用实例化beanFactory中的单例bean时，是根据beanDefinitionNames
 * 中的顺序，去beanDefinitionMap取beanDefinition来完成实例化。因此在不考虑依赖的情况下，bean的实例化顺序与其被解析并加入beanFactory的顺序一致。
 *
 * 该例中，如果将ServiceA与ConfigurationA顺序颠倒，会导致循环依赖的问题
 *
 * @see CircleApplication 中的@Bean注释
 *
 * @Author dfz
 * @Date 2019-11-08 16:23
 * @Version 1.0
 **/
@Import({ServiceA.class, ConfigurationA.class, BeanB.class})
@Component
//@EnableAutoConfiguration
public class TestImport {
}
