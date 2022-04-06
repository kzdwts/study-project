package com.bobo.flowable.test;

import org.flowable.engine.*;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * cehsi
 *
 * @author Kang Yong
 * @date 2022/4/1
 * @since 1.0.0
 */
public class Demo01Test {


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
                .setJdbcUrl("jdbc:mysql://192.168.100.134:3306/flowable-learn01?serverTimezone=UTC")
                .setJdbcUsername("root")
                .setJdbcPassword("1024KangYong@MySQL")
                .setJdbcDriver("com.mysql.cj.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        // 获取流程引擎对象
        ProcessEngine processEngine = cfg.buildProcessEngine();
        // 部署流程 获取RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment() // 创建Deployment对象
                .addClasspathResource("holiday-request.bpmn20.xml") // 添加流程部署文件
                .name("请求流程") // 设置部署流程名称
                .deploy();// 执行部署操作

        System.out.println("deployment.getId()= " + deployment.getId());
        System.out.println("deployment.getName()= " + deployment.getName());
    }

    /**
     * 查看流程定义
     *
     * @author Kang Yong
     * @date 2022/4/1
     */
    @Test
    public void testDeployQuery() {
        // 配置数据库相关信息，获取ProcessEngineConfiguration
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://192.168.100.134:3306/flowable-learn01?serverTimezone=UTC")
                .setJdbcUsername("root")
                .setJdbcPassword("1024KangYong@MySQL")
                .setJdbcDriver("com.mysql.cj.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        // 获取流程引擎对象
        ProcessEngine processEngine = cfg.buildProcessEngine();
        // 部署流程 获取RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 获取流程定义对象
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .deploymentId("2501")
                .singleResult();

        System.out.println("processDefinition.getId() = " + processDefinition.getId());
        System.out.println("processDefinition.getName() = " + processDefinition.getName());
        System.out.println("processDefinition.getDeploymentId() = " + processDefinition.getDeploymentId());
        System.out.println("processDefinition.getDescription() = " + processDefinition.getDescription());

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
                .setJdbcUrl("jdbc:mysql://192.168.100.134:3306/flowable-learn01?serverTimezone=UTC")
                .setJdbcUsername("root")
                .setJdbcPassword("1024KangYong@MySQL")
                .setJdbcDriver("com.mysql.cj.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        // 获取流程引擎对象
        ProcessEngine processEngine = cfg.buildProcessEngine();
        // 部署流程 获取RepositoryService对象
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 启动流程实例 通过RuntimeService对象
        RuntimeService runtimeService = processEngine.getRuntimeService();
        // 构建流程变量
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("employee", "张三"); // 谁申请请假
        variables.put("nrOfHolidays", 3); // 请几天假
        variables.put("description", "工作累了，想出去玩玩"); // 请假的原因
        // 启动流程实例，第一个参数是流程定义的id
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holidayRequest", variables);// 启动流程实例

        System.out.println("流程定义的ID: " + processInstance.getProcessDefinitionId());
        System.out.println("流程实例的ID: " + processInstance.getId());
        System.out.println("当前活动的ID: " + processInstance.getActivityId());

    }

    /**
     * 查看任务
     *
     * @author Kang Yong
     * @date 2022/4/1
     */
    @Test
    public void testQueryTask() {
        // 配置数据库相关信息，获取ProcessEngineConfiguration
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://192.168.100.134:3306/flowable-learn01?serverTimezone=UTC")
                .setJdbcUsername("root")
                .setJdbcPassword("1024KangYong@MySQL")
                .setJdbcDriver("com.mysql.cj.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        // 获取流程引擎对象
        ProcessEngine processEngine = cfg.buildProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        List<Task> list = taskService.createTaskQuery()
                .processDefinitionKey("holidayRequestNew")
                .taskAssignee("lisi")
                .list();

        for (Task task : list) {
            System.out.println("task.getProcessDefinitionId() = " + task.getProcessDefinitionId());
            System.out.println("task.getId() = " + task.getId());
            System.out.println("task.getAssignee() = " + task.getAssignee());
            System.out.println("task.getName() = " + task.getName());
        }
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
                .setJdbcUrl("jdbc:mysql://192.168.100.134:3306/flowable-learn01?serverTimezone=UTC")
                .setJdbcUsername("root")
                .setJdbcPassword("1024KangYong@MySQL")
                .setJdbcDriver("com.mysql.cj.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        // 获取流程引擎对象
        ProcessEngine processEngine = cfg.buildProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        Task task = taskService.createTaskQuery()
                .processDefinitionKey("holidayRequestNew")
                .taskAssignee("lisi")
                .singleResult();

        // 添加流程变量
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("approved", false); // 拒绝请假
        // 完成任务
        taskService.complete(task.getId(), variables);
    }

    /**
     * 删除流程
     *
     * @author Kang Yong
     * @date 2022/4/1
     */
    @Test
    public void testDeleteProcess() {
        // 配置数据库相关信息，获取ProcessEngineConfiguration
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://192.168.100.134:3306/flowable-learn01?serverTimezone=UTC")
                .setJdbcUsername("root")
                .setJdbcPassword("1024KangYong@MySQL")
                .setJdbcDriver("com.mysql.cj.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        // 获取流程引擎对象
        ProcessEngine processEngine = cfg.buildProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();

        // 删除流程定义，如果该流程定义已经有了流程实例启动则删除时报错
        // repositoryService.deleteDeployment("1");
        // 设置为TRUE 级联删除流程定义，及时流程有实例启动，也可以删除，设置为false 非级联删除操作。
        repositoryService.deleteDeployment("2501", true);
    }

    /**
     * 查看历史
     */
    @Test
    public void testQueryHistory() {
        // 配置数据库相关信息 获取 ProcessEngineConfiguration
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://localhost:3306/flowable-learn1?serverTimezone=UTC&nullCatalogMeansCurrent=true")
                .setJdbcUsername("root")
                .setJdbcPassword("123456")
                .setJdbcDriver("com.mysql.cj.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        // 获取流程引擎对象
        ProcessEngine processEngine = cfg.buildProcessEngine();
        HistoryService historyService = processEngine.getHistoryService();
        List<HistoricActivityInstance> list = historyService.createHistoricActivityInstanceQuery()
                .processDefinitionId("holidayRequestNew:1:10003")
                .finished()
                .orderByHistoricActivityInstanceEndTime().asc()
                .list();
        for (HistoricActivityInstance historicActivityInstance : list) {
            System.out.println(historicActivityInstance.getActivityId() + " took "
                    + historicActivityInstance.getDurationInMillis() + " milliseconds");
        }

    }

}
