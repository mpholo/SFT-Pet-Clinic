package com.learning.mpholo.sftpetclinic.services.map;

import com.learning.mpholo.sftpetclinic.model.Speciality;
import com.learning.mpholo.sftpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default","map"})
public class SpecialityMapService extends AbstractMapService<Speciality,Long>
        implements SpecialityService {
}
