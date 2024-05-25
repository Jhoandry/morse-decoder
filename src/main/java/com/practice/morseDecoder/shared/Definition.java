package com.practice.morseDecoder.shared;

import lombok.Getter;

@Getter
public enum Definition {
    A(".-", "A"),
    B("-...", "B"),
    C("-.-.", "C"),
    D("-..", "D"),
    E(".", "E"),
    F("..-.", "F"),
    G("--.", "G"),
    H("....", "H"),
    I("..", "I"),
    J(".---", "J"),
    K("-.-", "K"),
    L(".-..", "L"),
    M("--", "M"),
    N("-.", "N"),
    O("---", "O"),
    P(".--.", "P"),
    Q("--.-", "Q"),
    R(".-.", "R"),
    S("...", "S"),
    T("-", "T"),
    U("..-", "U"),
    V("...-", "V"),
    W(".--", "W"),
    X("-..-", "X"),
    Y("-.--", "Y"),
    Z("--..", "Z"),
    ONE(".----", "1"),
    TWO("..---", "2"),
    THREE("...--", "3"),
    FOUR("....-", "4"),
    FIVE(".....", "5"),
    SIX("-....", "6"),
    SEVEN("--...", "7"),
    EIGHT("---..", "8"),
    NINE("----.", "9"),
    TEN("-----", "10"),
    NONE(" ", " ");

    private final String code;
    private final String value;

    private Definition(String code, String value) {
        this.code = code;
        this.value = value;
    }
}