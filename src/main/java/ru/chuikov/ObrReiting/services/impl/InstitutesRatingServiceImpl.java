package ru.chuikov.ObrReiting.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.chuikov.ObrReiting.entity.Institute;
import ru.chuikov.ObrReiting.entity.InstitutesRating;
import ru.chuikov.ObrReiting.entity.User;
import ru.chuikov.ObrReiting.repository.InstitutesRatingRepository;
import ru.chuikov.ObrReiting.services.InstituteService;
import ru.chuikov.ObrReiting.services.InstitutesRatingService;

import java.util.List;

@Service("InstitutesRatingService")
public class InstitutesRatingServiceImpl implements InstitutesRatingService{

    @Autowired
    private InstitutesRatingRepository institutesRatingRepository;


    public InstitutesRating addInstitutesRating(InstitutesRating institute) {
        return institutesRatingRepository.saveAndFlush(institute);
    }

    public InstitutesRating getById(long id) {
        return institutesRatingRepository.findById(id);
    }

    public List<InstitutesRating> getByUserAndInstitution(User user, Institute institute) {
        return institutesRatingRepository.findByUserAndInstitute(user,institute);
    }

    public List<InstitutesRating> getByUser(User user) {
        return institutesRatingRepository.findByUser(user);
    }

    public List<InstitutesRating> getByInstitute(Institute institute) {
        return institutesRatingRepository.findByInstitute(institute);
    }

    public InstitutesRating editInstitutesRating(InstitutesRating institutesRating) {
        return institutesRatingRepository.saveAndFlush(institutesRating);
    }

    public List<InstitutesRating> getAll() {
        return institutesRatingRepository.findAll();
    }

    public int getSrednee(Institute institute)
    {
        int n=0,mark=0;
        List<InstitutesRating> list=this.getByInstitute(institute);
        for(int i=0;i<list.size();i++)
        {
            mark=mark+list.get(i).getMark();
            n++;
        }
        if(n==0) return 0;
        else return mark/n;
    }
}
