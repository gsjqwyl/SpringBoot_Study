package com.sprintboot.Controller;

import com.sprintboot.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/db")
public class DataBaseController {

    @Autowired
    private JdbcTemplate template;

    @RequestMapping("/insert")
    public String insert() {
        String sql = "insert into user(name, mobile, age) value (?,?,?)";
        int result = template.update(sql, new String[]{"ObjectMan", "1770000000", "18"});
        if (result > 0) {
            return "success!!!";
        }
        return "fail";
    }


}
