package ru.chuikov.ObrReiting.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import ru.chuikov.ObrReiting.entity.Right;
import ru.chuikov.ObrReiting.repository.RightRepository;
import ru.chuikov.ObrReiting.services.RightService;

import java.util.List;
@Service("RightService")
public class RightServiceImpl implements RightService {

    @Autowired
    private RightRepository rightRepository;


    public Right addRight(Right right) {
        return rightRepository.saveAndFlush(right);
    }

    public void delete(long id) {
        rightRepository.delete(id);
    }

    public Right getByName(String name) {
        return rightRepository.findByName(name);
    }


    public Right getById(long id) {
        return rightRepository.findById(id);
    }

    public Right editRight(Right right) {
        return rightRepository.saveAndFlush(right);
    }

    public List<Right> getAll() {
        return rightRepository.findAll();
    }
}
