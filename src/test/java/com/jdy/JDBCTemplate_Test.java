package com.jdy;

import com.jdy.spring2020.bean.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class JDBCTemplate_Test {

    private ApplicationContext ctx = null;
    private JdbcTemplate jdbcTemplate = null;

    {
        ctx = new ClassPathXmlApplicationContext("application.xml");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("template");
    }


    /**
     * 执行 INSERT
     */
    @Test
    public void testInsert() {
        String sql = "INSERT INTO book (`isbn`,`book_name`,`price`) VALUES (?,?,?);";
        jdbcTemplate.update(sql, "ISBN", "ISBN", 100);
    }

    /**
     * 执行UPDATE
     */
    @Test
    public void testUpdate() {
        String sql = "UPDATE book SET book_name = ? WHERE price = ?";
        jdbcTemplate.update(sql,"book01",100);
    }

    /**
     * 执行 DELETE
     */
    @Test
    public void testDelete() {
        String sql = "DELETE from book WHERE book_name = ?";
        jdbcTemplate.update(sql, "book01");
    }

    /**
     * 测试批量更新操作 最后一个参数是 Object[] 的 List 类型：因为修改一条记录需要一个 Object 数组，修改多条记录就需要一个
     * List 来存放多个数组。
     */
    @Test
    public void testBatchUpdate() {
        String sql = "INSERT INTO book(isbn, book_name, price) VALUES(?, ?, ?)";
        List<Object[]> batchArgs = new ArrayList<Object[]>();
        batchArgs.add(new Object[] { "ISBN-006", "book06", "600" });
        batchArgs.add(new Object[] { "ISBN-007", "book07", "700" });
        batchArgs.add(new Object[] { "ISBN-008", "book08", "800" });
        batchArgs.add(new Object[] { "ISBN-009", "book09", "900" });

        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    /**
     * 从数据库中获取一条记录，实际得到对应的一个对象 注意：不是调用 queryForObject(String sql,Class<Employee> requiredType, Object... args) 方法!
     * 而需要调用queryForObject(String sql, RowMapper<Employee> rowMapper, Object... args)
     * 1、其中的 RowMapper 指定如何去映射结果集的行，常用的实现类为 BeanPropertyRowMapper
     * 2、使用SQL中的列的别名完成列名和类的属性名的映射，例如 last_name lastName
     * 3、不支持级联属性。 JdbcTemplate只能作为一个 JDBC 的小工具, 而不是 ORM 框架
     */
    @Test
    public void testQueryForObject() {
        String sql = "SELECT * FROM book WHERE isbn=?";
        RowMapper<Book> rowMapper = new BeanPropertyRowMapper<Book>(Book.class);
        //在将数据装入对象时需要调用set方法。
        Book book = jdbcTemplate.queryForObject(sql, rowMapper, "ISBN-003");
        System.out.println(book);
    }

    /**
     * 一次查询多个对象
     * 注意：调用的不是 queryForList 方法
     */
    @Test
    public void testQueryForList() {
        String sql = "SELECT * FROM book WHERE isbn like ?";
         RowMapper<Book> rowMapper = new BeanPropertyRowMapper<Book>(Book.class);
         List<Book> bookList = jdbcTemplate.query(sql, rowMapper, "%ISBN%");
        /*if (!CollectionUtils.isEmpty(bookList)) {
            bookList.forEach(book -> {
                System.out.println(book);
            });
        }*/
    }

    /**
     * 获取单个列的值或做统计查询
     * 使用 queryForObject(String sql, Class<Long> requiredType)
     */
    @Test
    public void testQueryForCount() {
        String sql = "SELECT count(isbn) FROM book";
        long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);
    }


}
