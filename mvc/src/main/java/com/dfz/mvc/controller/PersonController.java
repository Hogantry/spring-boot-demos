package com.dfz.mvc.controller;

import com.dfz.mvc.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * person controller
 *
 * @author 花葱
 * @date 2021/12/29 09:34
 */
@RestController
public class PersonController {

    @GetMapping("getPerson")
    public Person getPerson() {
        Person person = new Person();
        person.setName("DFZ");
        person.setAge(18);
        person.setAddress("shanghai");
        person.setBirthday(LocalDate.now());
        return person;
    }

}
