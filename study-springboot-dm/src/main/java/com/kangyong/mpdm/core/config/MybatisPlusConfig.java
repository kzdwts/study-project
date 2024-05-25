package com.kangyong.mpdm.core.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis-plus分页插件配置
 *
 * @author Kang Yong
 * @date 2024/5/26
 * @since 1.0.0
 */
@Configuration
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        //1 创建MP拦截器对象
        MybatisPlusInterceptor mpInterceptor = new MybatisPlusInterceptor();
        //2 添加分页拦截器
        mpInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        //注意:不同的数据库在开启分页功能的时候,需要设置成对应的数据库类型,默认支持mysql （个别数据库的方言不太一样）
        mpInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.DM));//达梦
        return mpInterceptor;
    }

}
