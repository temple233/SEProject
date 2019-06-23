package com.example.spring;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.spring.entities.*;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class HelloController {
    User user;
    dbHandler dbH;
    @RequestMapping(value = "/looooog")
    public String hllo() {
            return "fsda";
    }
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    @RequestMapping(value = "/login",method={RequestMethod.POST,RequestMethod.GET},produces = "application/json;charset=UTF-8")
    public String hello(@RequestBody Map o) {
        ObjectMapper mapper = new ObjectMapper();

        String name = (String) o.get("name");
        String pass = (String) o.get("password");
	    user = new User(name, pass);
        dbH = new dbHandler();
        if(dbH.login(user)){
            o.put("result", "True");
        }
        else{
            o.put("result", "False");
        }
        String resultString = "";
        try {
            resultString = mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return resultString;
        //return name + ";" + sex;
        /*Connection con;
        String driver="com.mysql.jdbc.Driver";
        //这里我的数据库是qcl
        String url="jdbc:mysql://120.78.80.77:3306/se";
        String user="se";
        String password="se";
        String name="";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }
            Statement statement = con.createStatement();
            String sql = "select * from admin;";//我的表格叫home
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                name = resultSet.getString("name");
                System.out.println("姓名：" + name);
            }
            resultSet.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");

        } catch (SQLException e) {
            System.out.println("数据库连接失败");
        }

        return name;//"Hello Spring Boot!";*/
       // return "Hello Spring Boot!";
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    @RequestMapping(value = "/stocks",method={RequestMethod.POST,RequestMethod.GET},produces = "application/json;charset=UTF-8")
    public String stock() {
        String resultString = "[[\"1112\", \"22222222\",\"123\",\"123\",\"123\",\"333\"],\n" +
                "[\"111111\", \"22222222\",\"123\",\"123\",\"123\",\"333\"],\n" +
                "[\"111111\", \"22222222\",\"123\",\"123\",\"123\",\"333\"],\n" +
                "[\"111111\", \"22222222\",\"123\",\"123\",\"123\",\"333\"],\n" +
                "[\"111111\", \"22222222\",\"123\",\"123\",\"123\",\"333\"]]";
        ArrayList<Stock> S=dbH.getStockData();
        String r="[";
        for(int i=0;i<S.size();i++){
            r+="[\""+S.get(i).id+"\",\""+S.get(i).name+"\",\""+S.get(i).newPrice+"\",\""+S.get(i).mode+"\",\""+S.get(i).newAmount+"\",\""+S.get(i).downLimit+"\"]";
            if(i!=S.size()-1)r+=",\n";
        }
        r+="]";
        //System.out.println(r);
        //System.out.println(resultString);

        return r;

    }
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    @RequestMapping(value = "/changestock",method={RequestMethod.POST,RequestMethod.GET},produces = "application/json;charset=UTF-8")
    public String Set_stock(@RequestBody Map o) {
        String stock_id=(String) o.get("stock_id");
        int id_stock=Integer.parseInt(stock_id);
        String limitup=(String)o.get("limitUp");
        double Limup=Double.parseDouble(limitup);
        String limitdown=(String)o.get("limitDown");
        double Limdown=Double.parseDouble(limitdown);
        String mode=(String)o.get("isStop");
        Boolean b;
        if(mode.equals("on"))b=true;
        else b=false;
        dbH.setDownLimit(Limdown,id_stock);
        dbH.setUpLimit(Limup,id_stock);
        dbH.setMode(b,id_stock);
        String resultString = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            resultString = mapper.writeValueAsString(o);
            //System.out.println(resultString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return resultString;
    }
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    @RequestMapping(value = "/modifypwd",method={RequestMethod.POST,RequestMethod.GET},produces = "application/json;charset=UTF-8")
    public String Passwor(@RequestBody Map o) {
        String password=(String)o.get("new");
        user.password=password;
        dbH.changePassword(user);
        String resultString = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            resultString = mapper.writeValueAsString(o);
            System.out.println(resultString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return resultString;
    }
}