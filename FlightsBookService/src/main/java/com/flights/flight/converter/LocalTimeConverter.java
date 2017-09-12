package com.flights.flight.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Optional;

@Converter(autoApply = true)
public class LocalTimeConverter implements AttributeConverter<LocalTime,Time>{

    @Override
    public Time convertToDatabaseColumn(LocalTime time) {
        return Optional.ofNullable(time).map(Time::valueOf).orElse(null);
    }

    @Override
    public LocalTime convertToEntityAttribute(Time time) {
        return Optional.ofNullable(time).map(Time::toLocalTime).orElse(null);
    }
}