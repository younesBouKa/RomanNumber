package com.orange.facade.apikataromannumber.service;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class ConverterServiceImpl implements ConverterService{
    private static final Map<String, Integer> roman_char_dict ;
    private static final List<Integer> multipls ;

    static {
        // roman to arabic
        roman_char_dict = new HashMap<>();
        roman_char_dict.put("I", 1);
        roman_char_dict.put("IV", 4);
        roman_char_dict.put("V", 5);
        roman_char_dict.put("IX", 9);
        roman_char_dict.put("X", 10);
        roman_char_dict.put("L", 50);
        roman_char_dict.put("C", 100);
        roman_char_dict.put("D", 500);
        roman_char_dict.put("M", 1000);
        // les multiples ordonnés
        multipls = roman_char_dict.values().stream().sorted((x,y) -> - x.compareTo(y)).collect(Collectors.toList());
    }

    private String getChar(int i){
        for(String c : roman_char_dict.keySet())
            if(roman_char_dict.get(c).equals(i))
                return c;
        return "";
    }

    private int getNum(String c){
        return roman_char_dict.get(c);
    }

    private int getNum(char c){
        return roman_char_dict.get(c+"");
    }

    public boolean isRomanNumberValid(String romanNum){
        if(romanNum==null || romanNum.isEmpty())
            return false;
        for (int i = 0; i < romanNum.length(); i++) {
            if(!roman_char_dict.containsKey(""+romanNum.charAt(i)))
                return false;
        }
        return true;
    }

    public String arabicToRoman(int arabicNum) {
        StringBuilder res = new StringBuilder();
        int rest = arabicNum;
        while (rest>0){
            for(int multipl : multipls){
                if(rest / multipl >=1 ){
                    int nbrRepitition = rest / multipl;
                    rest = rest % multipl;
                    for(int j=0; j<nbrRepitition; j++){
                        res.append(getChar(multipl));
                    }
                    break;
                }
            }
        }
        return res.toString();
    }

    public int romanToArabic(String romanNum) {
        int res = 0;
        if(!isRomanNumberValid(romanNum))
            return res;
        for (int i = 0; i < romanNum.length(); i++) {
            if (i == 0 || getNum(romanNum.charAt(i)) <= getNum(romanNum.charAt(i - 1)))
                res += getNum(romanNum.charAt(i));
            else
                res += getNum(romanNum.charAt(i)) - 2 * getNum(romanNum.charAt(i - 1));
        }
        return res;
    }

    public static void main(String[] args) {
        ConverterServiceImpl converterService = new ConverterServiceImpl();
        String romanNumInput = "IVIII";
        int arabicNum = converterService.romanToArabic(romanNumInput);
        System.out.println("Roman to arabic " + romanNumInput + " equal to: " + arabicNum);
        String romanNum = converterService.arabicToRoman(arabicNum);
        System.out.println("Arabic to roman " + arabicNum + " equal to: " + romanNum);
    }
}