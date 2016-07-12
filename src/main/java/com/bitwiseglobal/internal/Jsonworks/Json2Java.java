package com.bitwiseglobal.internal.Jsonworks;

import com.bitwiseglobal.external.PropertyReader;
import com.bitwiseglobal.internal.mappingObjects.AssignmentMapper;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aniruddha Sinha on 20-04-2016.
 */
public class Json2Java {
    private PropertyReader propertyReader;
    private List<String> valueAcceptor;
    private ObjectMapper objectMapper;
    private List<Object> obj;
    public Json2Java(){
        this.propertyReader=new PropertyReader();
        this.valueAcceptor=new ArrayList<>();
        this.objectMapper=new ObjectMapper();
        this.obj=new ArrayList<>();
    }

    public List<String> getValues() throws IOException {
        this.propertyReader.getPropertyKeysAndValues().values().stream().forEach(e->{this.valueAcceptor.add(e);});
        return this.valueAcceptor;
    }

    public List<Object> convertToPOJO() throws IOException {

        for(String jsonData:getValues()){
            this.obj.add(this.objectMapper.readValue(jsonData,AssignmentMapper.class));

        }
        return this.obj;
    }
}
