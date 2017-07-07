package ru.chuikov.ObrReiting.services;


import ru.chuikov.ObrReiting.entity.Institute;
import ru.chuikov.ObrReiting.entity.InstitutesReview;

import java.util.List;

public interface InstituteService {
    Institute addInstitute(Institute institute);
    void delete(long id);
    Institute getByName(String name);
    Institute getById(long id);
    List<Institute> getByAddress(String address);
    Institute editInstitute(Institute institute);
    List<Institute> getAll();

}
