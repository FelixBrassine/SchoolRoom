package be.technobel.fbrassine.utils;

import be.technobel.fbrassine.models.entity.*;
import be.technobel.fbrassine.repository.DemandRepository;
import be.technobel.fbrassine.repository.MaterialRepository;
import be.technobel.fbrassine.repository.RoomRepository;
import lombok.extern.log4j.Log4j2;
import be.technobel.fbrassine.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@Log4j2
public class DataInit implements InitializingBean {
    private final UserRepository repository;
    private final RoomRepository roomRepository;
    private final MaterialRepository materialRepository;
    private final DemandRepository demandRepository;
    public DataInit(UserRepository repository, RoomRepository roomRepository, MaterialRepository materialRepository, DemandRepository demandRepository) {
        this.repository = repository;
        this.roomRepository = roomRepository;
        this.materialRepository = materialRepository;
        this.demandRepository = demandRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        log.info("-- INITIALIZING DB DATA --");


        User admin = new User();
        admin.setEmail("admin@admin");
        admin.setPassword("Aa.0");
        admin.setName("admin");
        admin.setAdress("rue du curé 5 1234 outsimplou");
        admin.setUserLogin("admin");
        admin.setRole(Role.ADMIN);
        admin.setFirstName("admin");
        admin.setPhoneNumber("0123456789");
        repository.save(admin);

        User teacher = new User();
        teacher.setEmail("teacher@teacher");
        teacher.setPassword("Aa.0");
        teacher.setName("teacher");
        teacher.setAdress("rue du curé 5 1234 outsimplou");
        teacher.setUserLogin("teacher");
        teacher.setRole(Role.TEACHER);
        teacher.setFirstName("teacher");
        teacher.setPhoneNumber("0123456789");
        repository.save(teacher);

        User student = new User();
        student.setEmail("student@student");
        student.setPassword("Aa.0");
        student.setName("student");
        student.setAdress("rue du curé 5 1234 outsimplou");
        student.setUserLogin("student");
        student.setRole(Role.STUDENT);
        student.setFirstName("student");
        student.setPhoneNumber("0123456789");
        repository.save(student);


        Material material1 = new Material();
        material1.setName("Projecteur");
        materialRepository.save(material1);

        Material material2 = new Material();
        material2.setName("Tableau numérique");
        materialRepository.save(material2);

        Set<Material> materialSet1 = new HashSet<>();
        materialSet1.add(material1);
        materialSet1.add(material2);

        Set<Material> materialSet2 = new HashSet<>();
        materialSet2.add(material1);

        Room room1 = new Room();
        room1.setTeacherRoom(true);
        room1.setNumberPlaces(20);
        room1.setName("Teacher room");
        room1.setMaterials(materialSet1);
        roomRepository.save(room1);

        Room room2 = new Room();
        room2.setTeacherRoom(false);
        room2.setNumberPlaces(50);
        room2.setName("Student room");
        room2.setMaterials(materialSet2);
        roomRepository.save(room2);

        Demand demand1 = new Demand();
        demand1.setTimeSlots(30-02-2023 14:00);
        demand1.setTerm(60);
        demand1.setRoom(room1);
        demand1.setUser(teacher);
        demandRepository.save(demand1);

        log.info("-- DATA INIT FINISHED --");
    }
}
