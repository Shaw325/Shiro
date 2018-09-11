package com.shaw.util;

import com.shaw.Enum.Status;

/**
 * @ClassName: DataMsg
 * @Description:
 * @Author Lindsey Shaw
 * @Date 2018/9/7
 **/
public class DataMsg {


    private String context;

    private Status status;

    private Object object;



    private DataMsg(Status status,String context) {
        this.status=status;
        this.context=context;
    }

    private DataMsg(Status status,String context,Object object) {
        this.status=status;
        this.context=context;
        this.object=object;
    }


    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "DataMsg{" +
                "context='" + context + '\'' +
                ", status=" + status +
                ", object=" + object +
                '}';
    }

    /**
     * 操作成功
     * @return
     */
    public static DataMsg success(){
        return new DataMsg(Status.SUCCESS,"操作成功");
    }

    /**
     * 操作成功返回消息
     * @param context
     * @return
     */
    public static DataMsg success(String context){
        return new DataMsg(Status.SUCCESS,context);
    }
    /**
     * 操作成功返回数据
     * @param object
     * @return
     */
    public static DataMsg success(Object object){
        return new DataMsg(Status.SUCCESS,"操作成功",object);
    }

    /**
     * 操作成功返回数据和消息
     * @param context
     * @param object
     * @return
     */
    public static DataMsg success(String context,Object object){
        return new DataMsg(Status.SUCCESS,context,object);
    }

    /**
     * 操作成功返回多个数据
     * @param args
     * @return
     */
    public static DataMsg success(Object...args){
        return new DataMsg(Status.SUCCESS,"操作成功",args);
    }

    /**
     * 操作成功返回多个数据和消息
     * @param context
     * @param args
     * @return
     */
    public static DataMsg success(String context,Object...args){
        return new DataMsg(Status.SUCCESS,context,args);
    }


    /**
     * 操作失败返回消息
     * @param context
     * @return
     */
    public static DataMsg error(String context){
        return new DataMsg(Status.ERROR,context);
    }

    /**
     * 操作失败返回消息和对象
     * @param context
     * @param object
     * @return
     */
    public static DataMsg error(String context,Object object){
        return new DataMsg(Status.ERROR,context,object);
    }
}
