package com.practice.morseDecoder.services;

import com.practice.morseDecoder.models.DecoderRequest;
import com.practice.morseDecoder.shared.Decoder;
import org.springframework.stereotype.Service;

@Service
public class DecoderService {

    private final Decoder decoder = new Decoder();

    public DecoderRequest getMorseDecoder(DecoderRequest decoderRequest) {
        decoderRequest.setOutput(decoder.decodeMorse(decoderRequest.getInput()));
        return decoderRequest;
    }
}
