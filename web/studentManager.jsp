<%--
  Created by IntelliJ IDEA.
  User: du
  Date: 2018/12/7
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>主页</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min1.3.5.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min1.3.5.js"></script>
    <script  src="js/easyui-lang-zh_CN1.3.5.js" type="text/javascript"></script>

    <link href="${pageContext.request.contextPath}/themes1.3.5/icon.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/themes1.3.5/default/easyui.css" rel="stylesheet" type="text/css"/>

    <script>
        $(function () {
            $("#myDatagrid").datagrid({
                title:"学生管理系统",
                url:"selectByPage.do",
                pagination:true,
                columns:[[
                    {checkbox:true},
                    {field:'stuId',title:'学生id',width:100},
                    {field:'stuName',title:'姓名',width:100},
                    {field:'stuAge',title:'学生年龄',width:100,align:'right'},
                    {field:'stuGender',title:'性别',width:100,formatter:function (value,row,index) {
                            // alert(value);
                            // console.log(value);
                            if (value=="0" ) {
                                // alert("true")
                                return"男";
                            }else{
                                // alert("vvv");
                                return "女";
                            }
                        }
                        },
                ]],
                toolbar: [{
                    iconCls: 'icon-remove',
                    handler: function(){
                        // alert('删除');
                        var selectRows=$("#myDatagrid").datagrid("getSelections");
                        if (selectRows.length == 0) {
                            $.messager.alert("删除提示", "删除内容为空，请选择要删除的内容", "info");
                        }else {
                            $.messager.confirm("确认删除的内容","请确认是否删除选中的内容",function (result) {
                                if (result) {
                                    //创建一个数组，用户存放用户id
                                    var stuIds = new Array(selectRows.length);
                                    for (var i = 0; i < selectRows.length; i++) {
                                        stuIds[i]=selectRows[i].stuId;
                                    };

                                    $.ajax({

                                        url:"deleteIds.do",
                                        data: "ids=" + stuIds,
                                        success:function (data) {
                                            if (data) {
                                                $.messager.alert("删除提示", "删除成功！", "info");
                                                $("#myDatagrid").datagrid("reload");
                                            }else {
                                                $.messager.alert("删除提示", "删除失败，请检查要删除的选项！", "warning");
                                            }

                                        }


                                    });
                                }
                            });
                        }
                    }

                }],

                onDblClickRow:function (rowIndex,rowDate) {
                    openDialog(rowIndex, rowDate);
                    
                }
            });

            $("#updateDialog").dialog({
                title:"修改学生信息",
                width: 270,
                height: 130,
                closed:true
            });

            $("#updateUserForm").form({
                url:"updateStudent.do",
                success:function(data){
                    // alert(data);
                    if (data=="true") {
                        $("#updateDialog").dialog("close");
                        $("#myDatagrid").datagrid("reload");
                    }else {
                        alert("修改有误！");
                    }
                }
            });

        });

        function doSearch() {
            $("#myDatagrid").datagrid("load", {"stuName":$("#searchStuName").val()});

        }

        function openDialog(rowIndex, rowDate) {
            $("#updateDialog").dialog("open");
            $("#stuId").val(rowDate.stuId);
            $("#stuName").val(rowDate.stuName);
            $("#stuAge").val(rowDate.stuAge);


            if (rowDate.stuGender == "0") {
                $("#stuGender").prop("checked", true);
            }else {
                $("#stuGender2").prop("checked", true);
            }

        }

        function doUpdateStu() {
            $("#updateUserForm").form("submit");

        }



    </script>
  </head>
  <body>

      学生名字：<input type="text" id="searchStuName" /> <input type="submit" value="搜索" onclick="doSearch()">
      <table id="myDatagrid"></table>
      <div id="updateDialog" >
        <form id="updateUserForm" method="post">
          用户名：<input type="text" name="stuName" id="stuName"><br/>
          学生年龄：<input type="text" name="stuAge" id="stuAge"><br/>
          <input type="hidden" name="stuId" id="stuId">
          学生性别：<input type="radio" name="stuGender" id="stuGender" value="0">男<input type="radio" name="stuGender" id="stuGender2" value="1">女 <br/>
          <input type="submit" value="添加" onclick="doUpdateStu()">
        </form>
      </div>

  </body>
</html>
