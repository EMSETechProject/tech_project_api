package com.robin.camarasa.nutritvecoach.web.Controller;

import com.robin.camarasa.nutritvecoach.dao.ObjectifDao;
import com.robin.camarasa.nutritvecoach.dao.PhysicalDataDao;
import com.robin.camarasa.nutritvecoach.dao.UserDao;
import com.robin.camarasa.nutritvecoach.dao.WeightDao;
import com.robin.camarasa.nutritvecoach.model.Objectif;
import com.robin.camarasa.nutritvecoach.model.PhysicalData;
import com.robin.camarasa.nutritvecoach.model.User;
import com.robin.camarasa.nutritvecoach.web.dto.ObjectifDto;
import com.robin.camarasa.nutritvecoach.web.dto.UserConnectionDto;
import com.robin.camarasa.nutritvecoach.web.dto.UserDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/objectifs")
@Transactional
public class ObjectifController {

    private ObjectifDao objectifDao;
    private UserDao userDao;

    public ObjectifController(ObjectifDao objectifDao, UserDao userDao) {
        this.objectifDao = objectifDao;
        this.userDao = userDao;
    }

    @GetMapping(value = "/all")
    public List<ObjectifDto> getall() {
        return objectifDao.findAll().stream().map(ObjectifDto::new).collect(Collectors.toList());
    }

    @GetMapping(value = "/findbyid/{id_user}")
    public ObjectifDto getobjectifsbyid(@PathVariable Long id_user) {
        List<Objectif> objectifs = objectifDao.findAll();
        List<Objectif> objectifs1 = new ArrayList<>();
        for (Objectif objectif : objectifs) {
            if (objectif.getUser().getId().equals(id_user)) {
                return new ObjectifDto(objectif);
            }
        }
        return new ObjectifDto(new Objectif(
                                        -1L,
                                        new User(
                                                -1L,
                                                "err",
                                                "err",
                                                new PhysicalData(
                                                                -1L,
                                                                -1,
                                                                -1F,
                                                                -1F)),
                                        -1F));
    }

    @PostMapping(value = "/add/{id_user}/{value}")
    public ObjectifDto add(@PathVariable Long id_user, @PathVariable Float value) {
        User user = userDao.getOne(id_user);
        Objectif objectif = new Objectif(user,value);
        objectifDao.save(objectif);
        return new ObjectifDto(objectif);
    }

    @PostMapping(value = "/modify/{id}/{value}")
    public ObjectifDto change(@PathVariable Long id, @PathVariable Float value) {
        Objectif objectif = objectifDao.getOne(id);
        objectif.setValue(value);
        objectifDao.save(objectif);
        return (new ObjectifDto(objectif));
    }

}