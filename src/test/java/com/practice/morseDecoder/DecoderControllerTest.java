package com.practice.morseDecoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.morseDecoder.models.DecoderRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DecoderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDecodeValue() throws Exception {
        DecoderRequest decoderRequest = new DecoderRequest(".... . .-.. .-.. ---", null);

        mockMvc.perform( MockMvcRequestBuilders
                            .post("/morse/decode")
                            .content(objectMapper.writeValueAsString(decoderRequest))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.output").value("HELLO"));
    }

    @Test
    public void testInputValidation() throws Exception {
        DecoderRequest decoderRequest = new DecoderRequest("", null);

        mockMvc.perform( MockMvcRequestBuilders
                        .post("/morse/decode")
                        .content(objectMapper.writeValueAsString(decoderRequest))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }
}
