package ua.demo.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.JSONException;
import org.junit.Test;
import ua.demo.json.pojo.ExtendableBean;
import ua.demo.json.pojo.MyBean;
import ua.demo.json.pojo.RawBean;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class JacksonAnnotationTest {
    @Test
    public void whenSerializingUsingJsonAnyGetter_thenCorrect()
            throws JsonProcessingException {

        Map<String, String> properties = new HashMap<>();
        properties.put("attr1", "val1");
        properties.put("attr2", "val2");

        ExtendableBean bean = new ExtendableBean();
        bean.setName("My bean");
        bean.setProperties(properties);

        String result = new ObjectMapper().writeValueAsString(bean);

        assertThat(result).contains("attr1");
        assertThat(result).contains("val1");
    }

    @Test
    public void whenDeserializingUsingJsonAnySetter_thenCorrect()
            throws JSONException, IOException {
        String json = "{\"name\":\"My bean\",\"attr2\":\"val2\",\"attr1\":\"val1\"}";

        ObjectMapper mapper = new ObjectMapper();
        ExtendableBean extendableBean = mapper.readValue(json, ExtendableBean.class);

        assertThat(extendableBean.getName()).isEqualTo("My bean");
        assertThat(extendableBean.getProperties()).size().isEqualTo(2);
    }

    @Test
    public void JsonPropertyOrderTest() throws JsonProcessingException {
        MyBean myBean = new MyBean();
        myBean.setId(1);
        myBean.setName("My bean");

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String json = mapper.writeValueAsString(myBean);

        System.out.println("json = " + json);
    }

    @Test
    public void whenSerializingUsingJsonRawValue_thenCorrect()
            throws JsonProcessingException {

        RawBean bean = new RawBean();
        bean.setName("My bean");
        bean.setJson("\"{\"attr\":false}\"");

        String result = new ObjectMapper().writeValueAsString(bean);

        assertThat(result).contains("My bean");
        assertThat(result).contains("{\"attr\":false}");
    }
}
