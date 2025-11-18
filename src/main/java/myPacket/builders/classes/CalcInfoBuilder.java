package myPacket.builders.classes;

import lombok.AllArgsConstructor;
import myPacket.builders.interfaces.CalcInfoBuild;
import myPacket.entity.CalcInfo;

@AllArgsConstructor
public class CalcInfoBuilder implements CalcInfoBuild {
    private final CalcInfo calcInfo;

    public CalcInfo getCalcInfo() {
        return this.calcInfo;
    }

    @Override
    public CalcInfoBuilder setNum1(int num1) {
        calcInfo.setNum1(num1);
        return this;
    }

    @Override
    public CalcInfoBuilder setNum2(int num2) {
        calcInfo.setNum2(num2);
        return this;
    }

    @Override
    public CalcInfoBuilder setResult(String res) {
        calcInfo.setResult(res);
        return this;
    }
}
