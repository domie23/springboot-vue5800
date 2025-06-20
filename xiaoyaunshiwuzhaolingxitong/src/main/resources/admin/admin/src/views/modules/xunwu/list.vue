<template>
    <div class="main-content">
        <el-dialog title="审核" :visible.sync="xunwuYesnoTypesVisible">
            <el-form :model="form">
                <input type="hidden" v-model="form.id">
                <el-form-item label="审核" >
                    <el-select v-model="form.xunwuYesnoTypes" placeholder="请选择申请状态">
                        <el-option label="同意" value="2"></el-option>
                        <el-option label="拒绝" value="3"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="审核意见">
                    <el-input type="textarea" v-model="form.xunwuYesnoText" placeholder="审核意见"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="xunwuYesnoTypesVisible = false">取 消</el-button>
                <el-button type="primary" @click="xunwuYesnoTypesShenhe">审 核</el-button>
            </div>
        </el-dialog>
        <!-- 条件查询 -->
        <div v-if="showFlag">
            <el-form :inline="true" :model="searchForm" class="form-content">
                <el-row :gutter="20" class="slt" :style="{justifyContent:contents.searchBoxPosition=='1'?'flex-start':contents.searchBoxPosition=='2'?'center':'flex-end'}">
                         
                     <el-form-item :label="contents.inputTitle == 1 ? '寻物名称' : ''">
                         <el-input prefix-icon="el-icon-search" v-model="searchForm.xunwuName" placeholder="寻物名称" clearable></el-input>
                     </el-form-item>
                         
                    <el-form-item :label="contents.inputTitle == 1 ? '开始时间' : ''">
                        <el-date-picker
                                value-format="yyyy-MM-dd HH:mm:ss"
                                v-model="searchForm.xunwuTimeStartSearch"
                                type="datetime"
                                placeholder="开始时间">
                        </el-date-picker>
                    </el-form-item>
                    <el-form-item :label="contents.inputTitle == 1 ? '' : ''">

                    </el-form-item>
                    <el-form-item :label="contents.inputTitle == 1 ? '结束时间' : ''">
                        <el-date-picker
                                value-format="yyyy-MM-dd HH:mm:ss"
                                v-model="searchForm.xunwuTimeEndSearch"
                                type="datetime"
                                placeholder="结束时间">
                        </el-date-picker>
                    </el-form-item>
         
                     <el-form-item :label="contents.inputTitle == 1 ? '寻物地点' : ''">
                         <el-input prefix-icon="el-icon-search" v-model="searchForm.xunwuAddress" placeholder="寻物地点" clearable></el-input>
                     </el-form-item>
         
                     <el-form-item :label="contents.inputTitle == 1 ? '寻物类型' : ''">
                        <el-select v-model="searchForm.xunwuTypes" placeholder="请选择寻物类型">
                            <el-option label="=-请选择-=" value=""></el-option>
                            <el-option
                               v-for="(item,index) in xunwuTypesSelectSearch"
                               v-bind:key="index"
                               :label="item.indexName"
                               :value="item.codeIndex">
                            <!--lable是要展示的名称-->
                            <!--value是值-->
                            </el-option>
                        </el-select>
                     </el-form-item>

         
                     <el-form-item :label="contents.inputTitle == 1 ? '申请状态' : ''">
                        <el-select v-model="searchForm.xunwuYesnoTypes" placeholder="请选择申请状态">
                            <el-option label="=-请选择-=" value=""></el-option>
                            <el-option
                               v-for="(item,index) in xunwuYesnoTypesSelectSearch"
                               v-bind:key="index"
                               :label="item.indexName"
                               :value="item.codeIndex">
                            <!--lable是要展示的名称-->
                            <!--value是值-->
                            </el-option>
                        </el-select>
                     </el-form-item>

                                                        
                                         
                    <el-form-item :label="contents.inputTitle == 1 ? '用户编号' : ''">
                        <el-input prefix-icon="el-icon-search" v-model="searchForm.yonghuUuidNumber" placeholder="用户编号" clearable></el-input>
                    </el-form-item>
                     
                    <el-form-item :label="contents.inputTitle == 1 ? '用户姓名' : ''">
                        <el-input prefix-icon="el-icon-search" v-model="searchForm.yonghuName" placeholder="用户姓名" clearable></el-input>
                    </el-form-item>
                                                                                                    

                    <el-form-item>
                        <el-button type="success" @click="search()">查询<i class="el-icon-search el-icon--right"/></el-button>
                    </el-form-item>
                </el-row>
                <el-row class="ad" :style="{justifyContent:contents.btnAdAllBoxPosition=='1'?'flex-start':contents.btnAdAllBoxPosition=='2'?'center':'flex-end'}">
                    <el-form-item>
                        <el-button
                                v-if="isAuth('xunwu','新增')"
                                type="success"
                                icon="el-icon-plus"
                                @click="addOrUpdateHandler()"
                        >新增</el-button>
                        &nbsp;
                        <el-button
                                v-if="isAuth('xunwu','删除')"
                                :disabled="dataListSelections.length <= 0"
                                type="danger"
                                icon="el-icon-delete"
                                @click="deleteHandler()"
                        >删除</el-button>
                        &nbsp;
                        <el-button
                                v-if="isAuth('xunwu','报表')"
                                type="success"
                                icon="el-icon-pie-chart"
                                @click="chartDialog()"
                        >报表</el-button>
                        &nbsp;
                        <a style="text-decoration:none" class="el-button el-button--success"
                           v-if="isAuth('xunwu','导入导出')"
                           icon="el-icon-download"
                           href="http://localhost:8080/xiaoyaunshiwuzhaolingxitong/upload/xunwuMuBan.xls"
                        >批量导入寻物启示数据模板</a>
                        &nbsp;
                        <el-upload
                                v-if="isAuth('xunwu','导入导出')"
                                style="display: inline-block"
                                :action="getActionUrl"
                                :on-success="xunwuUploadSuccess"
                                :on-error="xunwuUploadError"
                                :show-file-list = false>
                            <el-button
                                    v-if="isAuth('xunwu','导入导出')"
                                    type="success"
                                    icon="el-icon-upload2"
                            >批量导入寻物启示数据</el-button>
                        </el-upload>
                        &nbsp;
                        <!-- 导出excel -->
                        <download-excel v-if="isAuth('xunwu','导入导出')" style="display: inline-block" class = "export-excel-wrapper" :data = "dataList" :fields = "json_fields" name = "xunwu.xls">
                            <!-- 导出excel -->
                            <el-button
                                    type="success"
                                    icon="el-icon-download"
                            >导出</el-button>
                        </download-excel>
                        &nbsp;
                    </el-form-item>
                </el-row>
            </el-form>
            <div class="table-content">
                <el-table class="tables" :size="contents.tableSize" :show-header="contents.tableShowHeader"
                          :header-row-style="headerRowStyle" :header-cell-style="headerCellStyle"
                          :border="contents.tableBorder"
                          :fit="contents.tableFit"
                          :stripe="contents.tableStripe"
                          :row-style="rowStyle"
                          :cell-style="cellStyle"
                          :style="{width: '100%',fontSize:contents.tableContentFontSize,color:contents.tableContentFontColor}"
                          v-if="isAuth('xunwu','查看')"
                          :data="dataList"
                          v-loading="dataListLoading"
                          @selection-change="selectionChangeHandler">
                    <el-table-column  v-if="contents.tableSelection"
                                      type="selection"
                                      header-align="center"
                                      align="center"
                                      width="50">
                    </el-table-column>
                    <el-table-column label="索引" v-if="contents.tableIndex" type="index" width="50" />
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="yonghuUuidNumber"
                                      header-align="center"
                                      label="用户编号">
                        <template slot-scope="scope">
                            {{scope.row.yonghuUuidNumber}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="yonghuName"
                                      header-align="center"
                                      label="用户姓名">
                        <template slot-scope="scope">
                            {{scope.row.yonghuName}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="yonghuPhone"
                                      header-align="center"
                                      label="用户手机号">
                        <template slot-scope="scope">
                            {{scope.row.yonghuPhone}}
                        </template>
                    </el-table-column>
                    <el-table-column :sortable="contents.tableSortable" :align="contents.tableAlign" prop="yonghuPhoto"
                               header-align="center"
                               width="200"
                               label="用户头像">
                        <template slot-scope="scope">
                            <div v-if="scope.row.yonghuPhoto">
                                <img :src="$base.url+scope.row.yonghuPhoto" width="100" height="100">
                            </div>
                            <div v-else>无图片</div>
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="xunwuName"
                                   header-align="center"
                                   label="寻物名称">
                        <template slot-scope="scope">
                            {{scope.row.xunwuName}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="xunwuUuidNumber"
                                   header-align="center"
                                   label="寻物编号">
                        <template slot-scope="scope">
                            {{scope.row.xunwuUuidNumber}}
                        </template>
                    </el-table-column>
                    <el-table-column :sortable="contents.tableSortable" :align="contents.tableAlign" prop="xunwuPhoto"
                                     header-align="center"
                                     width="200"
                                     label="寻物照片">
                        <template slot-scope="scope">
                            <div v-if="scope.row.xunwuPhoto">
                                <img :src="$base.url+scope.row.xunwuPhoto" width="100" height="100">
                            </div>
                            <div v-else>无图片</div>
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="xunwuTime"
                                   header-align="center"
                                   label="时间">
                        <template slot-scope="scope">
                            {{scope.row.xunwuTime}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="xunwuAddress"
                                   header-align="center"
                                   label="寻物地点">
                        <template slot-scope="scope">
                            {{scope.row.xunwuAddress}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="xunwuTypes"
                                      header-align="center"
                                      label="寻物类型">
                        <template slot-scope="scope">
                            {{scope.row.xunwuValue}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="xunwuYesnoTypes"
                                      header-align="center"
                                      label="申请状态">
                        <template slot-scope="scope">
                            {{scope.row.xunwuYesnoValue}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="xunwuYesnoText"
                                      header-align="center"
                                      label="审核意见">
                        <template slot-scope="scope">
                            <span v-if="scope.row.xunwuYesnoText != null &&scope.row.xunwuYesnoText.length>10">
                                {{scope.row.xunwuYesnoText.slice(0,10)}}...
                            </span>
                            <span v-else>
                                {{scope.row.xunwuYesnoText}}
                            </span>
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="xunwuShenheTime"
                                   header-align="center"
                                   label="审核时间">
                        <template slot-scope="scope">
                            {{scope.row.xunwuShenheTime}}
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="shangxiaTypes"
                                      header-align="center"
                                      label="是否上架">
                        <template slot-scope="scope">
                            {{scope.row.shangxiaValue}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="insertTime"
                                   header-align="center"
                                   label="录入时间">
                        <template slot-scope="scope">
                            {{scope.row.insertTime}}
                        </template>
                    </el-table-column>

                    <el-table-column width="300" :align="contents.tableAlign"
                                     header-align="center"
                                     label="操作">
                        <template slot-scope="scope">
                            <el-button v-if="sessionTable=='false'" type="primary" size="mini" @click="wuyong(scope.row.id)">无用按钮</el-button>
                            <el-button v-if="sessionTable=='false'" type="success" icon="el-icon-printer" size="mini" @click="dayinOpen(scope.row)">打印</el-button>
                            <el-button v-if="isAuth('xunwu','查看')" type="success" icon="el-icon-tickets" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">详情</el-button>
                            <el-button v-if="isAuth('xunwu','修改')" type="primary" icon="el-icon-edit" size="mini" @click="addOrUpdateHandler(scope.row.id)">修改</el-button>
                            <el-button v-if="isAuth('xunwu','删除')" type="danger" icon="el-icon-delete" size="mini" @click="deleteHandler(scope.row.id)">删除</el-button>
                            <el-button v-if="isAuth('xunwu','修改')" type="primary" icon="el-icon-tickets" size="mini" @click="shangxia(scope.row.id,scope.row.shangxiaTypes)">{{scope.row.shangxiaTypes == 1?'下架':'上架'}}</el-button>
                            <el-button v-if="isAuth('xunwu','审核') && scope.row.xunwuYesnoTypes == 1 " type="primary" icon="el-icon-thumb" size="mini" @click="openYesnoTypes(scope.row.id)">审核</el-button>

                        </template>
                    </el-table-column>
                </el-table>
                <el-pagination
                        clsss="pages"
                        :layout="layouts"
                        @size-change="sizeChangeHandle"
                        @current-change="currentChangeHandle"
                        :current-page="pageIndex"
                        :page-sizes="[10, 20, 50, 100]"
                        :page-size="Number(contents.pageEachNum)"
                        :total="totalPage"
                        :small="contents.pageStyle"
                        class="pagination-content"
                        :background="contents.pageBtnBG"
                        :style="{textAlign:contents.pagePosition==1?'left':contents.pagePosition==2?'center':'right'}"
                ></el-pagination>
            </div>
        </div>
        <!-- 添加/修改页面  将父组件的search方法传递给子组件-->
        <add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>


        <el-dialog title="打印" :visible.sync="printVisiable" width="500px">
            <el-form ref="printContent" :model="printFrom" label-width="auto">
                <el-form-item label="发件人">
                    <div  style="display: flex">
                        <el-input v-model="printFrom.kuaidiFajianName" disabled></el-input>
                        :
                        <el-input v-model="printFrom.kuaidiFajianShoujihao" disabled></el-input>
                    </div>
                </el-form-item>
                <el-form-item label="发件人地址">
                    <el-input v-model="printFrom.kuaidiFajianAddress" disabled></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
              <el-button @click="printContent()" icon="el-icon-printer" type="success">打印</el-button>
              <el-button @click="printVisiable = false">关闭</el-button>
            </span>
        </el-dialog>

        <el-dialog title="统计报表" :visible.sync="chartVisiable" width="80%">
            <el-date-picker v-model="echartsDate" type="year" placeholder="选择年"> </el-date-picker>
            <el-button @click="chartDialog()">查询</el-button>
                <div id="statistic" style="width:100%;height:600px;"></div>

            <span slot="footer" class="dialog-footer">
				<el-button @click="chartVisiable = false">关闭</el-button>
			</span>
        </el-dialog>

    </div>
</template>
<script>
    import AddOrUpdate from "./add-or-update";
    import styleJs from "../../../utils/style.js";
    import utilsJs, {getYearFormat,getMonthFormat,getDateFormat,getDatetimeFormat} from "../../../utils/utils.js";

    export default {
        data() {
        return {
            //打印开始
            printFrom: {
                name1:"",
            },
            printVisiable: false,
            //打印结束
            searchForm: {
                key: ""
            },
            sessionTable : "",//登录账户所在表名
            role : "",//权限
            userId:"",//当前登录人的id
    //级联表下拉框搜索条件
    //当前表下拉框搜索条件
              xunwuTypesSelectSearch : [],
              xunwuYesnoTypesSelectSearch : [],
            form:{
                id : null,
                yonghuId : null,
                xunwuName : null,
                xunwuUuidNumber : null,
                xunwuPhoto : null,
                xunwuTime : null,
                xunwuAddress : null,
                xunwuTypes : null,
                xunwuYesnoTypes : null,
                xunwuYesnoText : null,
                xunwuShenheTime : null,
                xunwuContent : null,
                shangxiaTypes : null,
                xunwuDelete : null,
                insertTime : null,
                createTime : null,
            },
            dataList: [],
            pageIndex: 1,
            pageSize: 10,
            totalPage: 0,
            dataListLoading: false,
            dataListSelections: [],
            showFlag: true,
            sfshVisiable: false,
            shForm: {},
            chartVisiable: false,
            echartsDate: new Date(),//echarts的时间查询字段
            addOrUpdateFlag:false,
            contents:null,
            layouts: '',

            xunwuYesnoTypesVisible : false,

            //导出excel
            json_fields: {
                //级联表字段
                     '用户编号': 'yonghuUuidNumber',
                     '用户姓名': 'yonghuName',
                     '用户手机号': 'yonghuPhone',
                     '用户身份证号': 'yonghuIdNumber',
                     '用户头像': 'yonghuPhoto',
                     '用户邮箱': 'yonghuEmail',
                //本表字段
                     '寻物名称': "xunwuName",
                     '寻物编号': "xunwuUuidNumber",
                     '寻物照片': "xunwuPhoto",
                     '时间': "xunwuTime",
                     '寻物地点': "xunwuAddress",
                     '寻物类型': "xunwuValue",
                     '申请状态': "xunwuYesnoValue",
                     '审核意见': "xunwuYesnoText",
                     '审核时间': "xunwuShenheTime",
                     '是否上架': "shangxiaValue",
                     '录入时间': "insertTime",
            },

            };
        },
        created() {
            this.contents = styleJs.listStyle();
            this.init();
            this.getDataList();
            this.contentStyleChange()
        },
        mounted() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");

        },
        filters: {
            htmlfilter: function (val) {
                return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
            }
        },
        components: {
            AddOrUpdate,
        },
        computed: {
            getActionUrl: function() {
                return `/`+this.$base.name+`/file/upload`;
            }
        },
        methods: {
            chartDialog() {
                let _this = this;
                let params = {
                    dateFormat :"%Y", //%Y-%m
                    riqi :getYearFormat(_this.echartsDate),//年
                    // riqi :getMonthFormat(_this.echartsDate),//年月
                    thisTable : {//当前表
                        tableName :'xunwu',//当前表表名,
                        sumColum : 'xunwu_number', //求和字段
                        date : 'insert_time',//分组日期字段
                        // string : 'xunwu_name',//分组字符串字段
                        // types : 'xunwu_types',//分组下拉框字段
                    },
                    // joinTable : {//级联表（可以不存在）
                    //     tableName :'yonghu',//级联表表名
                    //     // date : 'insert_time',//分组日期字段
                    //     string : 'yonghu_name',//分组字符串字段
                    //     // types : 'yonghu_types',//分组下拉框字段
                    // }
                }
                _this.chartVisiable = true;
                _this.$nextTick(() => {
                    var statistic = this.$echarts.init(document.getElementById("statistic"), 'macarons');
                    this.$http({
                        url: "barSum",//barCountOne barCountTwo barSumOne barSumTwo
                        method: "get",
                        params: params
                    }).then(({data}) => {
                        if(data && data.code === 0){
                            let yAxisName = "数值";//y轴
                            let xAxisName = "月份";//x轴
                            let series = [];//具体数据值
                            data.data.yAxis.forEach(function (item,index) {//点击可关闭的按钮字符串在后台方法中
                                let tempMap = {};
                                tempMap.name=data.data.legend[index];
                                tempMap.type='bar';
                                tempMap.data=item;
                                series.push(tempMap);
                            })

                            var option = {
                                tooltip: {
                                    trigger: 'axis',
                                    axisPointer: {
                                        type: 'cross',
                                        crossStyle: {
                                            color: '#999'
                                        }
                                    }
                                },
                                toolbox: {
                                    feature: {
                                        // dataView: { show: true, readOnly: false },  // 数据查看
                                        magicType: { show: true, type: ['line', 'bar'] },//切换图形展示方式
                                        // restore: { show: true }, // 刷新
                                        saveAsImage: { show: true }//保存
                                    }
                                },
                                legend: {
                                    data: data.data.legend//标题  可以点击导致某一列数据消失
                                },
                                xAxis: [
                                    {
                                        type: 'category',
                                        axisLabel:{interval: 0},
                                        name: xAxisName,
                                        data: data.data.xAxis,
                                        axisPointer: {
                                            type: 'shadow'
                                        }
                                    }
                                ],
                                yAxis: [
                                    {
                                        type: 'value',//不能改
                                        name: yAxisName,//y轴单位
                                        axisLabel: {
                                            formatter: '{value}' // 后缀
                                        }
                                    }
                                ],
                                series:series//具体数据
                            };
                            statistic.setOption(option,true);
                            window.onresize = function () {
                                statistic.resize();
                            };
                        }else {
                            this.$message({
                                message: "报表未查询到数据",
                                type: "success",
                                duration: 1500,
                                onClose: () => {
                                    this.search();
                                }
                            });
                        }
                    });
                });
                ////饼状图
                //_this.chartVisiable = true;
                // this.$nextTick(()=>{
                //     var statistic = this.$echarts.init(document.getElementById("statistic"),'macarons');
                //     let params = {
                //         tableName: "xunwu",
                //         groupColumn: "xunwu_types",
                //// riqi :getMonthFormat(_this.echartsDate),//年月
                //     }
                //     this.$http({
                //         url: "newSelectGroupCount",//pieSum pieCount
                //         method: "get",
                //         params: params
                //     }).then(({data}) => {
                //         if (data && data.code === 0) {
                //             let res = data.data;
                //             let xAxis = [];
                //             let yAxis = [];
                //             let pArray = []
                //             var option = {};
                //             for(let i=0;i<res.length;i++){
                //                 xAxis.push(res[i].name);
                //                 yAxis.push(res[i].value);
                //                 pArray.push({
                //                     value: res[i].value,
                //                     name: res[i].name
                //                 })
                //                 option = {
                //                     title: {
                //                         text: '保险合同类型统计',
                //                         left: 'center'
                //                     },
                //                     tooltip: {
                //                         trigger: 'item',
                //                         formatter: '{b} : {c} ({d}%)'
                //                     },
                //                     legend: {
                //                         orient: 'vertical',
                //                         left: 'left'
                //                     },
                //                     series: [
                //                         {
                //                             type: 'pie',
                //                             radius: '55%',
                //                             center: ['50%', '60%'],
                //                             data: pArray,
                //                             emphasis: {
                //                                 itemStyle: {
                //                                     shadowBlur: 10,
                //                                     shadowOffsetX: 0,
                //                                     shadowColor: 'rgba(0, 0, 0, 0.5)'
                //                                 }
                //                             }
                //                         }
                //                     ]
                //                 };
                //             }
                //             statistic.setOption(option,true);
                //             window.onresize = function() {
                //                 statistic.resize();
                //             };
                //         }
                //     });
                // })
            },
            contentStyleChange() {
                this.contentSearchStyleChange()
                this.contentBtnAdAllStyleChange()
                this.contentSearchBtnStyleChange()
                this.contentTableBtnStyleChange()
                this.contentPageStyleChange()
            },
            contentSearchStyleChange() {
                this.$nextTick(() => {
                    document.querySelectorAll('.form-content .slt .el-input__inner').forEach(el => {
                        let textAlign = 'left'
                        if(this.contents.inputFontPosition == 2)
                            textAlign = 'center'
                            if (this.contents.inputFontPosition == 3) textAlign = 'right'
                                el.style.textAlign = textAlign
                            el.style.height = this.contents.inputHeight
                            el.style.lineHeight = this.contents.inputHeight
                            el.style.color = this.contents.inputFontColor
                            el.style.fontSize = this.contents.inputFontSize
                            el.style.borderWidth = this.contents.inputBorderWidth
                            el.style.borderStyle = this.contents.inputBorderStyle
                            el.style.borderColor = this.contents.inputBorderColor
                            el.style.borderRadius = this.contents.inputBorderRadius
                            el.style.backgroundColor = this.contents.inputBgColor
                    })
                    if (this.contents.inputTitle) {
                        document.querySelectorAll('.form-content .slt .el-form-item__label').forEach(el => {
                            el.style.color = this.contents.inputTitleColor
                            el.style.fontSize = this.contents.inputTitleSize
                            el.style.lineHeight = this.contents.inputHeight
                        })
                    }
                    setTimeout(() => {
                        document.querySelectorAll('.form-content .slt .el-input__prefix').forEach(el => {
                            el.style.color = this.contents.inputIconColor
                            el.style.lineHeight = this.contents.inputHeight
                        })
                        document.querySelectorAll('.form-content .slt .el-input__suffix').forEach(el => {
                            el.style.color = this.contents.inputIconColor
                            el.style.lineHeight = this.contents.inputHeight
                        })
                        document.querySelectorAll('.form-content .slt .el-input__icon').forEach(el => {
                            el.style.lineHeight = this.contents.inputHeight
                        })
                    }, 10 )
                })
            },
            // 搜索按钮
            contentSearchBtnStyleChange() {
                this.$nextTick(() => {
                    document.querySelectorAll('.form-content .slt .el-button--success').forEach(el => {
                        el.style.height = this.contents.searchBtnHeight
                        el.style.color = this.contents.searchBtnFontColor
                        el.style.fontSize = this.contents.searchBtnFontSize
                        el.style.borderWidth = this.contents.searchBtnBorderWidth
                        el.style.borderStyle = this.contents.searchBtnBorderStyle
                        el.style.borderColor = this.contents.searchBtnBorderColor
                        el.style.borderRadius = this.contents.searchBtnBorderRadius
                        el.style.backgroundColor = this.contents.searchBtnBgColor
                    })
                })
            },
            // 新增、批量删除
            contentBtnAdAllStyleChange() {
                this.$nextTick(() => {
                    document.querySelectorAll('.form-content .ad .el-button--success').forEach(el => {
                        el.style.height = this.contents.btnAdAllHeight
                        el.style.color = this.contents.btnAdAllAddFontColor
                        el.style.fontSize = this.contents.btnAdAllFontSize
                        el.style.borderWidth = this.contents.btnAdAllBorderWidth
                        el.style.borderStyle = this.contents.btnAdAllBorderStyle
                        el.style.borderColor = this.contents.btnAdAllBorderColor
                        el.style.borderRadius = this.contents.btnAdAllBorderRadius
                        el.style.backgroundColor = this.contents.btnAdAllAddBgColor
                    })
                    document.querySelectorAll('.form-content .ad .el-button--danger').forEach(el => {
                        el.style.height = this.contents.btnAdAllHeight
                        el.style.color = this.contents.btnAdAllDelFontColor
                        el.style.fontSize = this.contents.btnAdAllFontSize
                        el.style.borderWidth = this.contents.btnAdAllBorderWidth
                        el.style.borderStyle = this.contents.btnAdAllBorderStyle
                        el.style.borderColor = this.contents.btnAdAllBorderColor
                        el.style.borderRadius = this.contents.btnAdAllBorderRadius
                        el.style.backgroundColor = this.contents.btnAdAllDelBgColor
                    })
                    document.querySelectorAll('.form-content .ad .el-button--warning').forEach(el => {
                        el.style.height = this.contents.btnAdAllHeight
                        el.style.color = this.contents.btnAdAllWarnFontColor
                        el.style.fontSize = this.contents.btnAdAllFontSize
                        el.style.borderWidth = this.contents.btnAdAllBorderWidth
                        el.style.borderStyle = this.contents.btnAdAllBorderStyle
                        el.style.borderColor = this.contents.btnAdAllBorderColor
                        el.style.borderRadius = this.contents.btnAdAllBorderRadius
                        el.style.backgroundColor = this.contents.btnAdAllWarnBgColor
                    })
                })
            },
            // 表格
            rowStyle({row, rowIndex}) {
                if (rowIndex % 2 == 1) {
                    if (this.contents.tableStripe) {
                        return {color: this.contents.tableStripeFontColor}
                    }
                } else {
                    return ''
                }
            },
            cellStyle({row, rowIndex}) {
                if (rowIndex % 2 == 1) {
                    if (this.contents.tableStripe) {
                        return {backgroundColor: this.contents.tableStripeBgColor}
                    }
                } else {
                    return ''
                }
            },
            headerRowStyle({row, rowIndex}) {
                return {color: this.contents.tableHeaderFontColor}
            },
            headerCellStyle({row, rowIndex}) {
                return {backgroundColor: this.contents.tableHeaderBgColor}
            },
            // 表格按钮
            contentTableBtnStyleChange() {
                // this.$nextTick(()=>{
                //   setTimeout(()=>{
                //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--success').forEach(el=>{
                //       el.style.height = this.contents.tableBtnHeight
                //       el.style.color = this.contents.tableBtnDetailFontColor
                //       el.style.fontSize = this.contents.tableBtnFontSize
                //       el.style.borderWidth = this.contents.tableBtnBorderWidth
                //       el.style.borderStyle = this.contents.tableBtnBorderStyle
                //       el.style.borderColor = this.contents.tableBtnBorderColor
                //       el.style.borderRadius = this.contents.tableBtnBorderRadius
                //       el.style.backgroundColor = this.contents.tableBtnDetailBgColor
                //     })
                //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--primary').forEach(el=>{
                //       el.style.height = this.contents.tableBtnHeight
                //       el.style.color = this.contents.tableBtnEditFontColor
                //       el.style.fontSize = this.contents.tableBtnFontSize
                //       el.style.borderWidth = this.contents.tableBtnBorderWidth
                //       el.style.borderStyle = this.contents.tableBtnBorderStyle
                //       el.style.borderColor = this.contents.tableBtnBorderColor
                //       el.style.borderRadius = this.contents.tableBtnBorderRadius
                //       el.style.backgroundColor = this.contents.tableBtnEditBgColor
                //     })
                //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--danger').forEach(el=>{
                //       el.style.height = this.contents.tableBtnHeight
                //       el.style.color = this.contents.tableBtnDelFontColor
                //       el.style.fontSize = this.contents.tableBtnFontSize
                //       el.style.borderWidth = this.contents.tableBtnBorderWidth
                //       el.style.borderStyle = this.contents.tableBtnBorderStyle
                //       el.style.borderColor = this.contents.tableBtnBorderColor
                //       el.style.borderRadius = this.contents.tableBtnBorderRadius
                //       el.style.backgroundColor = this.contents.tableBtnDelBgColor
                //     })

                //   }, 50)
                // })
            },
            // 分页
            contentPageStyleChange() {
                let arr = []
                if (this.contents.pageTotal) arr.push('total')
                if (this.contents.pageSizes) arr.push('sizes')
                if (this.contents.pagePrevNext) {
                    arr.push('prev')
                    if (this.contents.pagePager) arr.push('pager')
                    arr.push('next')
                }
                if (this.contents.pageJumper) arr.push('jumper')
                this.layouts = arr.join()
                this.contents.pageEachNum = 10
            },

            init() {
            },
            search() {
                this.pageIndex = 1;
                this.getDataList();
            },
            // 获取数据列表
            getDataList() {
                this.dataListLoading = true;
                let params = {
                    page: this.pageIndex,
                    limit: this.pageSize,
                    sort: 'id',
                }

                                         
                if (this.searchForm.yonghuUuidNumber!= '' && this.searchForm.yonghuUuidNumber!= undefined) {
                    params['yonghuUuidNumber'] = '%' + this.searchForm.yonghuUuidNumber + '%'
                }
                     
                if (this.searchForm.yonghuName!= '' && this.searchForm.yonghuName!= undefined) {
                    params['yonghuName'] = '%' + this.searchForm.yonghuName + '%'
                }
                                                                                                                             
                if (this.searchForm.xunwuName!= '' && this.searchForm.xunwuName!= undefined) {
                    params['xunwuName'] = '%' + this.searchForm.xunwuName + '%'
                }
                         

                if (this.searchForm.xunwuTimeStartSearch != '' && this.searchForm.xunwuTimeStartSearch != undefined) {
                    params['xunwuTimeStart'] = this.searchForm.xunwuTimeStartSearch
                }
                if (this.searchForm.xunwuTimeEndSearch != '' && this.searchForm.xunwuTimeEndSearch != undefined) {
                    params['xunwuTimeEnd'] = this.searchForm.xunwuTimeEndSearch
                }
         
                if (this.searchForm.xunwuAddress!= '' && this.searchForm.xunwuAddress!= undefined) {
                    params['xunwuAddress'] = '%' + this.searchForm.xunwuAddress + '%'
                }
         
                if (this.searchForm.xunwuTypes!= '' && this.searchForm.xunwuTypes!= undefined) {
                    params['xunwuTypes'] = this.searchForm.xunwuTypes
                }
         
                if (this.searchForm.xunwuYesnoTypes!= '' && this.searchForm.xunwuYesnoTypes!= undefined) {
                    params['xunwuYesnoTypes'] = this.searchForm.xunwuYesnoTypes
                }
                                                        
                params['xunwuDelete'] = 1// 逻辑删除字段 1 未删除 2 删除


                this.$http({
                    url: "xunwu/page",
                    method: "get",
                    params: params
                }).then(({data}) => {
                    if(data && data.code === 0){
                        this.dataList = data.data.list;
                        this.totalPage = data.data.total;
                    }else{
                        this.dataList = [];
                        this.totalPage = 0;
                    }
                    this.dataListLoading = false;
                });

                //查询级联表搜索条件所有列表
                //查询当前表搜索条件所有列表
                //填充下拉框选项
                this.$http({
                    url: "dictionary/page?dicCode=xunwu_types&page=1&limit=100",
                    method: "get",
                }).then(({data}) => {
                    if(data && data.code === 0){
                        this.xunwuTypesSelectSearch = data.data.list;
                    }
                });
                //填充下拉框选项
                this.$http({
                    url: "dictionary/page?dicCode=xunwu_yesno_types&page=1&limit=100",
                    method: "get",
                }).then(({data}) => {
                    if(data && data.code === 0){
                        this.xunwuYesnoTypesSelectSearch = data.data.list;
                    }
                });
            },
            //每页数
            sizeChangeHandle(val) {
                this.pageSize = val;
                this.pageIndex = 1;
                this.getDataList();
            },
            // 当前页
            currentChangeHandle(val) {
                this.pageIndex = val;
                this.getDataList();
            },
            // 多选
            selectionChangeHandler(val) {
                this.dataListSelections = val;
            },
            // 添加/修改
            addOrUpdateHandler(id, type) {
                this.showFlag = false;
                this.addOrUpdateFlag = true;
                this.crossAddOrUpdateFlag = false;
                if (type != 'info') {
                    type = 'else';
                }
                this.$nextTick(() => {
                    this.$refs.addOrUpdate.init(id, type);
                });
            },
            // 下载
            download(file) {
                window.open(" ${file} ")
            },
            // 弹出打印模态框
            dayinOpen(item) {
                let _this = this;
                _this.printVisiable = true;
                _this.printFrom=item;
            },
            // 打印内容
            printContent() {
                let _this = this;
                _this.$print(_this.$refs.printContent)
                _this.printVisiable = false;
            },
            // 删除
            deleteHandler(id) {
                var ids = id ? [Number(id)] : this.dataListSelections.map(item => {
                    return Number(item.id);
                });

                this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning"
                }).then(() => {
                    this.$http({
                        url: "xunwu/delete",
                        method: "post",
                        data: ids
                    }).then(({data}) => {
                        if(data && data.code === 0){
                            this.$message({
                                message: "操作成功",
                                type: "success",
                                duration: 1500,
                                onClose: () => {
                                    this.search();
                                }
                            });
                        }else{
                            this.$message.error(data.msg);
                        }
                    });
                });
            },
            // 导入功能上传文件成功后调用导入方法
            xunwuUploadSuccess(data){
                let _this = this;
                _this.$http({
                    url: "xunwu/batchInsert?fileName=" + data.file,
                    method: "get"
                }).then(({data}) => {
                    if(data && data.code === 0){
                        _this.$message({
                            message: "导入寻物启示数据成功",
                            type: "success",
                            duration: 1500,
                            onClose: () => {
                                _this.search();
                            }
                        });
                    }else{
                        _this.$message.error(data.msg);
                    }
                });

            },
            // 导入功能上传文件失败后调用导入方法
            xunwuUploadError(data){
                this.$message.error('上传失败');
            },
	
			//上下架
			shangxia(id,shangxiaTypes){
				var msg ="";
				if(shangxiaTypes == 1){
					shangxiaTypes=2;
					msg="下架";
				}else if(shangxiaTypes == 2){
					shangxiaTypes=1;
					msg="上架";
				}
				var shuju = {
						'id':id,
						'shangxiaTypes':shangxiaTypes,
					}
				this.$confirm(`确定要将它`+msg+`吗?`, "提示", {
				    confirmButtonText: "确定",
				    cancelButtonText: "取消",
				    type: "warning"
				}).then(() => {
				   this.$http({
				        url: "xunwu/update",
				        method: "post",
				        data: shuju
				    }).then(({ data }) => {
				        if (data && data.code === 0) {
				            this.$message({
				                message: msg+"成功",
				                type: "success",
				                duration: 1500,
				                onClose: () => {this.search();}
				            });
				        } else {
				            this.$message.error(data.msg);
				        }
				    });
				});
			},            openYesnoTypes(id) {
                let _this = this;
                _this.form.id = null;
                _this.form.id = id;
                            _this.form.xunwuYesnoText = null;
                _this.form.xunwuYesnoTypes = "请选择申请状态";
                _this.xunwuYesnoTypesVisible = true;
            },

            xunwuYesnoTypesShenhe() {
                let _this = this;
                if(_this.form.xunwuYesnoTypes == "请选择申请状态"){
                    _this.$message.error("请选择申请状态");return false;
                }
                if(_this.form.xunwuYesnoText == null || _this.form.xunwuYesnoText == ""){
                    _this.$message.error("请输入审核意见");return false;
                }
                this.$http({
                    url:`xunwu/shenhe`,
                    method: "post",
                    data: _this.form
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.$message({
                            message: "审核成功",
                            type: "success",
                            duration: 1500,
                            onClose: () => {
                                _this.xunwuYesnoTypesVisible = false;
                                _this.search();
                            }
                        });
                    } else {
                        this.$message.error(data.msg);
                        _this.xunwuYesnoTypesVisible = false;
                    }
                });
            },            //无用
            wuyong(id) {
                let _this = this;
                _this.$confirm(`确定    操作?`, "提示", {confirmButtonText: "确定",cancelButtonText: "取消",type: "warning"
                }).then(() => {
                    _this.$http({
                        url: "xunwu/update",
                        method: "post",
                        data: {
                            id:id,
//                            xunwuTypes:xunwuTypes,
                        }
                    }).then(({data}) => {
                        if(data && data.code === 0){
                            _this.$message({message: "操作成功",type: "success",duration: 1500,onClose: () => {
                                    _this.search();
                                }});
                        }else{
                            _this.$message.error(data.msg);
                        }
                    });
                });
            },
        }
    };
</script>
<style lang="scss" scoped>
.slt {
    margin: 0 !important;
    display: flex;
  }

  .ad {
    margin: 0 !important;
    display: flex;
  }

  .pages {
    & /deep/ el-pagination__sizes{
      & /deep/ el-input__inner {
        height: 22px;
        line-height: 22px;
      }
    }
  }


  .el-button+.el-button {
    margin:0;
  }

  .tables {
	& /deep/ .el-button--success {
		height: 40px;
		color: #333;
		font-size: 14px;
		border-width: 2px;
		border-style: dashed ;
		border-color: rgba(255, 255, 255, 1);
		border-radius: 20px;
		background-color: var(--publicSubColor);
	}

	& /deep/ .el-button--primary {
		height: 40px;
		color: #333;
		font-size: 14px;
		border-width: 2px;
		border-style: dashed ;
		border-color: rgba(255, 255, 255, 1);
		border-radius: 20px;
		background-color: var(--publicSubColor);
	}

	& /deep/ .el-button--danger {
		height: 40px;
		color: #333;
		font-size: 14px;
		border-width: 2px;
		border-style: dashed ;
		border-color: rgba(255, 255, 255, 1);
		border-radius: 20px;
		background-color: var(--publicSubColor);
	}

    & /deep/ .el-button {
      margin: 4px;
    }
  }
	.form-content {
		background: transparent;
	}
	.table-content {
		background: transparent;
	}

	.tables /deep/ .el-table__body tr {
				background-color: rgba(255, 255, 255, 1) !important;
				color: rgba(92, 93, 95, 1) !important;
	 }
	.tables /deep/ .el-table__body tr.el-table__row--striped td {
	    background: transparent;
	}
	.tables /deep/ .el-table__body tr.el-table__row--striped {
		background-color: #F5F7FA !important;
		color: #606266 !important;
	}

	.tables /deep/ .el-table__body tr:hover>td {
	   background-color: #f5f5f5 !important;
		   color: #333 !important;
 	}</style>


