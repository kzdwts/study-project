package top.kangyong.study.mthread.holder;

import lombok.Data;

/**
 * 生日祝福
 *
 * @author Kang Yong
 * @date 2023/3/31
 * @since 1.0.0
 */
@Data
public class BirthdayCongratulationHolder implements Runnable {

    private Integer begin;
    private Integer pageSize;

    public BirthdayCongratulationHolder() {
    }

    public BirthdayCongratulationHolder(Integer begin, Integer pageSize) {
        this.begin = begin;
        this.pageSize = pageSize;
    }

    @Override
    public void run() {
        System.out.println("begin = " + begin);
        System.out.println("pageSize = " + pageSize);
    }
}
