package edu.cl.learn.base;

/**
 * @Author: Clay
 * @Date: 2021/2/12 12:52 上午
 */
public class RestResponse<T> {
    private int code;
    private String message;
    private T response;

    public RestResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public RestResponse(int code, String message, T response) {
        this.code = code;
        this.message = message;
        this.response = response;
    }

    public static RestResponse success() {
        SystemCode systemCode = SystemCode.SUCCESS;
        return new RestResponse<>(systemCode.getCode(), systemCode.getMessage());
    }
    public static <F> RestResponse<F> success(F response) {
        SystemCode systemCode = SystemCode.SUCCESS;
        return new RestResponse<>(systemCode.getCode(), systemCode.getMessage(), response);
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
