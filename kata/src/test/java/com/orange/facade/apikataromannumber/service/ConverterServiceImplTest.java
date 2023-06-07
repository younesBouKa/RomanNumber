package com.orange.facade.apikataromannumber.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ConverterServiceImplTest {

    private static Map<String, Integer> randomValues = new HashMap<>();
    private static String[] sortedRomanValues;
    //@InjectMocks
    private ConverterService converterService = new ConverterServiceImpl();

    @BeforeAll
    static void setUp() {
        // random Values
        randomValues = new HashMap<>();
        randomValues.put("ML", 1050);
        randomValues.put("LX", 60);
        randomValues.put("DCIV", 604);
        randomValues.put("CXIV", 114);
        randomValues.put("CLXXV", 175);
        // sorted values
        sortedRomanValues = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX"};
    }

    @Test
    void isRomanNumberValid_valid_true() {
        int size = sortedRomanValues.length;
        int randomIndex = (int) ((Math.random()*size) / size);
        String romanValue = sortedRomanValues[randomIndex];
        boolean isValid = converterService.isRomanNumberValid(romanValue);
        assertThat(isValid).isTrue();
    }

    @Test
    void isRomanNumberValid_valid_false() {
        String romanValue = "JFR";
        boolean isValid = converterService.isRomanNumberValid(romanValue);
        assertThat(isValid).isFalse();
    }

    @Test
    void isRomanNumberValid_valid_null() {
        String romanValue = null;
        boolean isValid = converterService.isRomanNumberValid(romanValue);
        assertThat(isValid).isFalse();
    }

    @Test
    void arabicToRoman_valid_value() {
        int size = randomValues.keySet().size();
        int randomIndex = (int) ((Math.random()*size) / size);
        String romanValue = new ArrayList<>(randomValues.keySet()).get(randomIndex);
        int arabicValue = randomValues.get(romanValue);
        String convertedRomanValue = converterService.arabicToRoman(arabicValue);
        assertThat(convertedRomanValue).isEqualTo(romanValue);
    }

    @Test
    void romanToArabic_valid_value() {
        int size = randomValues.keySet().size();
        int randomIndex = (int) ((Math.random()*size) / size);
        String romanValue = new ArrayList<>(randomValues.keySet()).get(randomIndex);
        int arabicValue = randomValues.get(romanValue);
        int convertedArabicValue = converterService.romanToArabic(romanValue);
        assertThat(convertedArabicValue).isEqualTo(arabicValue);
    }

    @Test
    void romanToArabic_invalid_value() {
        String romanValue = "JFT";
        int arabicValue = 0;
        int convertedArabicValue = converterService.romanToArabic(romanValue);
        assertThat(convertedArabicValue).isEqualTo(arabicValue);
    }
}