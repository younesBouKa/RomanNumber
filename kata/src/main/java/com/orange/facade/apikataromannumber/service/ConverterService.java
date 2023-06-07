package com.orange.facade.apikataromannumber.service;

public interface ConverterService {
    boolean isRomanNumberValid(String romanNum);
    String arabicToRoman(int arabicNum);
    int romanToArabic(String romanNum);
}
