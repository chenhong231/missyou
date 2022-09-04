package com.lin.eshopping.exception.http;

public class ServerErrorException extends HttpException {

    public ServerErrorException(int code) {
        this.code = code;
        this.httpStatusCode = 500;
    }
}
