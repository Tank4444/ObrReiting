package ru.chuikov.ObrReiting.services;


import ru.chuikov.ObrReiting.entity.Right;

import java.util.List;

public interface RightService {
    Right addRight(Right right);
    void delete(long id);
    Right getByName(String name);
    Right getById(long id);
    Right editRight(Right right);
    List<Right> getAll();
}
