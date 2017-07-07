package ru.chuikov.ObrReiting.services;


import ru.chuikov.ObrReiting.entity.Chair;

import java.util.List;

public interface ChairService {
    Chair addChair(Chair chair);
    void delete(long id);
    Chair getByName(String name);
    Chair getById(long id);
    Chair editChair(Chair  chair);
    List<Chair> getAll();
}
