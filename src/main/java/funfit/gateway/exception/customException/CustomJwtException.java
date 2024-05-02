package funfit.gateway.exception.customException;

import funfit.gateway.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class
CustomJwtException extends RuntimeException {

    private final ErrorCode errorCode;
}
