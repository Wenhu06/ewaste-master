package com.group.ewaste.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("feedback")
@Data
public class FeedBack {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String username;
    private String email;
    private String content;
    private Date createTime;
}
