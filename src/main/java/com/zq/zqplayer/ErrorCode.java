package com.zq.zqplayer;

public interface ErrorCode {

    /**
     * 10000 网络繁忙
     * 10001 无此用户
     * 10002 添加成功
     * 10003 删除成功
     * 10004 更新成功
     * 10005 此用户已存在
     * 10006 添加失败
     * 10007 删除失败
     * 10008 更新失败
     * -1 请求失败
     * 0 请求成功
     */
    int OK = 1; //操作成功
    int ERROR = 0; //操作失败

    int NOTEXISTUSER = 10001;//无此用户
    int ADDSUCCESS = 10002;//添加成功
    int DELETESUCCESS = 10003;//删除成功
    int UPDATESUCCESS = 10004;//更新成功
    int EXISTUSER = 10005;//此用户已存在
    int ADDFAIL = 10006;//添加失败
    int UPDATEFAIL = 10008;//更新失败


    long getCode();

    String getMessage();
}