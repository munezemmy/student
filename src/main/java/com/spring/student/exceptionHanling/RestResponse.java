package com.spring.student.exceptionHanling;

public class RestResponse<T> {

    private T data;
    private ApiError error;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ApiError getError() {
        return error;
    }

    public void setError(ApiError error) {
        this.error = error;
    }
}
