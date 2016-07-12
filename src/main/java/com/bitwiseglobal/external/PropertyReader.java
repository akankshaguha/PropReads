package com.bitwiseglobal.external;




import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

/**
 * Created by Aniruddha Sinha on 19-04-2016.
 */
public class PropertyReader {
    private Properties properties;
    private Map<String,String> intermediateKeyValueAcceptor;
    private File inputPropertyFile;

    public PropertyReader(){
        this.properties=new Properties();
        this.intermediateKeyValueAcceptor=new TreeMap<>();
        this.inputPropertyFile=new File("src/main/resources/property1");

    }
    void loadProperties() throws IOException {
        try {
            this.properties.load(new FileInputStream(this.inputPropertyFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            new FileInputStream(this.inputPropertyFile).close();
        }
    }


    public Map<String,String> getPropertyKeysAndValues() throws IOException {
        loadProperties();
        this.properties.entrySet().stream().forEach(e->{
            this.intermediateKeyValueAcceptor.put(e.getKey().toString(),
                    e.getValue().toString());
        });
        return this.intermediateKeyValueAcceptor;
    }


}
