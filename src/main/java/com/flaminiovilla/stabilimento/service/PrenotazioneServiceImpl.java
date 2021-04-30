package com.flaminiovilla.stabilimento.service;

import com.flaminiovilla.stabilimento.helper.PrenotazioneHelper;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService {

    @Autowired
    PrenotazioneHelper prenotazioneHelper;


    @Override
    public Boolean search(String search) {
        return null;
    }

}
