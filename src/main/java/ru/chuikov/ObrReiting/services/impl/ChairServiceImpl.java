package ru.chuikov.ObrReiting.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.chuikov.ObrReiting.entity.Chair;
import ru.chuikov.ObrReiting.repository.ChairRepository;
import ru.chuikov.ObrReiting.services.ChairService;

import java.util.List;

@Service("ChairService")
public class ChairServiceImpl implements ChairService {
    @Autowired
    private ChairRepository chairRepository;

    public Chair addChair(Chair chair) {
        return chairRepository.saveAndFlush(chair);
    }

    public void delete(long id) {
        chairRepository.delete(id);
    }

    public Chair getByName(String name) {
        return chairRepository.findByName(name);
    }

    public Chair getById(long id) {
        return chairRepository.findById(id);
    }

    public Chair editChair(Chair chair) {
        return chairRepository.saveAndFlush(chair);
    }

    public List<Chair> getAll() {
        return chairRepository.findAll();
    }
}
