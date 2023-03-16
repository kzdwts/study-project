package top.kangyong.springboot.property.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import top.kangyong.springboot.property.domain.Animal;
import top.kangyong.springboot.property.domain.Cat;
import top.kangyong.springboot.property.domain.Dog;

/**
 * BeanUtils.copy
 *
 * @author Kang Yong
 * @date 2023/3/16
 * @since 1.0.0
 */
@Service
public class BeanCopyService {

    public Cat structCat(Animal animal, Dog dog) {
        Cat cat = new Cat();

        BeanUtils.copyProperties(animal, cat);
        BeanUtils.copyProperties(dog, cat);

        return cat;
    }
}
