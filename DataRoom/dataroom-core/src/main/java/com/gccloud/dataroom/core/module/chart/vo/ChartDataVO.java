/*
 * Copyright 2023 http://gcpaas.gccloud.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gccloud.dataroom.core.module.chart.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

/**
 * 图表响应数据
 * @author liuchengbiao
 * @version 1.0
 * @date 2022/8/8 15:11
 */
@Data
public class ChartDataVO {

    /**
     * 是否成功
     */
    private Boolean success = Boolean.FALSE;

    /**
     * 是否前端执行
     */
    private Boolean executionByFrontend = Boolean.FALSE;

    /**
     * 返回的数据
     */
    @ApiModelProperty(notes = "返回的数据")
    private Object data;

    /**
     * 总记录数，在table类型的图表开启分页时使用
     */
    @ApiModelProperty(notes = "总记录数")
    private Integer totalCount = 0;

    /**
     * 总页数，在table类型的图表开启分页时使用
     */
    @ApiModelProperty(notes = "总页数")
    private Integer totalPage = 0;

    @ApiModelProperty(notes = "执行的SQL")
    private String sql;

    @ApiModelProperty(notes = "列属性")
    private Map<String, ColumnData> columnData;

    @Data
    public static class ColumnData {

        @ApiModelProperty(notes = "字段类型")
        private String type;

        @ApiModelProperty(notes = "表名")
        private String tableName;

        @ApiModelProperty(notes = "字段名")
        private String originalColumn;

        @ApiModelProperty(notes = "聚合函数")
        private String aggregate;

        @ApiModelProperty(notes = "别名")
        private String alias;

        @ApiModelProperty(notes = "备注")
        private String remark;

    }

}