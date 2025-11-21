package myPacket.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestDto {
    private int a;
    private int b;
    private String symbol;
}
