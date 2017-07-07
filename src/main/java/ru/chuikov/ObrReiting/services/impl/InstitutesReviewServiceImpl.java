package ru.chuikov.ObrReiting.services.impl;

import org.springframework.stereotype.Service;
import ru.chuikov.ObrReiting.entity.Institute;
import ru.chuikov.ObrReiting.entity.InstitutesReview;
import ru.chuikov.ObrReiting.entity.User;
import ru.chuikov.ObrReiting.services.InstitutesReviewService;

import java.util.List;

@Service("InstitutesReview")
public class InstitutesReviewServiceImpl implements InstitutesReviewService {
    public InstitutesReview addReview(InstitutesReview institutesReview) {
        return null;
    }

    public InstitutesReview editReview(InstitutesReview institutesReview) {
        return null;
    }

    public List<InstitutesReview> getAll() {
        return null;
    }

    public List<InstitutesReview> getModerated() {
        return null;
    }

    public List<InstitutesReview> getUnModerated() {
        return null;
    }

    public List<InstitutesReview> getByUser(User user) {
        return null;
    }

    public List<InstitutesReview> getByInstitute(Institute institute) {
        return null;
    }

    public InstitutesReview getByUserAndInstitution(User user, Institute institute) {
        return null;
    }
}
