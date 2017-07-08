package ru.chuikov.ObrReiting.services;


import ru.chuikov.ObrReiting.entity.Institute;
import ru.chuikov.ObrReiting.entity.InstitutesReview;
import ru.chuikov.ObrReiting.entity.User;

import java.util.List;

public interface InstitutesReviewService {
    InstitutesReview addReview(InstitutesReview institutesReview);
    InstitutesReview editReview(InstitutesReview  institutesReview);
    InstitutesReview getById(long id);
    List<InstitutesReview> getAll();
    List<InstitutesReview> getModerated();
    List<InstitutesReview> getUnModerated();
    List<InstitutesReview> getByUser(User user);
    List<InstitutesReview> getByInstitute(Institute institute);
    List<InstitutesReview> getByUserAndInstitution(User user, Institute institute);
}
