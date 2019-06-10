package com.bank.ats.exception;

public class ATSException extends Exception{

    public ATSException(String msg){
        super(msg);
    }

    public ATSException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}
