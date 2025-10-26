package myPacket.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestDTO {
    private int a;
    private int b;
    private String symbol;
}
