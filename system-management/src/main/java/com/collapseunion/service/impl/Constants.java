package com.collapseunion.service.impl;

/**
 * @author CloudSen
 */
class Constants {

    static final String FINDING_BY_ID = "> Finding test jpa entity via uuid:{}";
    static final String FINDING_BY_CREATE_DATE = "> Finding test jpa entity via create date:{}";
    static final String FINDING_ALL = "> Finding all test entities";
    static final String FINDING_BY_CONDITION = "> Finding test entities via condition:{}";
    static final String CREATING_TEST_ENTITY = "> Creating test entity: {}";
    static final String DEL_TEST_ENTITY = "> Deleting test entity via uuid:{}";
    static final String UPDATING_TEST_ENTITY = "> Updating test entity uuid:{}";
    static final String TEST_ENTITY_EXISTS = "存在同名的测试实体类，新增失败！";
    static final String TEST_ENTITY_NOT_EXISTS = "测试实体类不存在，更新失败！";
}
