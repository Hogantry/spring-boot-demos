package com.dfz.service.impl;

import com.dfz.dao.StudentDao;
import com.dfz.entity.Person;
import com.dfz.entity.Student;
import com.dfz.service.PersonService;
import com.dfz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author DFZ
 * @Date 2021-07-19 16:25
 * @Description
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private PersonService personService;

    @Override
    @Transactional
    public int update(Student student) {
        studentDao.updateByPrimaryKey(student);
        Person person = new Person();
        person.setId(1);
        person.setName("DDFFZZ");
        person.setAge(18);
//        if (student.getId() == 1) {
//            throw new IllegalArgumentException("student");
//        }
        try {
            personService.update(person);
        } catch (Exception e) {

        }
        return 1;
    }
}
