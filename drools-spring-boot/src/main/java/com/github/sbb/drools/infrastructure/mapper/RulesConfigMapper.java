package com.github.sbb.drools.infrastructure.mapper;

import com.github.sbb.drools.infrastructure.entity.RulesConfig;
import com.github.sbb.drools.infrastructure.entity.RulesConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RulesConfigMapper {

  long countByExample(RulesConfigExample example);

  int deleteByExample(RulesConfigExample example);

  int deleteByPrimaryKey(Integer id);

  int insert(RulesConfig record);

  int insertSelective(RulesConfig record);

  List<RulesConfig> selectByExample(RulesConfigExample example);

  RulesConfig selectByPrimaryKey(Integer id);

  int updateByExampleSelective(@Param("record") RulesConfig record, @Param("example") RulesConfigExample example);

  int updateByExample(@Param("record") RulesConfig record, @Param("example") RulesConfigExample example);

  int updateByPrimaryKeySelective(RulesConfig record);

  int updateByPrimaryKey(RulesConfig record);
}