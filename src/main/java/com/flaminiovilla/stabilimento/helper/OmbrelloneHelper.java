package com.flaminiovilla.stabilimento.helper;

import com.flaminiovilla.stabilimento.repository.ClienteRepository;
import com.flaminiovilla.stabilimento.repository.OmbrelloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OmbrelloneHelper {

    @Autowired
    private OmbrelloneRepository ombrelloneRepository;

}