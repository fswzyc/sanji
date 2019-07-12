<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    
    <script src="js/jquery-1.12.4.min.js"></script>
    
    <script>
        $(function () {
           
            //发送ajax请求，加载所有省份数据
            $.get("showAllProvince",{},function (data) {
                //[{"id":1,"name":"北京"},{"id":2,"name":"上海"},{"id":3,"name":"广州"},{"id":4,"name":"陕西"}]

                //1.获取select
                var province = $("#province");
                //2.遍历json数组
                province.html("<option>--请选择省份--</option>");
                $(data).each(function () {
                    //3.创建<option>
                    var option = "<option value='"+this.id+"'>"+this.name+"</option>";

                    //4.调用select的append追加option
                    province.append(option);
                });
            });
        });

        function showCity() {
            var data = {"id":$("#province option:checked").val()};

            //发送ajax请求，加载所有省份数据
            $.get("showAllCity", data, function (data) {
                //[{"id":1,"name":"北京"},{"id":2,"name":"上海"},{"id":3,"name":"广州"},{"id":4,"name":"陕西"}]
                //1.获取select
                var city = $("#city");
                city.html("<option>--请选择城市--</option>");
                //2.遍历json数组
                $(data).each(function () {
                    //3.创建<option>

                    var option = "<option value='"+this.id+"'>"+this.name+"</option>";

                    //4.调用select的append追加option
                    city.append(option);

                });
            });
        }

        function showCountry() {
            var data = {"id":$("#city option:checked").val()};

            //发送ajax请求，加载所有省份数据
            $.get("showAllCountry", data, function (data) {
                //[{"id":1,"name":"北京"},{"id":2,"name":"上海"},{"id":3,"name":"广州"},{"id":4,"name":"陕西"}]
                //1.获取select
                var country = $("#country");
                country.html("<option>--请选择区县--</option>");
                //2.遍历json数组
                $(data).each(function () {
                    //3.创建<option>
                    var option = "<option value='"+this.id+"'>"+this.name+"</option>";

                    //4.调用select的append追加option
                    country.append(option);
                });
            });
        }
        
    </script>
    
</head>
<body>



        <select id="province" onchange="showCity()">
            <option>--请选择省份--</option>

        </select>

        <select id="city" onchange="showCountry()">
            <option>--请选择城市--</option>

        </select>

        <select id="country">
            <option>--请选择区县--</option>

        </select>
</body>
</html>