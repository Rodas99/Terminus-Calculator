package com.terminus.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class SymbolService {

    public Integer processXSymbolClick(String symbol) {

        switch (symbol) {
            case "1a":
                return 0;
            case "2a":
                return 11;
            case "3a":
                return 10;
            case "4a":
                return 22;
            case "5a":
                return 21;
            case "6a":
                return 20;
        }
        return Integer.valueOf(symbol);
    }

    public Integer processYSymbolClick(String symbol) {

        switch (symbol) {
            case "1b":
                return 0;
            case "2b":
                return 11;
            case "3b":
                return 10;
            case "4b":
                return 22;
            case "5b":
                return 21;
            case "6b":
                return 20;
        }
        return Integer.valueOf(symbol);
    }

    public Integer processZSymbolClick(String symbol) {

        switch (symbol) {
            case "1c":
                return 0;
            case "2c":
                return 11;
            case "3c":
                return 10;
            case "4c":
                return 22;
            case "5c":
                return 21;
            case "6c":
                return 20;
        }
        return Integer.valueOf(symbol);
    }
}
