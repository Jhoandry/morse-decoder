package com.practice.morseDecoder;

import com.practice.morseDecoder.shared.Decoder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecoderTest {

    private Decoder decoder;

    @BeforeEach
    public void setUp() {
        decoder = new Decoder();
    }

    @Test
    public void TestDecodeMorse() {
        assertEquals("HEY JUDE", decoder.decodeMorse(".... . -.--  .--- ..- -.. ."), "Decode result should be >> HEY JUDE");
        assertEquals("SOS", decoder.decodeMorse("... --- ..."), "Decode result should be >> SOS");
        assertEquals("MORSE 10", decoder.decodeMorse("-- --- .-. ... .  -----"), "Decode result should be >> MORSE 10");
    }
}
