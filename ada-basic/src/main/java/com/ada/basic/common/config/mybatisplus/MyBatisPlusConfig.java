package com.ada.basic.common.config.mybatisplus;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: mybatis-plus配置相关<br>
 * Description: <br>
 * Author: XiaChong<br>
 * Mail: summerpunch@163.com<br>
 * Date: 2019/3/6 10:02<br>
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.ada.basic.mapper*")
public class MyBatisPlusConfig {

    /**
     * Title: mybatis-plus分页插件<br>
     * <p>
     * Description: 文档：http://mp.baomidou.com
     * 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
     * paginationInterceptor.setOverflow(false);
     * 设置最大单页限制数量，默认 500 条，-1 不受限制
     * paginationInterceptor.setLimit(500);
     * 开启 count 的 join 优化,只针对部分 left join
     *
     * <br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2019/3/6 10:02<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
    }

    /**
     * Title: 攻击 SQL 阻断解析器、加入解析链<br>
     * Description: <br>
     * Author: XiaChong<br>
     * Mail: summerpunch@163.com<br>
     * Date: 2020/6/12 16:55<br>
     */
    @Bean
    public SqlExplainInterceptor sqlExplainInterceptor() {
        SqlExplainInterceptor sqlExplainInterceptor = new SqlExplainInterceptor();
        List<ISqlParser> sqlParserList = new ArrayList<>();
        sqlParserList.add(new BlockAttackSqlParser());
        sqlExplainInterceptor.setSqlParserList(sqlParserList);
        return sqlExplainInterceptor;
    }
}
