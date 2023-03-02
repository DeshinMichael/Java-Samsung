package com.company;

public class MyHash {
    private boolean booleanValue = true;
    private char charValue = 'm';
    private String stringValue = "MyHash";
    private long longValue = 34829245849498300l;
    private float floatValue = 345832400.93f;
    private double doubleValue = 98584292348454.9834;
    private byte[] arrayValue = {5, 6, 7};

    @Override
    public int hashCode() {
        int result = 17;
        int value = booleanValue?0:1;
        result = result * 31 + value;
        value = charValue;
        result = result * 31 + value;
        value = (int)(longValue - (longValue >>> 32));
        result = result * 31 + value;
        value = stringValue.hashCode();
        result = result * 31 + value;
        value = Float.floatToIntBits(floatValue);
        return result;
    }
}
