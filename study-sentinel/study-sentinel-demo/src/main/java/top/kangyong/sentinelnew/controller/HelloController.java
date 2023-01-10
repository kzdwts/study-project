package top.kangyong.sentinelnew.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kangyong.sentinelnew.pojo.User;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * controller
 * <p>
 * 流控规则：一般用在服务提供方
 * 降级规则：一般用在服务消费方
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

        // 通过@SentinelResource来定义资源，并配置降级和流控的处理方法
        FlowRule rule2 = new FlowRule();
        rule2.setResource(USER_RESOURCE_NAME);
        rule2.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule2.setCount(1);
        rules.add(rule2);

        // 加载配置好的规则
        FlowRuleManager.loadRules(rules);
    }

    /**
     * `@SentinelResource` 改善接口中资源定义和被流控降级后的处理方法
     * <p>
     * 怎么使用：
     * 1、添加依赖 <artifactId>sentinel-annotation-aspectj</artifactId>
     * 2、配置bean SentinelResourceAspect
     * value 定义资源
     * blockHandler 设置 流控降级后的处理方法（默认该方法必须声明在同一个类中）
     * 如果不想在同一个类中，设置blockHandlerClass 方法必须是静态的
     * fallback 当接口出现了异常，就可以交给发力了back指定的方法进行处理
     * <p>
     * blockHandler 如果和 fallback 同时指定了，则 blockHandler 优先级更高
     * <p>
     * exceptionsToIgnore 排除哪些异常不处理
     *
     * @param id {@link String}
     * @return {@link User}
     * @author Kang Yong
     * @date 2023/1/10
     */
    @RequestMapping("/user")
    @SentinelResource(value = USER_RESOURCE_NAME,
            fallback = "fallbackForGetUser",
            /*blockHandlerClass = "",*/
            blockHandler = "blockHandlerForGetUser")
    public User getUser(String id) {
        int i = 1 / 0;
        return new User("毛凯悦");
    }

    public User fallbackForGetUser(String id, Throwable e) {
        e.printStackTrace();
        return new User("出现异常");
    }

    /**
     * 功能: TODO.
     * <p>
     * 注意：
     * 1、一定要public
     * 2、返回值一定要和原方法保证一致，包含原方法的参数
     * 3、可以在参数最后添加BlockException 可以区分是什么规则的处理方法
     *
     * @param id {@link String}
     * @param ex {@link BlockException}
     * @return {@link User}
     * @author Kang Yong
     * @date 2023/1/10
     */
    public User blockHandlerForGetUser(String id, BlockException ex) {
        ex.printStackTrace();
        return new User("流控！！！");
    }


    @PostConstruct
    public void initDegradeRule() {
        // 降级规则 异常
        List<DegradeRule> degradeRules = new ArrayList<>();
        DegradeRule degradeRule = new DegradeRule();
        degradeRule.setResource(DEGRADE_RESOURCE_NAME);
        // 设置规则侧率：异常数
        degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        // 异常数： 2
        degradeRule.setCount(2);
        // 出发熔断最小请求数： 2
        degradeRule.setMinRequestAmount(2);
        // 统计市场： 单位：ms 1min
        degradeRule.setStatIntervalMs(60 * 1000);
        //
        degradeRule.setTimeWindow(10);

        // 一分钟内：执行了2次，出现了2次异常，触发熔断

        // 熔断持续时长： 单位：s
        // 一旦触发了熔断，再次请求对应的接口就会直接调用降级方法
        // 10s过了后--半开状态：恢复接口请求调用，如果第一次请求就异常，再次熔断，不会再根据设置的条件进行判定
        degradeRules.add(degradeRule);
        DegradeRuleManager.loadRules(degradeRules);

    }

    @RequestMapping("/degrade")
    @SentinelResource(value = DEGRADE_RESOURCE_NAME,
            entryType = EntryType.IN,
            blockHandler = "blockHandlerForFb"
    )
    public User degrade(String id) throws InterruptedException {
        // 异常数\比例
        throw new RuntimeException("异常");
    }

    public User blockHandlerForFb(String id, BlockException e) {
        return new User("熔断降级方法");
    }

}
