package ru.chuikov.ObrReiting.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.chuikov.ObrReiting.entity.Institute;
import ru.chuikov.ObrReiting.entity.InstitutesReview;
import ru.chuikov.ObrReiting.entity.User;
import ru.chuikov.ObrReiting.repository.InstitutesReviewRepository;
import ru.chuikov.ObrReiting.services.InstitutesReviewService;

import java.util.List;

@Service("InstitutesReview")
public class InstitutesReviewServiceImpl implements InstitutesReviewService {
    @Autowired
    private InstitutesReviewRepository institutesReviewRepository;

    public InstitutesReview addReview(InstitutesReview institutesReview) {
        return institutesReviewRepository.saveAndFlush(institutesReview);
    }

    public InstitutesReview editReview(InstitutesReview institutesReview) {
        return institutesReviewRepository.saveAndFlush(institutesReview);
    }

    public InstitutesReview getById(long id) {
        return institutesReviewRepository.findById(id);
    }

    public List<InstitutesReview> getAll() {
        return institutesReviewRepository.findAll();
    }

    public List<InstitutesReview> getModerated() {
        return institutesReviewRepository.findByModerated();
    }

    public List<InstitutesReview> getUnModerated() {
        return institutesReviewRepository.findByUnModerated();
    }

    public List<InstitutesReview> getByUser(User user) {
        return institutesReviewRepository.findByUser(user);
    }

    public List<InstitutesReview> getByInstitute(Institute institute) {
        return institutesReviewRepository.findByInstitute(institute);
    }

    public List<InstitutesReview> getByUserAndInstitution(User user, Institute institute) {
        return institutesReviewRepository.findByUserAndInstitute(user,institute);
    }
}
