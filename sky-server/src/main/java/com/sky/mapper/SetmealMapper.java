package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.enumeration.OperationType;
import com.sky.vo.SetmealVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SetmealMapper {

    /**
     * 根据分类id查询套餐的数量
     * @param id
     * @return
     */
    @Select("select count(id) from setmeal where category_id = #{categoryId}")
    Integer countByCategoryId(Integer id);

    @AutoFill(value = OperationType.INSERT)

    void add(Setmeal setmeal);

    Page<SetmealVO> pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    @AutoFill(value = OperationType.UPDATE)
    void update(Setmeal setmeal);

    @Select("select * from setmeal where id=#{id}")
    Setmeal findById(Long id);

    @Update("update setmeal set status=#{status} where id=#{id}")
    void startOrStopSetmeal(Integer status, Long id);

    void deleteBatch(List<Long> ids);
}
