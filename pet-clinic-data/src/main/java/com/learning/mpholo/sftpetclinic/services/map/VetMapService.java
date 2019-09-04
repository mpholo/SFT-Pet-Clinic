package com.learning.mpholo.sftpetclinic.services.map;

import com.learning.mpholo.sftpetclinic.model.Speciality;
import com.learning.mpholo.sftpetclinic.model.Vet;
import com.learning.mpholo.sftpetclinic.services.SpecialityService;
import com.learning.mpholo.sftpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default","map"})
public class VetMapService extends AbstractMapService<Vet,Long>  implements VetService {

    private SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }


    @Override
    public Vet save(Vet object) {

        if(object.getSpecialities().size()>0) {
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId()==null) {
                   Speciality savedSpeciality= specialityService.save(speciality);
                   speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }
}
