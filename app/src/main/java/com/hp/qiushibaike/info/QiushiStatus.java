package com.hp.qiushibaike.info;

/**
 * Created by zhangjuh on 2016/2/29.
 */
public enum QiushiStatus {
    /*
     * 错误和未知的糗事状态
     */
    UNKNOWN,
    /*
     * 糗事通过
     */
    PUBLISH,
    /*
     * 糗事正在审核
     */
    ACTIVE,
    /*
     * 糗事未通过
     */
    BONDED
}
