package com.bitwiseglobal.internal.mappingObjects;

import java.util.Arrays;

/**
 * Created by Aniruddha Sinha on 20-04-2016.
 */
public class AssignmentMapper {

    private String Package;
    private String function;
    private String[] type;

    public void setPackage(String aPackage) {
        Package = aPackage;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setType(String[] type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "AssignmentMapper{" +
                "Package='" + Package + '\'' +
                ", function='" + function + '\'' +
                ", type=" + Arrays.toString(type) +
                '}';
    }

    public String getPackage() {
        return Package;
    }

    public String getFunction() {
        return function;
    }

    public String[] getType() {
        return type;
    }
}
