package ru.chuikov.ObrReiting.services;


import ru.chuikov.ObrReiting.entity.Institute;
import ru.chuikov.ObrReiting.entity.InstitutesRating;
import ru.chuikov.ObrReiting.entity.User;

import java.util.List;

public interface InstitutesRatingService {
    InstitutesRating addInstitutesRating(InstitutesRating institute);
    InstitutesRating getById(long id);
    List<InstitutesRating>  getByUserAndInstitution(User user, Institute institute);
    List<InstitutesRating> getByUser(User user);
    List<InstitutesRating> getByInstitute(Institute institute);
    InstitutesRating editInstitutesRating(InstitutesRating institutesRating);
    List<InstitutesRating> getAll();
}
