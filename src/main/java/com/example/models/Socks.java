package com.example.models;

import com.example.models.enums.Color;
import com.example.models.enums.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.Objects;

@Data
@NoArgsConstructor
public class Socks {

    private Size size;

    private Color color;

    @Max(value = 100, message = "Не может быть больше 100")
    @Positive(message = "Не может быть отрицательным")
    int cotton;

    int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Socks socks = (Socks) o;
        return cotton == socks.cotton && size == socks.size && color == socks.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, color, cotton);
    }
}
