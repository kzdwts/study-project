package com.bobo.flow;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.repository.Deployment;
import org.flowable.task.api.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

@SpringBootTest
public class StudySpringbootFlowable01ApplicationTests {

    @Autowired
    private ProcessEngine processEngine;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RuntimeService runtimeService;

    /**
     * 通过手动方式来部署 Deploy
     *
     * @author Kang Yong
     * @date 2022/4/9
     */
    @Test
    public void testDeploy() {
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("请假流程.bpmn20.xml")
                .name("holiday")
                .deploy();
        System.out.println("deploy.getId() = " + deploy.getId());
        System.out.println("deploy.getName() = " + deploy.getName());
        System.out.println("deploy.getCategory() = " + deploy.getCategory());
    }

    /**
     * 启动流程 start process
     *
     * @author Kang Yong
     * @date 2022/4/9
     */
    @Test
    public void testStartFlow() {
        Map<String, Object> map = new HashMap<>();
        map.put("assignee0", "zhangsan");
        map.put("assignee1", "zhangsan");

        // 填写上边打印的id
        runtimeService.startProcessInstanceById("TODO id", map);
    }

    /**
     * 处理流程 complete Task
     *
     * @author Kang Yong
     * @date 2022/4/9
     */
    @Test
    public void testCompleteTask() {
        Task task = taskService.createTaskQuery()
                .processInstanceId("这里要填啥")
                .taskAssignee("zhangsan")
                .singleResult();

        if (task != null) {
            taskService.complete(task.getId());
            System.out.println("complete ...");
        }

    }

}
