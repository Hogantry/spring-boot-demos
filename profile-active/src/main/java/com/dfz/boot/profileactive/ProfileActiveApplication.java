package com.dfz.boot.profileactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.env.RandomValuePropertySource;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

/**
 * @version V1.0
 * @author: DFZ
 * @description:  1. SpringApplication在运行时，会先初始化Environment(不考虑自己实例化的情况下)，Environment在实例化的过程中，会以此添加
 *                ServletConfig、ServletContext、JNDI、SystemProperty、SystemEvn作为属性源，其中前两个只是占位，内部并无数据，会在web
 *                容器完成初始化后重写这两个属性。
 *                2. 后SpringApplication会将自己的defaultProperties属性添加到Environment中，并将Main方法的启动参数作为第一个属性源插入到
 *                Environment中。
 *
 *                在根据spring.profiles.active从Environment中获取值时，会先将SpringApplication的additionalProfiles作为默认值，之后
 *                再从Environment中获取，且是按内部的属性源顺序依次获取，获取到就直接返回，因此值存在位置有优先级顺序。(注意此时ServletConfig、ServletContext
 *                数据源中是没有数据的），得到的Set类型的值就存在Environment的activeProfiles属性中。
 *
 *                可参考SpringApplication 339行 prepareEnvironment 方法，内部configureEnvironment方法是是上述第二步的实现方法。
 *
 *                之后会发布ApplicationEnvironmentPreparedEvent事件，该事件会被{@link ConfigFileApplicationListener}处理，其又会加载
 *                EnvironmentPostProcessor对Environment做二次处理，并且自己也是EnvironmentPostProcessor的实现，因此这里重点关注该类自身。
 *                在postProcessEnvironment方法中，会先向Environment中添加{@link RandomValuePropertySource}属性源，位置在SystemEvn之后。
 *
 *                之后就会调用内部类Loader的load方法，根据profile来加载配置文件。此时这里又引入新的属性key，从Environment中后去
 *                spring.profiles.include的值，也添加至待解析的profile列表中。当且仅当，Environment没有配置spring.profiles.active、
 *                spring.profiles.include以及SpringApplication没有配置defaultProperties属性时，才会从Environment中获取spring.profiles.default
 *                的值，且其值默认就是default。
 *
 *                此时，内部类Loader的属性profiles的值，就是null + spring.profiles.active + spring.profiles.include + defaultProperties
 *                或者null + spring.profiles.default(主要此时并没有去重，可能存在重复值)
 *
 *                之后就是根据profiles的值去加载文件了，具体原理可去参考{@link ConfigFileApplicationListener}中的代码。
 *
 *                将所有加载的文件作为合并为一个属性源(待源码验证)，添加到Environment中，并将其放在上述第二步的defaultProperties属性源之前
 *
 *                至此，Environment中属性源的顺序为
 *                main方法的启动参数(CommandLine) -> ServletConfig -> ServletContext -> JNDI -> SystemProperty -> SystemEvn
 *                -> SpringApplication的defaultProperties属性
 *
 *                后续考虑到SpringCloud的配置中心，该顺序可能会有变化
 *
 *
 * @date: 2020/9/4 11:14
 * @Copyright: 2020 www.ztzqzg.com Ltd. All rights reserved.
 * 注意：本内容仅限于中泰证券（上海）资产管理有限公司内部传阅，禁止外泄以及用于其他的商业项目
 */
@SpringBootApplication
public class ProfileActiveApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ProfileActiveApplication.class);
        springApplication.setAdditionalProfiles("e", "f");
        ConfigurableApplicationContext context = springApplication.run(args);
        Arrays.stream(context.getEnvironment().getActiveProfiles()).forEach(System.out::println);
    }

}
