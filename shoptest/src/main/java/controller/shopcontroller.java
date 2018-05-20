package controller;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import model.shoplist;

@Controller
@RequestMapping("/home")
public class shopcontroller {

    private static SqlSessionFactory sqlSessionFactory;
    String resource = "configration.xml";
    Reader reader = null;
    @RequestMapping("/index")
    public String index(@ModelAttribute shoplist shoplist, ModelMap model){
        try {
            reader = Resources.getResourceAsReader(resource);
             sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SqlSession session = sqlSessionFactory.openSession();
        try {

            List shoplists = session.selectList("mapper.shoplistMapper.shoplist");
            model.addAttribute("shoplists", shoplists);
            model.addAttribute("shopname", shoplist.getShopname());
            model.addAttribute("prce", shoplist.getPrce());
            model.addAttribute("img", shoplist.getImg());



        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();


        }

        return "index";

    }
}
