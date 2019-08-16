package com.learning.mpholo.sftpetclinic.services.map;

import com.learning.mpholo.sftpetclinic.model.Pet;
import com.learning.mpholo.sftpetclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeServiceMap extends AbstractMapService<Pet,Long> implements PetService {
}
