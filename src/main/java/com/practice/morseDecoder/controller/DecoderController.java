package com.practice.morseDecoder.controller;


import com.practice.morseDecoder.models.DecoderRequest;
import com.practice.morseDecoder.services.DecoderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/morse")
public class DecoderController {

    @Autowired
    private DecoderService decoderService;

    @PostMapping("/decode")
    private DecoderRequest decoderRequest(@Valid @RequestBody DecoderRequest decoderRequest) {
        return decoderService.getMorseDecoder(decoderRequest);
    }
}
