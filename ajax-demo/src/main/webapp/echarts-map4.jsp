<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8" />
<title>echarts-map3</title>

<head>

<style type="text/css">
	.mapContainer {
		display: grid;
		height: 100vh;
		width: 100vw;
		grid-template-rows: 100%;
		grid-template-columns: 100%;
	}
	/*mapDemo1      */
	#mapDemo1 {
		width: 100%;
		height: 100%;
	}
</style>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/echarts.min.js"></script>
</head>

<body>

	<p>echarts-map3</p>
	<br />
	<!-- 建立一个有高度和宽度的dom(建议div) -->

	<div class="mapContainer">
		<div id="mapDemo1"></div>
	</div>
</body>
<script type="text/javascript">
$(function () {  
    paintMap1();  
});  
  
function paintMap1() {  
    var mapChart = echarts.init($('#mapDemo1')[0]);  
    var option = {  
        //backgroundColor: '#031f2d',//画布背景颜色  
        series:[{  
            type: 'map',  
            map: 'china',  
            roam: true,//允许缩放和平移  
            //初始化时的地图位置，可通过改变地图中心视角的经纬度来实现地图的平移  
            center: [100.97, 35.71],  
            zoom: 0.9, //地图缩放多少倍  
            selectedMode: true, //点击区域，会处于选中状态，多选  
            label: {//设置地图区域名的文本样式，例如地名的字体大小等  
                normal: {  
                    show: true, //显示地区的文本名称,默认是不显示的，默认状态是hoverORclick才显示  
                    fontSize: 12,  
                    fontFamily: '微软雅黑',  
                    fontWeight: 'bolder',  
                    position: 'center',  
                }  
            },  
            itemStyle: {//地图区域的多边形图形样式  
                normal: {  
                    areaColor: '#11b2fc',//地图区域颜色  
                    borderColor: 'orange',//图形的描边颜色  
                    borderWidth: 1,//描边线宽。为 0 时无描边  
                    borderType: 'solid',  
                    opacity: 0.6  
                }  
            },  
            //zlevel: 1//zlevel用于 Canvas 分层，不同zlevel值的图形会放置在不同的 Canvas 中  
            //z: 1//组件的所有图形的z值。控制图形的前后顺序。z值小的图形会被z值大的图形覆盖。  
            //layoutCenter: ['50%', '50%'],//设置这两个值后 left/right/top/bottom/width/height 无效。  
            //layoutSize: 1000  
            //data: [],  
            markPoint: {  
                symbol: 'diamond',  
                symbolSize: 20,  
                silent: false,  
                label: {//标注的文本  
                    normal: {  
                        show: true,//即是否显示标注的名称（data:name）  
                        formatter: '{b}:{c}'//模板变量有 {a}、{b}、{c}，分别表示系列名，数据名，数据值。  
                    }  
                },  
                itemStyle: {//标注的样式。  
                    normal: {  
                        color: 'red'  
                    }  
                },  
                data: [  
                    {  
                        //method1: 通过屏幕坐标指明标注的位置，屏幕左上角为[0,0]  
                        name: 'method1',  
                        value: '100',  
                        x: '50%',  
                        y: '400'  
  
                    },  
                    {  
                        //method2： 通过经纬度指明标注的位置，该方法是独立的，不是必须搭配geo属性  
                        name: 'method2',  
                        value: '200',  
                        coord: [113.23,23.16]  
                    }  
                ],  
                silent: true,  
                //tooltip: {}  
  
            }  
        }]  
    }  
    $.get('map/china.json', function (chinaJson) {  
        echarts.registerMap('china', chinaJson);  
        mapChart.setOption(option);  
    });  
}  
</script>
</html>
