package top.kangyong.study.mthread.holder;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import top.kangyong.study.mthread.domain.User;
import top.kangyong.study.mthread.mapper.UserMapper;

import java.util.List;

/**
 * 生日祝福
 *
 * @author Kang Yong
 * @date 2023/3/31
 * @since 1.0.0
 */
@Component
public class BirthdayCongratulationHolder implements Runnable {

    @Autowired
    private UserMapper userMapper;

    private Integer begin;
    private Integer end;

    public Integer getBegin() {
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }


    public BirthdayCongratulationHolder() {
    }

    public BirthdayCongratulationHolder(Integer begin, Integer end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run() {
        System.out.println("begin = " + begin + "&end = " + end);

        // 查询
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("TO_DAYS(birthday)", "TO_DAYS(NOW())");
        qw.lambda().between(User::getId, begin, end);
        List<User> userList = this.userMapper.selectList(qw);
        if (CollectionUtils.isEmpty(userList)) {
            System.out.println("未查询到今天生日的用户，退出");
            return;
        }

        // 发送生日祝福
        for (User user : userList) {
            System.out.println(Thread.currentThread().getName() + "清晨，愿我的祝福，如一抹灿烂的阳光，在你的眼里流淌；夜晚，愿我的祝福，是一缕皎洁的月光，在" + user.getName() + "你的心里荡漾！生日快乐！");
        }

    }
}
