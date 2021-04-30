package com.flaminiovilla.stabilimento.helper;

import com.flaminiovilla.stabilimento.repository.OmbrelloneRepository;
import com.flaminiovilla.stabilimento.repository.StabilimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class StabilimentoHelper {

    @Autowired
    private StabilimentoRepository stabilimentoRepository;

}