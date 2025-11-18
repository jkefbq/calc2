package myPacket.builders.interfaces;

import myPacket.builders.classes.CalcInfoBuilder;
import myPacket.entity.CalcInfo;

public interface CalcInfoBuild {
    CalcInfo getCalcInfo();
    CalcInfoBuilder setNum1(int num1);
    CalcInfoBuilder setNum2(int num2);
    CalcInfoBuilder setResult(String res);
}
