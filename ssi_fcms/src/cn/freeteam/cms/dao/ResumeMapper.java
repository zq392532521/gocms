package cn.freeteam.cms.dao;

import cn.freeteam.cms.model.Resume;
import cn.freeteam.cms.model.ResumeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResumeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freecms_resume
     *
     * @mbggenerated Wed Jul 10 17:35:22 CST 2013
     */
    int countByExample(ResumeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freecms_resume
     *
     * @mbggenerated Wed Jul 10 17:35:22 CST 2013
     */
    int deleteByExample(ResumeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freecms_resume
     *
     * @mbggenerated Wed Jul 10 17:35:22 CST 2013
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freecms_resume
     *
     * @mbggenerated Wed Jul 10 17:35:22 CST 2013
     */
    int insert(Resume record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freecms_resume
     *
     * @mbggenerated Wed Jul 10 17:35:22 CST 2013
     */
    int insertSelective(Resume record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freecms_resume
     *
     * @mbggenerated Wed Jul 10 17:35:22 CST 2013
     */
    List<Resume> selectByExample(ResumeExample example);
    List<Resume> selectPageByExample(ResumeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freecms_resume
     *
     * @mbggenerated Wed Jul 10 17:35:22 CST 2013
     */
    Resume selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freecms_resume
     *
     * @mbggenerated Wed Jul 10 17:35:22 CST 2013
     */
    int updateByExampleSelective(@Param("record") Resume record, @Param("example") ResumeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freecms_resume
     *
     * @mbggenerated Wed Jul 10 17:35:22 CST 2013
     */
    int updateByExample(@Param("record") Resume record, @Param("example") ResumeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freecms_resume
     *
     * @mbggenerated Wed Jul 10 17:35:22 CST 2013
     */
    int updateByPrimaryKeySelective(Resume record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freecms_resume
     *
     * @mbggenerated Wed Jul 10 17:35:22 CST 2013
     */
    int updateByPrimaryKey(Resume record);
}