package ru.chuikov.ObrReiting.services;


import ru.chuikov.ObrReiting.entity.Institute;
import ru.chuikov.ObrReiting.entity.InstitutesReview;

import java.util.List;

public interface InstituteService {
    Institute addInstitute(Institute institute);
    void delete(long id);
    Institute getById(long id);
    Institute editInstitute(Institute institute);
    List<Institute> getAll();
    List<Institute> getByCity(String city);
    List<Institute> getByAddress(String address);
    List<Institute> getByName(String na);
    List<Institute> getByNameAndCity(String name,String city);


}
