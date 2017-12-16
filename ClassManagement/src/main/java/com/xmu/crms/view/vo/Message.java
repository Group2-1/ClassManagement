package com.xmu.crms.view.vo;

import java.util.List;
/**
 * 
 * @author lingyun
 *
 */
public class Message {

    private String message;
    private List<String> error;

    public Message(){}

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getError() {
        return error;
    }

    public void setError(List<String> error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "Response{" +
                "message='" + message + '\'' +
                ", error=" + error +
                '}';
    }
}
