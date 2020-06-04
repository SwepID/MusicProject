package entities;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

public class BaseEntity {
    @Override
    public String toString() {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(writer, this);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }
}
