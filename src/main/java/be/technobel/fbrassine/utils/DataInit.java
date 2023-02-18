package be.technobel.fbrassine.utils;

import be.technobel.fbrassine.models.entity.Role;
import be.technobel.fbrassine.models.entity.User;
import lombok.extern.log4j.Log4j2;
import be.technobel.fbrassine.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class DataInit implements InitializingBean {
    private final UserRepository repository;
    public DataInit(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        log.info("-- INITIALIZING DB DATA --");


        User admin = new User();
        admin.setEmail("admin@admin");
        admin.setPassword("Aa.0");
        admin.setName("admin");
        admin.setAdress("rue du curé 5 1234 outsimplou");
        admin.setLogin("login");
        admin.setRole(Role.ADMIN);
        admin.setFirstName("admin");
        admin.setPhoneNumber("0123456789");
        repository.save(admin);

        User teacher = new User();
        teacher.setEmail("teacher@teacher");
        teacher.setPassword("Aa.0");
        teacher.setName("teacher");
        teacher.setAdress("rue du curé 5 1234 outsimplou");
        teacher.setLogin("login");
        teacher.setRole(Role.TEACHER);
        teacher.setFirstName("teacher");
        teacher.setPhoneNumber("0123456789");
        repository.save(teacher);

        User student = new User();
        student.setEmail("student@student");
        student.setPassword("Aa.0");
        student.setName("student");
        student.setAdress("rue du curé 5 1234 outsimplou");
        student.setLogin("login");
        student.setRole(Role.STUDENT);
        student.setFirstName("student");
        student.setPhoneNumber("0123456789");
        repository.save(student);


        log.info("-- DATA INIT FINISHED --");
    }
}
