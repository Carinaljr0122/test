package com.example.demo.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Entity.Fruits;
import com.example.demo.repository.FruitsRepository;

import javax.annotation.Resource;

@Controller
@RequestMapping("/hibernate")
@EnableAutoConfiguration//此注释自动载入应用程序所需的所有Bean
public class HibernateController implements InitializingBean, ApplicationRunner {

    @Autowired
    private FruitsRepository fruitsRepository;

    @Resource
    private ApplicationContext applicationContext;

    @RequestMapping("getFruitsById")
    @ResponseBody
    public Fruits getFruitsById(Long id) {
        Fruits u = fruitsRepository.findOne(id);
        System.out.println("userRepository: " + fruitsRepository);
        System.out.println("id: " + id);
        return u;
    }

    /*@RequestMapping("saveFruits")
     * RequestMapping是一个用来处理请求地址映射的注解，可用于类或方法上。用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径。
     * */

    /*@ResponseBody
     *  i) 该注解用于读取Request请求的body部分数据，使用系统默认配置的HttpMessageConverter进行解析，然后把相应的数据绑定到要返回的对象上；

      ii) 再把HttpMessageConverter返回的对象数据绑定到 controller中方法的参数上。
     * */
    @RequestMapping("saveFruits")
    @ResponseBody
    public void saveFruits() {//注意 @RequestMapping("saveFruits")里的value值要与方法名称一致，否则找不到
        Fruits fruitsEntity = new Fruits();
        fruitsEntity.setName("苹果");
        fruitsEntity.setPrice(10.9f);

        fruitsRepository.save(fruitsEntity);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
