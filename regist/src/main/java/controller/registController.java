package controller;

import dao.UserMapper;
import model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import net.sf.json.JSONObject;

@Controller
public class registController {
    private static SqlSessionFactory sqlSessionFactory;
    String resource = "mybatis-config.xml";
    Reader reader = null;
    private UserMapper userMapper;

    @RequestMapping(value="/checkUserName")
    public String checkUserName(HttpServletRequest request, HttpServletResponse response) throws IOException{

  /*      request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding( "utf-8" );*/
        String username=(String)request.getParameter("depart");
        //检验用户名是否存在
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = new User();
            user.setUsername(username);
            int num = session.selectOne("dao.UserMapper.checkuser", user);
            System.out.println(num);
            session.commit();
            boolean flag=false;
            if(num>0){
                flag=true;
            }
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("flag", flag);
            String json = JSONObject.fromObject(map).toString();
            //将数据返回
            response.setCharacterEncoding("UTF-8");
            response.flushBuffer();
            response.getWriter().write(json);
            response.getWriter().flush();
            response.getWriter().close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();


        }

        //用户名是否存在的标志

        //将数据转换成json

        return null;
    }

    @RequestMapping(value = "/adduser")
    public ModelAndView success(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SqlSession session = sqlSessionFactory.openSession();
        try {

            User user = new User();
            user.setUsername(username);
            user.setPassword(password);

            int result = session.insert("dao.UserMapper.insert", user);
            session.commit();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();


        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", username);
        map.put("password", password);
        return new ModelAndView("successed", map);
    }
}