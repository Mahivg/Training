package com.vg.calendar.util.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateTimeDeSerializer extends StdDeserializer<LocalDateTime> {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, y, h:mm:ss a zzzz", Locale.US);

    protected LocalDateTimeDeSerializer() {
        super(LocalDateTime.class);
    }

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return LocalDateTime.parse(jsonParser.readValueAs(String.class));
    }
}
