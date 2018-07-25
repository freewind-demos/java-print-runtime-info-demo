package demo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

import static demo.NumberUtils.convertToM;
import static java.lang.Runtime.getRuntime;

public class Hello {

    public static void main(String[] args) {
        System.out.println(new SystemInfo());
    }

}

class SystemInfo {

    double cores = getRuntime().availableProcessors();
    double totalMemory = convertToM(getRuntime().totalMemory());
    double freeMemory = convertToM(getRuntime().freeMemory());
    double maxMemory = convertToM(getRuntime().maxMemory());

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

class NumberUtils {

    static double convertToM(long num) {
        return format(num * 1.0 / (1024 * 1024), 3);
    }

    static double format(double num, int decimal) {
        return new BigDecimal(num).setScale(decimal, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}


