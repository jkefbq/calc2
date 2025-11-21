package myPacket.builders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import myPacket.entity.CalcInfo;

@Getter
@AllArgsConstructor
public class CalcInfoBuilder {
    private final CalcInfo calcInfo;

    public CalcInfoBuilder setNum1(int num1) {
        calcInfo.setNum1(num1);
        return this;
    }

    public CalcInfoBuilder setNum2(int num2) {
        calcInfo.setNum2(num2);
        return this;
    }

    public CalcInfoBuilder setResult(int res) {
        calcInfo.setResult(res);
        return this;
    }
}
