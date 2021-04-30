package com.flaminiovilla.stabilimento.helper;

import com.flaminiovilla.stabilimento.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ClienteHelper {

    @Autowired
    private ClienteRepository clienteRepository;

}