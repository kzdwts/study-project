package top.kangyong.sentinelnew.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * controller
 *
 * @author Kang Yong
 * @date 2023/1/9
 * @since 1.0.0
 */
@RestController
@Slf4j
public class HelloController {

    private static final String RESOURCE_NAME = "hello";
    private static final String USER_RESOURCE_NAME = "user";
    private static final String DEGRADE_RESOURCE_NAME = "degrade";

    @RequestMapping("/hello")
    public String hello() {
        Entry entry = null;

        try {
            // sentinel针对资源进行限制
            entry = SphU.entry(RESOURCE_NAME);
            // 被保护的业务逻辑
            String str = "hello world";
            log.info("=========={}==========", str);
            return str;
        } catch (BlockException el) {
            // 资源访问阻止，被限流或降级
            log.info("block!");
            return "被限流了";
        } catch (Exception e) {
            // 若需要配置降级规则，需要通过这种方式记录业务异常
            Tracer.traceEntry(e, entry);
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }

        return null;
    }


    @PostConstruct // spring的初始化方法
    private static void initFlowRules() {
        // 流控规则
        List<FlowRule> rules = new ArrayList<>();

        // 流控
        FlowRule rule = new FlowRule();
        // 设置受保护的资源
        rule.setResource(RESOURCE_NAME);
        // 设置流控规则 QPS(每秒的访问数)
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);

        // 设置受保护的资源阈值 (每秒的访问数为1)
        // set limit QPS to 20
        rule.setCount(1);
        rules.add(rule);

        // 加载配置好的规则
        FlowRuleManager.loadRules(rules);
    }

}
