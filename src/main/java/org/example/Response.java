package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString

public class Response {
    Location location;
    Current current;
    Condition condition;
}
