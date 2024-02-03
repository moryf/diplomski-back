package com.konstil.Ponude.controllers;

import com.konstil.Ponude.service.OpstiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/{path}")
@CrossOrigin
public class OpstiController<T,ID> {

    private String path;
    @Autowired
    private OpstiService<T,ID> opstiService;


}
