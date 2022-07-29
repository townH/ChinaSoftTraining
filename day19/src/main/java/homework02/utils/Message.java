package homework02.utils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Message implements Serializable {
    int code;
    int len;
    byte[] bytes;

    String msg;

    String name;
    List<String> picName;

    @Override
    public String toString() {
        return "Message{" +
                "code=" + code +
                ", len=" + len +
                ", bytes=" + Arrays.toString(bytes) +
                ", msg='" + msg + '\'' +
                ", name='" + name + '\'' +
                ", picName=" + picName +
                '}';
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public List<String> getPicName() {
        return picName;
    }

    public void setPicName(List<String> picName) {
        this.picName = picName;
    }
}
