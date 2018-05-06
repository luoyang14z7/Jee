package mapper;

import model.shoplist;

import java.util.List;

public interface shoplistMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(shoplist record);

    int insertSelective(shoplist record);

    shoplist selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(shoplist record);

    int updateByPrimaryKey(shoplist record);

    public List<shoplist> shoplist();
}