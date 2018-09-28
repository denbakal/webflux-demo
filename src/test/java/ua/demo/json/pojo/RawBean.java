package ua.demo.json.pojo;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RawBean {
    private String name;

    @JsonRawValue
    private String json;
}
