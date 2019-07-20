package com.learning.mpholo.sftpetclinic.services;

import com.learning.mpholo.sftpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
