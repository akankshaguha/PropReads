package com.bitwiseglobal.internal.jsonworks;

import com.bitwiseglobal.internal.Jsonworks.Json2Java;
import com.bitwiseglobal.internal.mappingObjects.AssignmentMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aniruddha Sinha on 20-04-2016.
 */
public class Json2JavaTest {
    @Test
    public void itShouldEnsureThatAllTheValuesOfTheRespectiveKeysHaveBeenExtractedFromTheMap() throws IOException {
        //given
        Json2Java json2Java=new Json2Java();
        List<String> expectedValues=new ArrayList<String>(){{
            add("{\"package\":\"com.bitwiseglobal.postfix.Main\", \"function\":\"FunctionName1\",\"type\":[\"String\",\"int\"]}");
            add("{\"package\":\"com.bitwiseglobal.postfix.Main2\", \"function\":\"FunctionName2\",\"type\":[\"String\",\"int\"]}");
            add("{\"package\":\"com.bitwiseglobal.postfix.Main3\", \"function\":\"FunctionName3\",\"type\":[\"String\",\"int\"]}");
        }};
        //when
        List<String> actual=json2Java.getValues();
        //then
        Assert.assertArrayEquals(expectedValues.toArray(),actual.toArray());
    }
    @Test
    public void itShouldCheckWhetherTheFieldsHaveBeenCorrectlyMappedByJsonParser() throws IOException {
        //given
        Json2Java json2Java=new Json2Java();
        AssignmentMapper assgt=(AssignmentMapper)json2Java.convertToPOJO().get(1);
        //when
        String expectedPackageName="com.bitwiseglobal.postfix.Main2";
        String actualPackageName=assgt.getPackage();
        //then
        Assert.assertEquals(expectedPackageName,actualPackageName);
    }
}
