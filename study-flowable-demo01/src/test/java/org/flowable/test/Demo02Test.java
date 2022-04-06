package org.flowable.test;

import org.flowable.engine.*;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 请假流程测试
 *
 * @author Kang Yong
 * @date 2022/4/5
 * @since 1.0.0
 */
public class Demo02Test {

    /**
     * 部署流程
     * <p>
     * 请假流程
     *
     * @author Kang Yong
     * @date 2022/4/1
     */
    @Test
    public void testDeploy() {
        // 配置数据库相关信息，获取ProcessEngineConfiguration
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://192.168.100.134:3306/flowable-learn01?useSSL=false&serverTimezone=UTC&nullCatalogMeansCurrent=true&characterEncoding=utf-8")
                .setJdbcUsername("root")
                .setJdbcPassword("1024KangYong@MySQL")
                .setJdbcDriver("com.mysql.cj.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        // 获取流程引擎对象
        ProcessEngine processEngine = cfg.buildProcessEngine();
        // 部署流程 获取RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment() // 创建Deployment对象
                .addClasspathResource("MyHolidayUI.bpmn20.xml") // 添加流程部署文件
                .name("flowableUI请求流程") // 设置部署流程名称
                .deploy();// 执行部署操作

        System.out.println("deployment.getId()= " + deployment.getId());
        System.out.println("deployment.getName()= " + deployment.getName());
    }

    /**
     * 启动流程实例
     *
     * @author Kang Yong
     * @date 2022/4/1
     */
    @Test
    public void testRunProcess() {
        // 配置数据库相关信息，获取ProcessEngineConfiguration
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://192.168.100.134:3306/flowable-learn01?useSSL=false&serverTimezone=UTC&nullCatalogMeansCurrent=true&characterEncoding=utf-8")
                .setJdbcUsername("root")
                .setJdbcPassword("1024KangYong@MySQL")
                .setJdbcDriver("com.mysql.cj.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        // 获取流程引擎对象
        ProcessEngine processEngine = cfg.buildProcessEngine();

        // 启动流程实例 通过RuntimeService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();
        // 构建流程变量
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("employee", "张三"); // 谁申请请假
        variables.put("nrOfHolidays", 3); // 请几天假
        variables.put("description", "工作累了，想出去玩玩"); // 请假的原因
        // 启动流程实例，第一个参数是流程定义的id
        ProcessInstance processInstance = runtimeService.startProcessInstanceById("MyHolidayUI:1:12504", variables);// 启动流程实例

        System.out.println("流程定义的ID: " + processInstance.getProcessDefinitionId());
        System.out.println("流程实例的ID: " + processInstance.getId());
        System.out.println("当前活动的ID: " + processInstance.getActivityId());

    }


    /**
     * 完成任务
     *
     * @author Kang Yong
     * @date 2022/4/1
     */
    @Test
    public void testCompleteTask() {
        // 配置数据库相关信息，获取ProcessEngineConfiguration
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://192.168.100.134:3306/flowable-learn01?useSSL=false&serverTimezone=UTC&nullCatalogMeansCurrent=true&characterEncoding=utf-8")
                .setJdbcUsername("root")
                .setJdbcPassword("1024KangYong@MySQL")
                .setJdbcDriver("com.mysql.cj.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        // 获取流程引擎对象
        ProcessEngine processEngine = cfg.buildProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        Task task = taskService.createTaskQuery()
                .processDefinitionKey("MyHolidayUI")
                .taskAssignee("wanglili")
                .singleResult();

        // 添加流程变量
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("approved", false); // 拒绝请假
        // 完成任务
        taskService.complete(task.getId(), variables);
    }

}
