package com.dfz.service.impl;

import com.dfz.dao.PersonDao;
import com.dfz.entity.Person;
import com.dfz.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author DFZ
 * @Date 2021-07-19 17:52
 * @Description
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int update(Person person) {
        personDao.updateByPrimaryKey(person);
        try {
            if (person.getId() == 1) {
                throw new IllegalArgumentException("abc");
            }
        } catch (RuntimeException e) {
            throw e;
        }
//        if (person.getId() == 1) {
//            throw new IllegalArgumentException("abc");
//        }

        return 1;
    }
}
