package org.example.exception;

public class RegisterException extends Exception{
    public enum ExceptionType{
        NORMAL,EXIST;
    }
    private String exceptionStr ;
    private ExceptionType type;


    public RegisterException() {
        super();
    }

    public RegisterException(String str) {
        super(str);
        this.exceptionStr = str;
    }

    public String getExceptionStr() {
        return exceptionStr;
    }

    public void setExceptionStr(String exceptionStr) {
        this.exceptionStr = exceptionStr;
    }

    public ExceptionType getType() {
        return type;
    }

    public void setType(ExceptionType type) {
        this.type = type;
    }
}
