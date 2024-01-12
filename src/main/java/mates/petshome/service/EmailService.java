package mates.petshome.service;

import mates.petshome.model.AdoptAnimalForm;
import mates.petshome.model.ContactUsForm;

public interface EmailService {
    void notifyAboutNewAdoptRequest(Long id, AdoptAnimalForm requestForm);

    void notifyAboutNewContactUsRequest(ContactUsForm requestForm);
}
