package ua.demo.json.pojo;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({"name", "id"})
@JsonRootName(value = "bean")
public class MyBean {
    private int id;
    private String name;
}
