package top.kangyong.springboot.property.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.kangyong.springboot.property.domain.Animal;
import top.kangyong.springboot.property.domain.Cat;
import top.kangyong.springboot.property.domain.Dog;

import static org.junit.jupiter.api.Assertions.*;

/**
 * test
 *
 * @author Kang Yong
 * @date 2023/3/16
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BeanCopyServiceTest {


    @Autowired
    private BeanCopyService beanCopyService;


    @Test
    public void structCat() {
        Animal animal = new Animal();
        animal.setTypeName("猫咪");
        animal.setColor("blue");

        Dog dog = new Dog();
        dog.setName("鲍勃");
        dog.setAge(3);

        Cat cat = beanCopyService.structCat(animal, dog);
        System.out.println("cat = " + cat);

    }
}
