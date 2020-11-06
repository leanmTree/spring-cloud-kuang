package com.lemon.canal.canal;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xpand.starter.canal.annotation.CanalEventListener;
import com.xpand.starter.canal.annotation.InsertListenPoint;
import com.xpand.starter.canal.annotation.ListenPoint;

/**
 * @author hengtao.wu
 * @Date 2020/11/5 16:25
 **/
@CanalEventListener
public class Canalconfig {
    /**
     * @UpdateListenPoint :注解是监控更新的
     * @DeleteListenPoint :注解是监控删除的
     * @param eventType ：时间类型
     * @param rowData： 修改的数据对象，可以通过该对象获取修改前和修改后的数据
     */
    @InsertListenPoint
    public void insertLs(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        for (CanalEntry.Column column : rowData.getAfterColumnsList()) {
            System.out.println("列明：" + column.getName() + "          数据：" + column.getValue());
        }
    }
    /**
     * 自定义监控类型
     * @param eventType
     * @param rowData
     */
    @ListenPoint(
            eventType = {CanalEntry.EventType.DELETE,CanalEntry.EventType.UPDATE},  //指定监控的事件类型
            schema = {"test"},                                                      //指定数据库
            table = {"test1"},                                                    //指定表
            destination = "example"                                                 //指定canal实例
    )
    public void myself(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        System.out.println("监听到了");
    }
}