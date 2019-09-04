package com.learning.mpholo.sftpetclinic.services.map;

import com.learning.mpholo.sftpetclinic.model.PetType;
import com.learning.mpholo.sftpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default","map"})
public class PetTypeMapService extends AbstractMapService<PetType,Long> implements PetTypeService {
}
