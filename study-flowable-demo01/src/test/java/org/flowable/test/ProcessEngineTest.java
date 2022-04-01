package org.flowable.test;


import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.junit.Test;

/**
 * test
 *
 * @author Kang Yong
 * @date 2022/4/1
 * @since 1.0.0
 */
public class ProcessEngineTest {

    /**
     * 初始化**ProcessEngine**流程引擎实例
     *
     * @author Kang Yong
     * @date 2022/4/1
     */
    @Test
    public void processEngine01() {
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://192.168.100.134:3306/flowable-learn01?useSSL=false&serverTimezone=UTC&nullCatalogMeansCurrent=true")
                .setJdbcUsername("root")
                .setJdbcPassword("1024KangYong@MySQL")
                .setJdbcDriver("com.mysql.cj.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        ProcessEngine processEngine = cfg.buildProcessEngine();
        System.out.println("===SUCCESS===");
    }
}
