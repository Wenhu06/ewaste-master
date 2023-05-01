package com.group.ewaste.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageInfo  implements Serializable {
    private static final long serialVersionUID = 1L;
    //页码
    private Long page;
    //限制条数
    private Long limit;

    private Set<String> sort_order;

    //总数
    private Long total;
    //结果集
    private List rows;

}
