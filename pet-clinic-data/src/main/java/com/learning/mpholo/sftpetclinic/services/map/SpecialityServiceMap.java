package com.learning.mpholo.sftpetclinic.services.map;

import com.learning.mpholo.sftpetclinic.model.Speciality;
import com.learning.mpholo.sftpetclinic.services.SpecialityService;
import org.springframework.stereotype.Service;

@Service
public class SpecialityServiceMap extends AbstractMapService<Speciality,Long>
        implements SpecialityService {
}
