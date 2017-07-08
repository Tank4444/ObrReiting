package ru.chuikov.ObrReiting.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.chuikov.ObrReiting.entity.Institute;
import ru.chuikov.ObrReiting.repository.InstituteRepository;
import ru.chuikov.ObrReiting.services.InstituteService;

import java.util.List;

@Service("InstituteService")
public class InstituteServiceImpl implements InstituteService {
    @Autowired
    private InstituteRepository instituteRepository;

    public Institute addInstitute(Institute institute) {
        return instituteRepository.saveAndFlush(institute);
    }

    public void delete(long id) {
        instituteRepository.delete(id);
    }

    public List<Institute> getByName(String name) {
        return instituteRepository.findByName(name);
    }

    public List<Institute> getByNameAndCity(String name, String city) {
        return instituteRepository.findByNameAndCity(name,city);
    }

    public Institute getById(long id) {
        return instituteRepository.findById(id);
    }

    public List<Institute> getByAddress(String address) {
        return instituteRepository.findByAddress(address);
    }

    public Institute editInstitute(Institute institute) {
        return instituteRepository.saveAndFlush(institute);
    }

    public List<Institute> getAll() {
        return instituteRepository.findAll();
    }

    public List<Institute> getByCity(String city) {
        return instituteRepository.findByCity(city);
    }


}
