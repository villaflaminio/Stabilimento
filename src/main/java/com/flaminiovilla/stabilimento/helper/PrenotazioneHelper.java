package com.flaminiovilla.stabilimento.helper;

import com.flaminiovilla.stabilimento.repository.OmbrelloneRepository;
import com.flaminiovilla.stabilimento.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PrenotazioneHelper {

    @Autowired
    private PrenotazioneRepository prenotazioneRepositor;

}