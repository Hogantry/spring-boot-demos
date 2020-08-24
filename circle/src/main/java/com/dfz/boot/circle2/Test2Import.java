package com.dfz.boot.circle2;

import com.dfz.boot.CircleApplication;
import org.springframework.context.annotation.Import;

/**
 * @ClassName Test2Import
 * @Description ConfigurationClassPostProcessor 在processConfigBeanDefinitions方法中解析时，是按照
 * MemberClasses(recursively) ---> PropertySources/PropertySource ---> ComponentScans/ComponentScan(recursively) --->
 * @Import(recursively) ---> @ImportResource(recursively) ---> @Bean ---> superclass，其中在@Import阶段如果解析出的类实现了DeferredImportSelector接口，则会保存
 * 到配置类的importBeanDefinitionRegistrars属性中，在最后才会去处理他的逻辑，@SpringBootApplication注解默认导入EnableAutoConfigurationImportSelector，
 * 这个类刚好实现了DeferredImportSelector接口，因此会在最后才被执行，因此@EnableAutoConfiguration自动配置导入的类的时机是最晚的，此时用户自定义的配置类已经被导入了。
 *
 * 顺序解析的，解析完一个bean的时候，会将beanDefinition加入到beanDefinitionMap中，将beanName加入到beanDefinitionNames，而该beanDefinitionNames
 * 属性是ArrayList类型，在AbstractApplicationContext#finishBeanFactoryInitialization()方法调用实例化beanFactory中的单例bean时，是根据beanDefinitionNames
 * 中的顺序，去beanDefinitionMap取beanDefinition来完成实例化。因此在不考虑依赖的情况下，bean的实例化顺序与其被解析并加入beanFactory的顺序一致。
 *
 * 该例中，会先解析Configuration2类，加入到beanDefinitionMap以及beanDefinitionNames属性中，然后解析内部的Bean2，Bean2依赖Bean1，Bean1又依赖Configuration1，
 * 此时的Configuration1还未被解析，从而beanDefinitionMap中尚未存在Configuration1的beanDefinition，因此Bean2会因为不满足Condition条件而解析加载失败。之后会继续解析Configuration1和内部的
 * Bean1，并加入到IOC容器中（容器中没有Bean2，其他的都有）。因此对于各个Bean的解析依赖顺序必须了然于胸，否则很容易出现，定义的Bean在IOC容器中找不到的bug。
 *
 * 这里如果将Configuration2与Configuration1的Import顺序颠倒下即可解决问题
 *
 * @see CircleApplication 中的@Bean注释
 *
 * @Author dfz
 * @Date 2019-11-08 16:23
 * @Version 1.0
 **/
@Import({Configuration1.class, Configuration2.class})
public class Test2Import {
}
