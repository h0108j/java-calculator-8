package calculator.common;

import static calculator.common.Constants.CUSTOM_END_MARK;

public class Exception {
    public static final String RESERVED_WORD_DELIMITER_EXCEPTION = "잘못된 구분자입니다. 예약어는 커스텀 구분자로 사용할 수 없습니다.";
    public static final String NOT_ALLOWED_ZERO_EXCEPTION = "잘못된 숫자입니다. 0은 양수가 아닙니다.";
    public static final String UNREGISTERED_CUSTOM_DELIMITER_EXCEPTION = "잘못된 입력입니다. 커스텀 구분자로 등록되지 않은 문자는 사용할 수 없습니다.";
    public static final String EMPTY_CUSTOM_DELIMITER_EXCEPTION = "잘못된 구분자입니다. 빈 문자는 커스텀 구분자로 사용할 수 없습니다.";
    public static final String MISSING_END_MARK_EXCEPTION  = "잘못된 입력입니다. " + CUSTOM_END_MARK + "를 찾을 수 없습니다.";

    private Exception() {}
}