package com.learning.mpholo.sftpetclinic.services.map;

import com.learning.mpholo.sftpetclinic.model.PetType;
import com.learning.mpholo.sftpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType,Long> implements PetTypeService {
}
