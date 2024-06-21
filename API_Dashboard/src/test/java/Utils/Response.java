package Utils;

import lombok.*;
import org.jetbrains.annotations.Nullable;

@Builder
@Data
public class Response {
    private int statusCode;
    @Nullable
    private String body;
}
