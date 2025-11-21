package myPacket.service;

import org.springframework.stereotype.Service;

@Service
public class CalculateService {

    public int calculate(String sym, int num1, int num2) {
        return switch (sym) {
            case "-" -> num1 - num2;
            case "+" -> num1 + num2;
            case "/" -> num1 / num2;
            case "*" -> num1 * num2;
            default -> throw new IllegalArgumentException("symbol must be equal to [*],[+],[/],[-]");
        };
    }

}