package com.bitwiseglobal.external;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Aniruddha Sinha on 19-04-2016.
 */
public class PropertyReaderTest {
    @Test
    public void itShouldBeAbleToReadTheContentsOfThePropertyFile() throws IOException {
        //given
        PropertyReader prop=new PropertyReader();
        //when
        String testPropertyKey="entryfun1";
        String testPropertyValue="{\"package\":\"com.bitwiseglobal.postfix.Main\", \"function\":\"FunctionName1\",\"type\":[\"String\",\"int\"]}";
        prop.loadProperties();
        //then
        String actualResult=prop.getPropertyKeysAndValues().get(testPropertyKey);
        Assert.assertEquals(testPropertyValue,actualResult);
    }
    @Test
    public void itShouldBeAbleToReadThePropertyFileContentAsKeyValues() throws IOException {
        //given
        PropertyReader prop=new PropertyReader();
        Map<String,String> expected=new LinkedHashMap<String,String>(){{
            put("entryfun1","{\"package\":\"com.bitwiseglobal.postfix.Main\", \"function\":\"FunctionName1\",\"type\":[\"String\",\"int\"]}");
            put("entryfun2","{\"package\":\"com.bitwiseglobal.postfix.Main2\", \"function\":\"FunctionName2\",\"type\":[\"String\",\"int\"]}");
            put("entryfun3","{\"package\":\"com.bitwiseglobal.postfix.Main3\", \"function\":\"FunctionName3\",\"type\":[\"String\",\"int\"]}");
        }};
        //when
        Map<String,String> actual=prop.getPropertyKeysAndValues();
        //then
        assertArrayEquals(expected.keySet().toArray(),actual.keySet().toArray());
        assertArrayEquals(expected.values().toArray(),actual.values().toArray());
    }
}
