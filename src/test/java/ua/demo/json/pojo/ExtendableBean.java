package ua.demo.json.pojo;

import com.fasterxml.jackson.annotation.*;
import com.google.common.collect.Maps;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtendableBean {
    private String name;
    private Map<String, String> properties = Maps.newHashMap();

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }

    @JsonAnySetter
    public void setProperties(String name, String value) {
        properties.put(name, value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }
}
